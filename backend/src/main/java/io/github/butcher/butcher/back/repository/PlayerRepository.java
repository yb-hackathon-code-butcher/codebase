package io.github.butcher.butcher.back.repository;

import io.github.butcher.butcher.back.domain.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
