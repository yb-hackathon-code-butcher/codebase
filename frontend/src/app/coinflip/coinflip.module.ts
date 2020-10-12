import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoinflipRoutingModule } from './coinflip-routing.module';
import { CoinflipComponent } from './coinflip.component';


@NgModule({
  declarations: [CoinflipComponent],
  imports: [
    CommonModule,
    CoinflipRoutingModule
  ]
})
export class CoinflipModule { }
