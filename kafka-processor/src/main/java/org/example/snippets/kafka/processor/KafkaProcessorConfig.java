package org.example.snippets.kafka.processor;

import java.util.function.Function;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProcessorConfig {
    @Bean
    public Function<KStream<String, String>, KStream<String, String>> process(){
        return input -> input.map((this::reverseValue)).filter(((key, value) -> value != null));
    }


    private KeyValue<String, String> reverseValue(String key, String value) {
        System.out.println("Received: key: "+key+", value: "+value);
        return new KeyValue<>("Kafka-Processor", new StringBuilder().append(value).reverse().toString());
    }
}
