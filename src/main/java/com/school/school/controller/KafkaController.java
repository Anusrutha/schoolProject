package com.school.school.controller;

import com.school.school.kafka.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Autowired
    KafkaProducerService kafkaProducerService;
    @PostMapping("/message")
    public String kafkaMessageSend(@RequestParam("topic") String topicName, @RequestParam("message") String message) {
         kafkaProducerService.kafkaMessageSend(topicName, message);

         return  " completed";

    }
    }
