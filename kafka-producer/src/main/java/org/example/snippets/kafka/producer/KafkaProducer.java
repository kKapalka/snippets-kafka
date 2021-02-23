package org.example.snippets.kafka.producer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    final BlockingQueue<String> messagesToSend = new ArrayBlockingQueue<>(100);

    @Bean
    public Supplier<String> producer(){
        return () -> {
            if(messagesToSend.size() > 0) {
                try {
                    return messagesToSend.take();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        };
    }

    public void sendMessage(String message) {
        messagesToSend.add(message);
    }

}
