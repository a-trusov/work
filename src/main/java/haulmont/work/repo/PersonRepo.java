package haulmont.work.repo;

import haulmont.work.domain.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonRepo extends ReactiveCrudRepository<Person, Long> {
}
