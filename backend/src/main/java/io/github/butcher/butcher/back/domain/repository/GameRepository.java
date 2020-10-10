package io.github.butcher.butcher.back.domain.repository;

import io.github.butcher.butcher.back.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByOrderByStartTimeDesc();
}
