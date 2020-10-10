import {Component, OnInit} from '@angular/core';
import {GameRestService} from "../../services/rest/game/game-rest.service";
import {GameStatsModel} from "../../model/rest/game/game-stats.model";

@Component({
  selector: 'app-coinflip',
  templateUrl: './coinflip.component.html',
  styleUrls: ['./coinflip.component.scss']
})
export class CoinflipComponent implements OnInit {

  game: GameStatsModel;

  winner: number = 1;

  constructor(private gameRestService: GameRestService) {
  }

  ngOnInit(): void {
    this.gameRestService.getGame().subscribe((game) => {
      this.game = game;
    })
  }


}
