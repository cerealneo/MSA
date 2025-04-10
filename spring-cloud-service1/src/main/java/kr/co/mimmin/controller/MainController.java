package kr.co.mimmin.controller;

import brave.Span;
import brave.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MainController {

    private final Tracer tracer;
    private final WebClient webClient;

    @GetMapping("/")
    public String index() {
        return "Service1 index!!!";
    }
    @GetMapping("/traceId")
    public String traceId(){

        log.info("traceId...");

        Span currentSpan =tracer.currentSpan();
        String traceId = currentSpan.context().traceIdString();
        String spanId = currentSpan.context().spanIdString();

        return "[traceId : " + traceId + ", spanId : " + spanId + "]";
    }

    @GetMapping("/user")
    public Mono<Map<String,String>> user(){

        Mono<Map<String,String>> monoUser = webClient.get()
                .uri("/user")
                .retrieve()
               .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {});

       return monoUser;
    }
}
