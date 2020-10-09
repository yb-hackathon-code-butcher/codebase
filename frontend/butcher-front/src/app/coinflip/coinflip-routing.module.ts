import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CoinflipComponent } from './coinflip.component';

const routes: Routes = [{ path: '', component: CoinflipComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoinflipRoutingModule { }
