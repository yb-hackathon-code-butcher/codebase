import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {PlayerModel} from "../../../model/rest/player/player.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PlayerRestService {

  private readonly apiSubRoute: string = "/player";

  constructor(private httpClient: HttpClient) { }

  get(id:number): Observable<PlayerModel>{
    return this.httpClient.get<PlayerModel>(environment.backend_api+this.apiSubRoute+"/"+id);
  }

  edit(player: PlayerModel){
    return this.httpClient.put(environment.backend_api+this.apiSubRoute+"/", player);
  }
  selectTeam(teamId:number){
    return this.httpClient.post(environment.backend_api+this.apiSubRoute+"/select-team",{"teamId":teamId});
  }
}
