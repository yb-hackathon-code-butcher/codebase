package io.github.butcher.butcher.back.game;

import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.game.event.StartEvaluationEvent;
import io.github.butcher.butcher.back.service.GameService;
import io.github.butcher.butcher.back.socket.event.RoundEndedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RoundEvaluator {

  private static final Logger LOGGER = LoggerFactory.getLogger(RoundEvaluator.class);

  private final Voter voter;
  private final GameService gameService;
  private final ApplicationEventPublisher applicationEventPublisher;

  public RoundEvaluator(Voter voter, GameService gameService,
      ApplicationEventPublisher applicationEventPublisher) {
    this.voter = voter;
    this.gameService = gameService;
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @EventListener
  public void startEvaluation(StartEvaluationEvent evaluationStartEvent) {
    LOGGER.info("Evaluation starts");

    Game currentGame = gameService.getCurrentGame();

    VotingResult team1VotingResult = calculateVotingResult(currentGame.getTeam1().getId());
    VotingResult team2VotingResult = calculateVotingResult(currentGame.getTeam2().getId());

    applicationEventPublisher.publishEvent(
        new RoundEndedEvent(team1VotingResult, eventsBasedOnVotingResult(team1VotingResult),
            currentGame.getTeam1().getId()));
    applicationEventPublisher.publishEvent(
        new RoundEndedEvent(team2VotingResult, eventsBasedOnVotingResult(team2VotingResult),
            currentGame.getTeam2().getId()));
  }

  private VotingResult calculateVotingResult(Long teamId) {
    LOGGER.debug("Calculating voting result for team {}", teamId);

    voter.getResult(teamId);

    // TODO
    return new VotingResult();
  }

  private Long[] eventsBasedOnVotingResult(VotingResult votingResult) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Calculating events based on voting result: {}", votingResult);
    }

    // TODO
    return new Long[]{};
  }
}
