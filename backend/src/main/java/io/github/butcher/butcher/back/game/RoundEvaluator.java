package io.github.butcher.butcher.back.game;

import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.domain.Option;
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

    Option team1Option = getWinningOption(team1Id);
    Option team2Option = getWinningOption(currentGame.getTeam2().getId());

    Pair<VotingResult, VotingResult> results;
    if (team1Id.equals(currentGame.getPossessionTeamId())) {
      results = calculateVotingResults(team1Option, team2Option);
    } else {
      results = calculateVotingResults(team2Option, team1Option);
    }

    applicationEventPublisher.publishEvent(
        new RoundEndedEvent(results.getFirst(), eventsBasedOnVotingResult(results.getFirst()),
            currentGame.getTeam1().getId()));
    applicationEventPublisher.publishEvent(
        new RoundEndedEvent(results.getSecond(), eventsBasedOnVotingResult(results.getSecond()),
            currentGame.getTeam2().getId()));
  }

  private Pair<VotingResult, VotingResult> calculateVotingResults(Option offensiveTeamOption,
      Option passiveTeamOption) {
    // TODO: Calculate results
    return Pair.of(null, null);
  }

  private Option getWinningOption(Long teamId) {
    LOGGER.debug("Calculating voting result for team {}", teamId);

    Long winningOptionId = voter.getHighestVotedOptionId(teamId);
    return optionService.getById(winningOptionId);
  }

  private Long[] eventsBasedOnVotingResult(VotingResult votingResult) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Calculating events based on voting result: {}", votingResult);
    }

    // TODO
    return new Long[]{};
  }
}
