package io.github.butcher.butcher.back.game;

import io.github.butcher.butcher.back.config.AppGameProperties;
import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.service.GameService;
import io.github.butcher.butcher.back.service.OptionService;
import io.github.butcher.butcher.back.socket.event.GameStartsEvent;
import io.github.butcher.butcher.back.socket.event.NextRoundEvent;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class GameStarter {

  private static final Logger LOGGER = LoggerFactory.getLogger(GameStarter.class);

  private final AppGameProperties appGameProperties;
  private final Voter voter;
  private final GameService gameService;
  private final OptionService optionService;
  private final ApplicationEventPublisher applicationEventPublisher;

  public GameStarter(AppGameProperties appGameProperties, Voter voter, GameService gameService,
      OptionService optionService, ApplicationEventPublisher applicationEventPublisher) {
    this.appGameProperties = appGameProperties;
    this.voter = voter;
    this.gameService = gameService;
    this.optionService = optionService;
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @EventListener
  public void gameStarts(GameStartsEvent gameStartsEvent) {
    LOGGER.info("Game starts, initiating first round: {}", gameStartsEvent);

    Game currentGame = gameService.getCurrentGame();
    LocalDateTime endTime = LocalDateTime.now()
        .plus(appGameProperties.getRoundDurationSeconds(), ChronoUnit.SECONDS);

    Long team1Id = currentGame.getTeam1().getId();
    NextRoundEvent team1NextRound = new NextRoundEvent(optionService.startingOptions(), endTime,
        team1Id);

    Long team2Id = currentGame.getTeam2().getId();
    NextRoundEvent team2NextRound = new NextRoundEvent(optionService.startingOptions(), endTime,
        team2Id);

    voter.resetTeam(team1Id, team1NextRound.getOptionIds());
    voter.resetTeam(team2Id, team2NextRound.getOptionIds());

    applicationEventPublisher.publishEvent(team1NextRound);
    applicationEventPublisher.publishEvent(team2NextRound);
  }
}
