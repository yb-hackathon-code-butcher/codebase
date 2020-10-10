package io.github.butcher.butcher.back.game;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class Voter {

  private final Map<Long, Map<Long, BigDecimal>> votes = new HashMap<>();

  public Voter() {

  }

  public synchronized void resetTeam(Long teamId, Long[] optionIds) {
    Map<Long, BigDecimal> initialVotes = new HashMap<>();

    Arrays.asList(optionIds).forEach(optionId -> initialVotes.put(optionId, BigDecimal.ZERO));

    votes.put(teamId, initialVotes);
  }

  public synchronized void vote(Long teamId, Long voteId) {
    votes.get(teamId).put(voteId, votes.get(teamId).get(voteId).add(BigDecimal.ONE));
  }

  public Long getHighestVotedOptionId(Long teamId) {
    Map<Long, BigDecimal> votesPerOption = votes.get(teamId);
    return votesPerOption.values().stream()
        .sorted()
        .findFirst()
        .orElse(votesPerOption.get(0))
        .longValue();
  }
}
