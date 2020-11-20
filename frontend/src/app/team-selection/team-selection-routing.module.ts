import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {TeamSelectionComponent} from './team-selection.component';

const routes: Routes = [{path: '', component: TeamSelectionComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TeamSelectionRoutingModule {
}
