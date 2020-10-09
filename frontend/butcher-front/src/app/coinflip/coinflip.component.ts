import { Component, OnInit } from '@angular/core';
import {GameSocketService} from "../../services/socket/game/game-socket.service";

@Component({
  selector: 'app-coinflip',
  templateUrl: './coinflip.component.html',
  styleUrls: ['./coinflip.component.scss']
})
export class CoinflipComponent implements OnInit {

  constructor(private gameSockerService: GameSocketService) { }

  ngOnInit(): void {
    this.gameSockerService.onGameStarts().then((data)=>{

    })
  }
}
