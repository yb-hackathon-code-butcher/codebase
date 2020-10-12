import {Component, OnInit} from '@angular/core';
import {GameSocketService} from '../services/socket/game/game-socket.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'butcher-front';

  constructor(private socketService: GameSocketService) {
  }

  ngOnInit(): void {
    this.socketService.sendJoin();

  }


}
