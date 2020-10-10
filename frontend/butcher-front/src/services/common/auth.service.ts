import { Injectable } from '@angular/core';
import { v4 as uuidv4 } from 'uuid';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor() {
  }

  public createUUID(){
    let uuid = uuidv4();
    localStorage.setItem('uuid-code-butcher', uuid);
    return uuid;
  }

  public isAuthenticated(){
    return localStorage.getItem('uuid-code-butcher') !== undefined;
  }

  public getUUID(){
    return localStorage.getItem('uuid-code-butcher');
  }
}
