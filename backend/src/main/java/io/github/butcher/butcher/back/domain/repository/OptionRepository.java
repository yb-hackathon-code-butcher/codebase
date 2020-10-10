package io.github.butcher.butcher.back.domain.repository;

import io.github.butcher.butcher.back.domain.Option;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {

  List<Option> findAllWhereZoneEquals(Long zone);
}
