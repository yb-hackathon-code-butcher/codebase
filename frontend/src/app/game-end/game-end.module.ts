import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {GameEndRoutingModule} from './game-end-routing.module';
import {GameEndComponent} from './game-end.component';


@NgModule({
  declarations: [GameEndComponent],
  imports: [
    CommonModule,
    GameEndRoutingModule
  ]
})
export class GameEndModule {
}
