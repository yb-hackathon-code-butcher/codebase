import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [{ path: 'login', loadChildren: () => import('./login/login.module').then(m => m.LoginModule) }, { path: 'countdown', loadChildren: () => import('./countdown/countdown.module').then(m => m.CountdownModule) }, { path: 'gameEnd', loadChildren: () => import('./game-end/game-end.module').then(m => m.GameEndModule) }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
