import {Injectable} from '@angular/core';
import {v4 as uuidv4} from 'uuid';
import {PlayerModel} from '../../model/rest/player/player.model';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {LoginModel} from '../../model/rest/login/login.model';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentPlayer: PlayerModel;

  constructor(private loginService: LoginService) {
  }

  public createUUID() {
    if (!this.isAuthenticated()) {
      let uuid = uuidv4();
      localStorage.setItem('uuid-code-butcher', uuid);
      return uuid
    }
    return this.getUUID();
  }

  public isAuthenticated() {
    return localStorage.getItem('uuid-code-butcher') !== undefined;
  }

  public getUUID() {
    return localStorage.getItem('uuid-code-butcher');
  }

  guestLogin(uuid: string) {
    return this.loginService.guestLogin(uuid).pipe(tap((player) => this.currentPlayer = player));
  }
}


@Injectable({
  providedIn: 'root'
})
class LoginService {

  private readonly apiSubRoute: string = "/players";

  constructor(private httpClient: HttpClient) {
  }

  guestLogin(uuid: string): Observable<PlayerModel> {
    return this.httpClient.post<PlayerModel>(environment.backend_api + this.apiSubRoute + "/", {uid: uuid});
  }

  login(loginModel: LoginModel) {
    return this.httpClient.post(environment.backend_api + this.apiSubRoute + "/login", loginModel);
  }

  logout() {
    return this.httpClient.get(environment.backend_api + this.apiSubRoute + "/logout", {});
  }

  register(loginModel: LoginModel) {
    return this.httpClient.post(environment.backend_api + this.apiSubRoute + "/register", loginModel);
  }
}
