import {Component, OnInit} from '@angular/core';
import {PlayerRestService} from "../../services/rest/player/player-rest.service";
import {GameRestService} from "../../services/rest/game/game-rest.service";
import {GameStatsModel} from "../../model/rest/game/game-stats.model";
import {TeamRestService} from '../../services/rest/team/team-rest.service';
import {forkJoin} from 'rxjs';
import {TeamModel} from '../../model/rest/team/team.model';
import {AuthService} from '../../services/common/auth.service';
import {Router} from '@angular/router';
import {GameSocketService} from '../../services/socket/game/game-socket.service';

@Component({
  selector: 'app-team-selection',
  templateUrl: './team-selection.component.html',
  styleUrls: ['./team-selection.component.scss']
})
export class TeamSelectionComponent implements OnInit {

  gameObject: GameStatsModel;
  private teams: TeamModel[];

  constructor(private playerRestService: PlayerRestService,
              private gameRestService: GameRestService,
              private teamRestService: TeamRestService,
              private authService: AuthService,
              private router: Router) {
  }

  ngOnInit(): void {
    forkJoin([this.teamRestService.getAll(), this.gameRestService.getGame()])
      .subscribe(([teams, game]) => {
        this.gameObject = game;
        this.teams = teams;
      });
  }

  selectTeam(teamId: number) {
    const playerUUID = this.authService.getUUID();
    this.playerRestService.selectTeam(playerUUID, teamId).subscribe((a)=> {
      console.warn(a)
      this.router.navigateByUrl('countdown');
    });
  }
}
