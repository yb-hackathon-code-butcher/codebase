import { Component, OnInit } from '@angular/core';

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

  constructor() { }

  ngOnInit(): void {
  }

}
