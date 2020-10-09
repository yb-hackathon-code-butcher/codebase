import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {GameStatsModel} from "../../../model/rest/game/game-stats.model";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class GameRestService {

  private readonly apiSubRoute: string = "/game";

  constructor(private httpClient: HttpClient) {}

  getGame():Observable<GameStatsModel>{
    return this.httpClient.get<GameStatsModel>(environment.backend_api+ this.apiSubRoute + "/");
  }
}
