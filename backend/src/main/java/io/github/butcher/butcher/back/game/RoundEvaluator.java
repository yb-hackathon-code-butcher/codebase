package io.github.butcher.butcher.back.game;

import io.github.butcher.butcher.back.admin.event.StartEvaluationEvent;
import io.github.butcher.butcher.back.socket.event.RoundEndedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RoundEvaluator {

  private ApplicationEventPublisher applicationEventPublisher;

  public RoundEvaluator(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @EventListener
  public void startEvaluation(StartEvaluationEvent evaluationStartEvent) {
    // TODO: Evaluate round
    VotingResult votingResult = calculateVotingResult();
    applicationEventPublisher.publishEvent(
        new RoundEndedEvent(calculateVotingResult(), eventsBasedOnVotingResult(votingResult)));
  }

  private VotingResult calculateVotingResult() {
    // TODO
    return new VotingResult();
  }

  private Long[] eventsBasedOnVotingResult(VotingResult votingResult) {
    // TODO
    return new Long[]{};
  }
}
