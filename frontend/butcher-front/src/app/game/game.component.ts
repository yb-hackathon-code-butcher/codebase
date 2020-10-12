import {Component, OnInit} from '@angular/core';
import {OptionRestService} from '../../services/rest/option/option-rest.service';
import {OptionModel} from '../../model/rest/option/option.model';
import {GameRestService} from '../../services/rest/game/game-rest.service';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.scss']
})
export class GameComponent implements OnInit {
  voteResults = [
    {percent: 10},
    {percent: 20},
    {percent: 70}
  ];
  opponentName = "FC Basel";
  teamName = "BSC YB";
  options = [
    {name: 'Option 1', chance: 30},
    {name: 'Option 2', chance: 30},
    {name: 'Option 3', chance: 30},
    {name: 'Option 4', chance: 30},
  ];
  roundEndDate = new Date("Oct 10, 2020 11:00:00");
  teamWithBallPossession = 'YB';
  score = {teamA: 0, teamB: 0};
  tempResults = [
    {percent: 10},
    {percent: 30},
    {percent: 50},
    {percent: 10},
  ];
  allAvailableOptions: OptionModel[];

  constructor(private optionService: OptionRestService,
              private gameRestService: GameRestService) { }

  ngOnInit(): void {
    this.gameRestService.getGame().subscribe((gameState) => {
      this.roundEndDate = new Date(gameState.game.endTime);
    })
    this.optionService.getAll().subscribe((options) => {
      this.allAvailableOptions = options;
    })
  }

  voted(optionIndex: number) {
    console.warn(optionIndex);
  }
}
