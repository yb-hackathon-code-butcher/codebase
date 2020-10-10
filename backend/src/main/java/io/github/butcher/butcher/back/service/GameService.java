package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.domain.Team;
import io.github.butcher.butcher.back.domain.repository.GameRepository;
import io.github.butcher.butcher.back.service.dto.GameStatsDTO;
import io.github.butcher.butcher.back.service.mapper.GameStatsMapper;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  private final GameStatsMapper gameStatsMapper;

  private final GameRepository gameRepository;

  private final TeamService teamService;

  public GameService(GameRepository gameRepository, GameStatsMapper gameStatsMapper,
      TeamService teamService) {
    this.gameRepository = gameRepository;
    this.gameStatsMapper = gameStatsMapper;
    this.teamService = teamService;
  }

  public Game getNextGame() {
    // TODO: Read from DB
    return null;
  }

  public Team determineWinnerTeam() {
    // TODO
    return null;
  }

  public Game getCurrentGame() {
    return gameRepository.findOneByOrderByStartTimeDesc();
  }

  public GameStatsDTO getGame() {

    GameStatsDTO gameStatsDTO = gameStatsMapper.convertToDTO(getCurrentGame());

    return gameStatsDTO;
  }

  public void createNewGame() {
    Game newGame = new Game();

    newGame.setStartTime(new Timestamp(System.currentTimeMillis()));
    newGame.setEndTime(new Timestamp(
        new Timestamp(System.currentTimeMillis()).getTime() + TimeUnit.MINUTES.toMillis(10)));
    newGame.setEndTime(
        new Timestamp(newGame.getStartTime().getTime() + TimeUnit.SECONDS.toMillis(20)));

    List<Team> teams = teamService.createInstantNewGame();
    newGame.setTeam1(teams.get(0));
    newGame.setTeam1(teams.get(1));

    newGame.setTeam1Score(0L);
    newGame.setTeam2Score(0L);

    gameRepository.save(newGame);
  }
}
