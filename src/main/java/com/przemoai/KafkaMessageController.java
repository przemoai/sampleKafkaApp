package com.przemoai;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
class KafkaMessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    KafkaMessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    void publish(@RequestBody KafkaMessageRequest request) {
        kafkaTemplate.send("SampleKafkaTopic", request.message());
    }
}
