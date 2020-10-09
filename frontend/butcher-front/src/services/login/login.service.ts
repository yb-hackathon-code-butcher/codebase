import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly loginSocket;

  constructor(private httpClient: HttpClient) {
  }

  public guestLogin(){

  }

  public login(username:string, pw: string){

  }

  public logout(){

  }
}
