package com.school.school.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerServiceImpl {


//    @KafkaListener(topics = "sample-topic")
    public void kafkaMessageConsumer(String message) {
        log.info("i amin kafka consumer : message : {}", message);

        System.out.println(message);

    }
}
