import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {TeamModel} from "../../../model/rest/team/team.model";

@Injectable({
  providedIn: 'root'
})
export class TeamRestService {

  private readonly apiSubRoute: string = "/team";

  constructor(private httpClient: HttpClient) { }

  getAll():Observable<TeamModel[]>{
    return this.httpClient.get<TeamModel[]>(environment.backend_api+this.apiSubRoute+"/");
  }
}
