package kr.co.mimmin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
public class MainController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/publish/topic01")
    public String pubilsh1(){
        for(int i=1;i<=10000;i++){
            kafkaTemplate.send("my-topic-01","message-"+i);
        }
        return "done";
    }
    @GetMapping("/publish/topic02")
    public String pubilsh2(){
        for(int i=1;i<=2000;i++){
            kafkaTemplate.send("my-topic-02","message-"+i);
        }
        return "done";
    }
    @GetMapping("/publish/topic03")
    public String pubilsh3(){
        for(int i=1;i<=5000;i++){
            kafkaTemplate.send("my-topic-03","message-"+i);
        }
        return "done";
    }
}
