import { Component, OnInit } from '@angular/core';
import {PlayerRestService} from "../../services/rest/player/player-rest.service";
import {GameRestService} from "../../services/rest/game/game-rest.service";
import {GameStatsModel} from "../../model/rest/game/game-stats.model";

@Component({
  selector: 'app-team-selection',
  templateUrl: './team-selection.component.html',
  styleUrls: ['./team-selection.component.scss']
})
export class TeamSelectionComponent implements OnInit {

  gameObject:GameStatsModel;

  constructor(private playerRestService:PlayerRestService,
              private gameRestService: GameRestService) { }

  ngOnInit(): void {
    this.gameRestService.getGame().subscribe((game)=> this.gameObject = game);
  }

  selectTeam(id: number) {
    this.playerRestService.selectTeam(id);
  }
}
