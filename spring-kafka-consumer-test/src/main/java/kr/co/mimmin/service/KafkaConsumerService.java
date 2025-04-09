package kr.co.mimmin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "my-topic-01",groupId = "group-my-topic-01")
    public void topic01Consumer(ConsumerRecord<String, String> record) {
        log.info("topic01Consumer....");
        log.info(record.key()+ "-"+record.value());
    }
    @KafkaListener(topics = "my-topic-02",groupId = "group-my-topic-02")
    public void topic02Consumer(ConsumerRecord<String, String> record) {
        log.info("topic02Consumer....");
        log.info(record.key()+ "-"+record.value());
    }
    @KafkaListener(topics = "my-topic-03",groupId = "group-my-topic-03")
    public void topic03Consumer(ConsumerRecord<String, String> record) {
        log.info("topic03Consumer....");
        log.info(record.key()+ "-"+record.value());
    }
}
