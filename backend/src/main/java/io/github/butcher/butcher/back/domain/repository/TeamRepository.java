package io.github.butcher.butcher.back.domain.repository;

import io.github.butcher.butcher.back.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
