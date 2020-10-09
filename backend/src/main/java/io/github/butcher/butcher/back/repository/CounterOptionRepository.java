package io.github.butcher.butcher.back.repository;

import io.github.butcher.butcher.back.domain.CounterOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterOptionRepository extends CrudRepository<CounterOption, Long> {
}
