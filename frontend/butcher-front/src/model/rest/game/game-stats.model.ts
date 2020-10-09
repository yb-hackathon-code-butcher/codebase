import {GameModel} from "./game.model";

export interface GameStatsModel {
  game: GameModel;
  isRunning: boolean; // if true: properties below are defined otherwise not
  teamScore1: number; //A and B are based on GameModel
  teamScore2: number;
  roundEndTime: number; //round will end for setting client-side timer
  options: number[]; //options for selected team
  voteDistribution: Map<number, number[]> //key: teamId, value: array with percentage distribution among the options
}
