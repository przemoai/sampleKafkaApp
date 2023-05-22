package com.przemoai;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class KafkaListeners {

    @KafkaListener(
            topics = "SampleKafkaTopic",
            groupId = "SampleGroupId")
    void listener(String data) {
        System.out.println("Received: " + data);
    }
}
