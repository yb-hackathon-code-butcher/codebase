import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {AuthGuard} from "./auth.guard";
import {GameRunningGuard} from "./game.running.guard";

@Injectable()
export class NegateAuthGuard implements CanActivate {
  constructor(private router: Router,
              private authGuard: AuthGuard,
              private gameRunningGuard: GameRunningGuard) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (!this.gameRunningGuard.canActivate(route, state)) {
      this.router.navigate(['/countdown'], {queryParams: {returnUrl: state.url}});
    } else {
      this.router.navigate(['/game'], {queryParams: {returnUrl: state.url}});
    }
    return !this.authGuard.canActivate(route, state);
  }
}
