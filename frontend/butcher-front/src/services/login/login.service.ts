import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {LoginModel} from "../../model/login/login.model";
import {environment} from "../../environments/environment";
import {log} from "util";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly apiSubRoute: string = "/user";

  constructor(private httpClient: HttpClient) {
  }

  public guestLogin(){
    return this.httpClient.post(environment.backend_api  + this.apiSubRoute +"/guest-login", {});
  }

  public login(loginModel: LoginModel){
    return this.httpClient.post(environment.backend_api + this.apiSubRoute+"/login",loginModel);
  }

  public logout(){
    return this.httpClient.get(environment.backend_url + this.apiSubRoute +"/logout", {});
  }

  register(loginModel: LoginModel) {
    return this.httpClient.post(environment.backend_url + this.apiSubRoute +"/register",loginModel);
  }
}
