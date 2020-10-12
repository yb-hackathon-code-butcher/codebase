import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-scoreboard',
  templateUrl: './scoreboard.component.html',
  styleUrls: ['./scoreboard.component.scss']
})
export class ScoreboardComponent implements OnInit {
  @Input()
  score: {teamA: number, teamB: number};

  constructor() { }

  ngOnInit(): void {
  }

}
