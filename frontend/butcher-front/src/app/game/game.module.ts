import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GameRoutingModule } from './game-routing.module';
import { GameComponent } from './game.component';
import { VoteResultBarComponent } from './vote-result-bar/vote-result-bar.component';
import { OptionListComponent } from './option-list/option-list.component';
import {MatButtonModule} from '@angular/material/button';
import { RoundCounterComponent } from './round-counter/round-counter.component';
import { BallPossessionComponent } from './ball-possession/ball-possession.component';
import { ScoreboardComponent } from './scoreboard/scoreboard.component';


@NgModule({
  declarations: [GameComponent, VoteResultBarComponent, OptionListComponent, RoundCounterComponent, BallPossessionComponent, ScoreboardComponent],
  exports: [
    RoundCounterComponent,
    ScoreboardComponent,
    BallPossessionComponent
  ],
  imports: [
    CommonModule,
    GameRoutingModule,
    MatButtonModule
  ]
})
export class GameModule { }
