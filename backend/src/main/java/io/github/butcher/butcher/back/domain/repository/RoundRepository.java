package io.github.butcher.butcher.back.domain.repository;

import io.github.butcher.butcher.back.domain.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {

}
