package haulmont.work.controller;

import haulmont.work.domain.Person;
import haulmont.work.service.PersonService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.net.URI;

@RestController
public class WorkController {
    private final PersonService personService;

    public WorkController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public Flux<Person> list(@RequestParam(defaultValue = "0") Long start,
                             @RequestParam(defaultValue = "3") Long count) {
        return personService.list()
                .skip(start)
                .take(count);
    }

    @RequestMapping("/sum")
    private Mono<BigDecimal> getSum() {
        return WebClient.create()
                .get()
                .uri(URI.create("http://localhost:8080/person"))
                .retrieve()
                .bodyToFlux(Person.class)
                .map(Person::getSalary)
                .reduce(BigDecimal::add);
    }

    @PostMapping
    public Mono<Person> add(@RequestBody Person person) {
        return personService.addOne(person);
    }
}
