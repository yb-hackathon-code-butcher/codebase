import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GameEndComponent } from './game-end.component';

const routes: Routes = [{ path: '', component: GameEndComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GameEndRoutingModule { }
