import {Component, OnInit} from '@angular/core';
import {GameRestService} from "../../services/rest/game/game-rest.service";
import * as ProgressBar from "progressbar.js"
import {GameSocketService} from '../../services/socket/game/game-socket.service';
import {CountdownService} from '../../services/common/countdown.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-countdown',
  templateUrl: './countdown.component.html',
  styleUrls: ['./countdown.component.scss']
})
export class CountdownComponent implements OnInit {
  start: Date;

  constructor(private gameRestService: GameRestService,
              private gameSocketService: GameSocketService,
              private countdownService: CountdownService,
              private router: Router) {

  }

  ngOnInit(): void {
    let bar = new ProgressBar.Circle("#circle-container", {
      strokeWidth: 40,
      easing: 'easeInOut',
      duration: 1000,
      color: '#FFD300',
      trailColor: '#000',
      trailWidth: 0.0001,
      svgStyle: null
    });
    bar.set(1);
    this.gameSocketService.sendJoin();
    this.gameRestService.getGame().subscribe((game) => {
      if (game !== undefined) {
        this.start = new Date(game.game.startTime);
        let initDistance = this.start.getTime() - Date.now();
        this.countdownService.getCountdown(this.start).subscribe((newTime) => {
          bar.animate(1-(initDistance - newTime.distance) / initDistance);
        });
      }
    });

  }

  navigateToGame() {
    this.router.navigateByUrl('coinflip');
  }
}
