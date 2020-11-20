import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CountdownRoutingModule} from './countdown-routing.module';
import {CountdownComponent} from './countdown.component';
import {TimerComponent} from './timer/timer.component';


@NgModule({
  declarations: [CountdownComponent, TimerComponent],
  imports: [
    CommonModule,
    CountdownRoutingModule
  ]
})
export class CountdownModule {
}
