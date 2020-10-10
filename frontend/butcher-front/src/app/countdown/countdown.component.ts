import { Component, OnInit } from '@angular/core';
import {GameRestService} from "../../services/rest/game/game-rest.service";
import * as ProgressBar from "progressbar.js"

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
    this.start = new Date("Oct 10, 2020 02:05:00");
    let init = Date.now();
    let bar = new ProgressBar.Circle("#circle-container", {
      strokeWidth: 40,
      easing: 'easeInOut',
      duration: 1000,
      color: '#FFD300',
      trailColor: '#000',
      trailWidth: 0.0001,
      svgStyle: null
    });
    let initDiff = this.start.getTime() - init;
    setInterval(()=>{
      let diff = this.start.getTime() - Date.now();
      console.log((initDiff- diff)/initDiff);
      bar.animate((initDiff- diff)/initDiff);
    },1000);
  }

}
