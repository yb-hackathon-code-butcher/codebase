package io.github.butcher.butcher.back.domain.repository;

import io.github.butcher.butcher.back.domain.Round;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends CrudRepository<Round, Long> {

}
