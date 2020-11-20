import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {AuthGuard} from "../services/guards/auth.guard";
import {NegateAuthGuard} from "../services/guards/negate.auth.guard";
import {GameRunningGuard} from "../services/guards/game.running.guard";

const routes: Routes = [

  {
    path: 'login',
    loadChildren: () => import('./login/login.module').then(m => m.LoginModule),
    canActivate: [NegateAuthGuard]
  },  {
    path: 'game-end',
    loadChildren: () => import('./game-end/game-end.module').then(m => m.GameEndModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'game',
    loadChildren: () => import('./game/game.module').then(m => m.GameModule),
    canActivate: [AuthGuard, GameRunningGuard]
  }, {
    path: 'team-selection',
    loadChildren: () => import('./team-selection/team-selection.module').then(m => m.TeamSelectionModule),
    canActivate: [NegateAuthGuard]
  }, {
    path: 'countdown',
    loadChildren: () => import('./countdown/countdown.module').then(m => m.CountdownModule),
    canActivate: [AuthGuard]
  }, {
    path: 'coinflip',
    loadChildren: () => import('./coinflip/coinflip.module').then(m => m.CoinflipModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'round-end', loadChildren: () => import('./round-end/round-end.module').then(m => m.RoundEndModule),
    canActivate: [AuthGuard, GameRunningGuard]
  },

  {
    path: '**',
    redirectTo: 'team-selection'
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
