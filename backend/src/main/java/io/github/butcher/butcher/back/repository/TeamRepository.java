package io.github.butcher.butcher.back.repository;

import io.github.butcher.butcher.back.domain.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
}
