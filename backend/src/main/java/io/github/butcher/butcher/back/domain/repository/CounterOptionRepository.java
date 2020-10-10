package io.github.butcher.butcher.back.domain.repository;

import io.github.butcher.butcher.back.domain.CounterOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterOptionRepository extends JpaRepository<CounterOption, Long> {

}
