import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RoundEndComponent } from './round-end.component';

const routes: Routes = [{ path: '', component: RoundEndComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RoundEndRoutingModule { }
