package io.github.butcher.butcher.back.repository;

import io.github.butcher.butcher.back.domain.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
}
