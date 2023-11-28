package com.school.school.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public boolean kafkaMessageSend(String topicName, String message) {
            log.info("school - producer - topic : {}, message : {}", topicName, message);
            kafkaTemplate.send(topicName, message);

        return false;
    }
}
