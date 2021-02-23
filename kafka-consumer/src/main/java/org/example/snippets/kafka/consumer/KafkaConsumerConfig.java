package org.example.snippets.kafka.consumer;

import java.util.function.Consumer;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;

public class KafkaConsumerConfig {

    @Bean
    public Consumer<KStream<String, String>> consume(){
        return input -> input.foreach((this::display));
    }

    private void display(String key, String value) {
        System.out.println("Received: key: "+key+", value: "+value);
    }
}
