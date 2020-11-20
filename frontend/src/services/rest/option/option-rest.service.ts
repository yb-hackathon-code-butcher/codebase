import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {OptionModel} from "../../../model/rest/option/option.model";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class OptionRestService {

  private readonly apiSubRoute: string = "/option";

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<OptionModel[]> {
    return this.httpClient.get<OptionModel[]>(environment.backend_api + this.apiSubRoute + "/");
  }
}
