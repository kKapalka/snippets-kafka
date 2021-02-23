package org.example.snippets.kafka.producer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    final List<String> messagesToSend = Collections.synchronizedList(new ArrayList<>());

    @Bean
    public Supplier<String> producer(){
        return () -> {
            synchronized(messagesToSend) {
                if(messagesToSend.size() > 0) {
                    String message = messagesToSend.get(0);
                    messagesToSend.remove(0);
                    return message;
                }
                return null;
            }
        };
    }

    public void sendMessage(String message) {
        messagesToSend.add(message);
    }

}
