package haulmont.work.service;

import haulmont.work.domain.Person;
import haulmont.work.repo.PersonRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Flux<Person> list() {
        return personRepo.findAll();
    }

    public Mono<Person> addOne(Person person) {
        return personRepo.save(person);
    }
}
