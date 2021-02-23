package org.example.snippets.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping
    public void sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
    }
}
