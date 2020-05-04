package haulmont.work.config;

import haulmont.work.handlers.WorkHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class WorkRouter {

    @Bean
    public RouterFunction<ServerResponse> route(WorkHandler workHandler) {
        return RouterFunctions
                .route(
                        RequestPredicates.GET("/"),
                        workHandler::index
                );
    }
}