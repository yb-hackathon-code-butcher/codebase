import { Component, OnInit } from '@angular/core';
import {GameRestService} from "../../services/rest/game/game-rest.service";

@Component({
  selector: 'app-countdown',
  templateUrl: './countdown.component.html',
  styleUrls: ['./countdown.component.scss']
})
export class CountdownComponent implements OnInit {
  start: Date;

  constructor(private gameRestService: GameRestService) {

  }

  ngOnInit(): void {
    this.gameRestService.getGame().subscribe((game) => {
      if(game !== undefined){
        this.start = game.game.startTime;
      }
    });
    this.start = new Date("Oct 10, 2020 11:00:00");
  }

}
