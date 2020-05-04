package haulmont.work.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class WorkHandler {

    public Mono<ServerResponse> index(ServerRequest request) {
        String user = request.queryParam("user").orElse("Nobody");
        return ServerResponse
                .ok()
                .render("index", Map.of("user", user));
    }
}