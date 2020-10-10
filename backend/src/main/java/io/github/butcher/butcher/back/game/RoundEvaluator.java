package io.github.butcher.butcher.back.game;

import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.domain.Option;
import io.github.butcher.butcher.back.domain.OptionWinLose;
import io.github.butcher.butcher.back.game.event.StartEvaluationEvent;
import io.github.butcher.butcher.back.service.GameService;
import io.github.butcher.butcher.back.service.OptionService;
import io.github.butcher.butcher.back.socket.event.RoundEndedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

@Component
public class RoundEvaluator {

  private static final Logger LOGGER = LoggerFactory.getLogger(RoundEvaluator.class);

  private final Voter voter;
  private final GameService gameService;
  private final OptionService optionService;
  private final ApplicationEventPublisher applicationEventPublisher;

  public RoundEvaluator(Voter voter, GameService gameService, OptionService optionService,
      ApplicationEventPublisher applicationEventPublisher) {
    this.voter = voter;
    this.gameService = gameService;
    this.optionService = optionService;
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @EventListener
  public void startEvaluation(StartEvaluationEvent evaluationStartEvent) {
    LOGGER.info("Evaluation starts");

    Game currentGame = gameService.getCurrentGame();
    Long team1Id = currentGame.getTeam1().getId();
    Long team2Id = currentGame.getTeam2().getId();

    Option team1Option = getWinningOption(team1Id);
    Option team2Option = getWinningOption(team2Id);

    Pair<VotingResult, VotingResult> results = calculateVotingResults(team1Option, team2Option,
        currentGame);

    applicationEventPublisher.publishEvent(
        new RoundEndedEvent(results.getFirst(), eventsBasedOnVotingResult(results.getFirst()),
            currentGame.getTeam1().getId()));
    applicationEventPublisher.publishEvent(
        new RoundEndedEvent(results.getSecond(), eventsBasedOnVotingResult(results.getSecond()),
            currentGame.getTeam2().getId()));
  }

  private Option getWinningOption(Long teamId) {
    LOGGER.debug("Calculating voting result for team {}", teamId);

    Long winningOptionId = voter.getHighestVotedOptionId(teamId);
    return optionService.getById(winningOptionId);
  }

  private Pair<VotingResult, VotingResult> calculateVotingResults(Option team1Option,
      Option team2Option, Game currentGame) {
    LOGGER.info("Calculating results for option {} vs {}", team1Option, team2Option);

    boolean team1Possession = currentGame.getTeam1().getId()
        .equals(currentGame.getPossessionTeamId());

    LOGGER.debug("Team 1 is in ball possession: {}", team1Possession);

    if (team1Possession && optionService.optionIsCounteredBy(team1Option, team2Option)) {
      LOGGER.debug("Team 1 has been countered!");

      // calculate if offensive team can win this
      if (firstOptionWinsOverSecond(team1Option, team2Option)) {
        LOGGER.debug("And they win the fight");

        // if yes, use offensive option winner
        checkTeam1ZoneWin(team1Option, currentGame);
      } else {
        LOGGER.debug("Sadly, they do not win the fight");

        // if no, use defensive team winner
        team1Possession = false;
        checkTeam2ZoneWin(team2Option, currentGame);
      }
    } else if (!team1Possession && optionService.optionIsCounteredBy(team2Option, team1Option)) {
      LOGGER.debug("Team 2 has been countered!");

      // calculate if offensive team can win this
      if (firstOptionWinsOverSecond(team2Option, team1Option)) {
        LOGGER.debug("And they win the fight");

        // if yes, use offensive option winner
        checkTeam2ZoneWin(team2Option, currentGame);
      } else {
        LOGGER.debug("Sadly, they do not win the fight");

        // if no, use defensive team winner
        team1Possession = true;
        checkTeam1ZoneWin(team1Option, currentGame);
      }
    }
    // bad luck, offensive team always wins
    else if (team1Possession) {
      LOGGER.debug("Team 1 failed to counter!");

      // check zone win
      checkTeam1ZoneWin(team1Option, currentGame);
    } else {
      LOGGER.debug("Team 2 failed to counter!");

      // check zone win
      checkTeam2ZoneWin(team2Option, currentGame);
    }

    gameService.updateCurrentGameZones(currentGame);

    return Pair.of(new VotingResult(currentGame.getTeam1Zone(), team1Possession),
        new VotingResult(currentGame.getTeam2Zone(), !team1Possession));
  }

  private void checkTeam1ZoneWin(Option team1Option, Game currentGame) {
    LOGGER.debug("Checking zone win for team 1: {}", team1Option);

    if (team1Option.getWin().equals(OptionWinLose.ZONES_1)
        || team1Option.getWin().equals(OptionWinLose.ZONES_2)) {
      currentGame.setTeam1Zone(currentGame.getTeam1Zone() + 1);
      currentGame.setTeam2Zone(currentGame.getTeam2Zone() - 1);
    }
  }

  private void checkTeam2ZoneWin(Option team2Option, Game currentGame) {
    LOGGER.debug("Checking zone win for team 2: {}", team2Option);

    if (team2Option.getWin().equals(OptionWinLose.ZONES_1)
        || team2Option.getWin().equals(OptionWinLose.ZONES_2)) {
      currentGame.setTeam2Zone(currentGame.getTeam2Zone() + 1);
      currentGame.setTeam1Zone(currentGame.getTeam1Zone() - 1);
    }
  }

  private boolean firstOptionWinsOverSecond(Option team1Option, Option team2Option) {
    return team1Option.getDuel().compareTo(team2Option.getDuel()) > 0;
  }

  private Long[] eventsBasedOnVotingResult(VotingResult votingResult) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Calculating events based on voting result: {}", votingResult);
    }

    // TODO
    return new Long[]{};
  }
}
