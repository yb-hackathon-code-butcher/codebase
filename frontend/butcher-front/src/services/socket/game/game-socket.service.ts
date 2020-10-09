import {Injectable} from '@angular/core';
import {Socket} from 'ngx-socket-io';
import {Observable} from 'rxjs';
import {ClientMessage, ServerMessage} from './messages';
import {GameEnd} from '../../../model/socket/receive/GameEnd';
import {GameStarts} from '../../../model/socket/receive/GameStarts';
import {NextRound} from '../../../model/socket/receive/NextRound';
import {VoteUpdate} from '../../../model/socket/receive/VoteUpdate';
import {RoundEnded} from '../../../model/socket/receive/RoundEnded';

@Injectable({
  providedIn: 'root'
})
export class GameSocketService {

  constructor(private socket: Socket) {
  }

  /*getObservable(message: ServerMessage|ClientMessage): Observable<any> {
    return new Observable(observer => {
      this.socket.on(message, (data) => {
        observer.next(data);
      });
      return () => {
        this.socket.disconnect();
      };
    });
  }*/

  onGameEnd(): Promise<GameEnd>{
    return this.socket.fromOneTimeEvent<GameEnd>(ServerMessage.GAME_END);
  }

  onGameStarts(): Promise<GameStarts>{
    return this.socket.fromOneTimeEvent(ServerMessage.GAME_STARTS);
  }

  onNextRound(): Observable<NextRound>{
    return this.socket.fromEvent(ServerMessage.NEXT_ROUND);
  }

  onRoundEnded(): Observable<RoundEnded>{
    return this.socket.fromEvent(ServerMessage.ROUND_ENDED);
  }

  onVoteUpdate(): Observable<VoteUpdate>{
    return this.socket.fromEvent(ServerMessage.VOTE_UPDATE);
  }

  sendVote(){
      this.socket.emit(ClientMessage.VOTE);
  }

  sendJoin(){
    this.socket.emit(ClientMessage.JOIN);
  }
}
