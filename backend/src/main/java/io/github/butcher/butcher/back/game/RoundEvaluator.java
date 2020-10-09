package io.github.butcher.butcher.back.game;

import io.github.butcher.butcher.back.game.event.StartEvaluationEvent;
import io.github.butcher.butcher.back.socket.event.RoundEndedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RoundEvaluator {

  private static final Logger LOGGER = LoggerFactory.getLogger(RoundEvaluator.class);

  private final ApplicationEventPublisher applicationEventPublisher;

  public RoundEvaluator(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @EventListener
  public void startEvaluation(StartEvaluationEvent evaluationStartEvent) {
    LOGGER.info("Evaluation starts");

    VotingResult votingResult = calculateVotingResult();
    applicationEventPublisher.publishEvent(
        new RoundEndedEvent(calculateVotingResult(), eventsBasedOnVotingResult(votingResult)));
  }

  private VotingResult calculateVotingResult() {
    LOGGER.debug("Calculating voting results");

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
