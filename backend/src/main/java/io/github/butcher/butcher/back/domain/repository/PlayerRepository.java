package io.github.butcher.butcher.back.domain.repository;

import io.github.butcher.butcher.back.domain.Player;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

  Optional<Player> findByUid(String uid);
}
