package io.github.butcher.butcher.back.domain.repository;

import io.github.butcher.butcher.back.domain.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends CrudRepository<Option, Long> {

}
