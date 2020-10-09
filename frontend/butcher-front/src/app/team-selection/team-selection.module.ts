import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TeamSelectionRoutingModule } from './team-selection-routing.module';
import { TeamSelectionComponent } from './team-selection.component';
import {MatGridListModule} from "@angular/material/grid-list";


@NgModule({
  declarations: [TeamSelectionComponent],
  imports: [
    CommonModule,
    TeamSelectionRoutingModule,
    MatGridListModule
  ]
})
export class TeamSelectionModule { }
