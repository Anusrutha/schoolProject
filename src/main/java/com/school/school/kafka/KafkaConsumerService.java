package com.school.school.kafka;

import org.springframework.kafka.core.KafkaTemplate;

public interface KafkaConsumerService {


    void kafkaMessageConsumer(String message);

}
