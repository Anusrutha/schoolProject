package com.school.school.kafka;

public interface KafkaProducerService {

    boolean kafkaMessageSend(String topicName, String message);
}
