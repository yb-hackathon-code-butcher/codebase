export enum ServerMessage {
  GAME_STARTS = 'game_starts',
  NEXT_ROUND = 'next_round',
  VOTE_UPDATE = 'vote_update',
  ROUND_ENDED = 'round_ended',
  GAME_END = 'game_end'
}


export enum ClientMessage {
  VOTE = 'vote',
  JOIN = 'join'
}

