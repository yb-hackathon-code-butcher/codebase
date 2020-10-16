import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

const routes: Routes = [

  {
    path: 'login',
    loadChildren: () => import('./login/login.module').then(m => m.LoginModule)
  }, {
    path: 'countdown',
    loadChildren: () => import('./countdown/countdown.module').then(m => m.CountdownModule)
  }, {
    path: 'game-end',
    loadChildren: () => import('./game-end/game-end.module').then(m => m.GameEndModule)
  },
  {
    path: 'game',
    loadChildren: () => import('./game/game.module').then(m => m.GameModule)
  }, {
    path: 'team-selection',
    loadChildren: () => import('./team-selection/team-selection.module').then(m => m.TeamSelectionModule)
  }, {
    path: 'countdown',
    loadChildren: () => import('./countdown/countdown.module').then(m => m.CountdownModule)
  }, {
    path: 'coinflip',
    loadChildren: () => import('./coinflip/coinflip.module').then(m => m.CoinflipModule)
  },
  {path: 'round-end', loadChildren: () => import('./round-end/round-end.module').then(m => m.RoundEndModule)},

  {
    path: '**',
    redirectTo: 'login'
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
