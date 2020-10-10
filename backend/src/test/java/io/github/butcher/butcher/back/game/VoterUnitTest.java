package io.github.butcher.butcher.back.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VoterUnitTest {

  Voter fixture;

  @BeforeEach
  public void beforeEachTestSetup() {
    fixture = new Voter();
  }

  @Test
  public void voteAddsToVotes() throws NoSuchFieldException, IllegalAccessException {
    Long teamId = 1234L;
    Long voteId = 2345L;

    Map<Long, Map<Long, BigDecimal>> initialVotesPerTeam = new HashMap<>();
    Map<Long, BigDecimal> initialVotes = new HashMap<>();
    initialVotes.put(voteId, BigDecimal.ZERO);
    initialVotesPerTeam.put(teamId, initialVotes);

    Field votes = fixture.getClass().getDeclaredField("votes");
    votes.setAccessible(true);
    votes.set(fixture, initialVotesPerTeam);

    fixture.vote(teamId, voteId);

    assertThat(((Map<Long, Map<Long, BigDecimal>>) votes.get(fixture)).get(teamId).get(voteId))
        .isEqualTo(BigDecimal.ONE);
  }
}
