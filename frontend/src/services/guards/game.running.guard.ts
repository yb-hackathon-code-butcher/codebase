import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {GameRestService} from "../rest/game/game-rest.service";

@Injectable()
export class GameRunningGuard implements CanActivate {

  constructor(private router: Router, private gameRestService: GameRestService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return new Promise<boolean>((resolve, reject) => {
      this.gameRestService.getGame().subscribe((game) => {
        if (game.isRunning) {
          resolve(true);
        } else {
          this.router.navigate(['/countdown'], {queryParams: {returnUrl: state.url}});
          resolve(false);
        }
      });
    });
  }
}
