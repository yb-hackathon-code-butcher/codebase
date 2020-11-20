import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {RoundEndRoutingModule} from './round-end-routing.module';
import {RoundEndComponent} from './round-end.component';


@NgModule({
  declarations: [RoundEndComponent],
  imports: [
    CommonModule,
    RoundEndRoutingModule
  ]
})
export class RoundEndModule {
}
