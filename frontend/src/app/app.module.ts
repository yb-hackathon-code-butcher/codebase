import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';

import {SocketIoConfig, SocketIoModule} from 'ngx-socket-io';
import {environment} from '../environments/environment';
import {AuthGuard} from "../services/guards/auth.guard";
import {NegateAuthGuard} from "../services/guards/negate.auth.guard";
import {GameRunningGuard} from "../services/guards/game.running.guard";

const config: SocketIoConfig = {
  url: environment.socketEndpoint,
  options: environment.socketIoOptions
};


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    SocketIoModule.forRoot(config)
  ],
  providers: [AuthGuard, NegateAuthGuard, GameRunningGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
