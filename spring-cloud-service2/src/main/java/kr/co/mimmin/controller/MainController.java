package kr.co.mimmin.controller;

import brave.Span;
import brave.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@RestController
public class MainController {

    private final Tracer tracer;

    @GetMapping("/")
    public String index() {
        return "Service2 index!!!";
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
    public Map<String,String> user(){
        return Map.of(
                "uid", "a101",
                "name", "홍길동",
                "age", "23",
                "addr", "부산"
        );
    }
}
