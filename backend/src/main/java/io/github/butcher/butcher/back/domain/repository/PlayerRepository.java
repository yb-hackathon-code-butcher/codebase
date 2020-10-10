package io.github.butcher.butcher.back.domain.repository;

import io.github.butcher.butcher.back.domain.Player;
import io.github.butcher.butcher.back.domain.Team;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

  Optional<Player> findByUid(String uid);

  @Query("SELECT p.team from Player p WHERE p.uid = :uid")
  Optional<Team> findTeamByUid(String uid);
}
