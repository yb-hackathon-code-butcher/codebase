import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {LoginModel} from "../../../model/rest/login/login.model";
import {environment} from "../../../environments/environment";
import {log} from "util";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly apiSubRoute: string = "/players";

  constructor(private httpClient: HttpClient) {
  }

  public guestLogin(uuid: string){
    return this.httpClient.post(environment.backend_api  + this.apiSubRoute +"/", {uid:uuid});
  }

  public login(loginModel: LoginModel){
    return this.httpClient.post(environment.backend_api + this.apiSubRoute+"/login",loginModel);
  }

  public logout(){
    return this.httpClient.get(environment.backend_api + this.apiSubRoute +"/logout", {});
  }

  register(loginModel: LoginModel) {
    return this.httpClient.post(environment.backend_api + this.apiSubRoute +"/register",loginModel);
  }
}
