package com.simple.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

import static java.util.Collections.singletonList;

public class Application {
    public static void main(String[] args) {
        final Logger LOGGER = LoggerFactory.getLogger(Application.class);

        String brokerUrl = "localhost:9092";
        String topic = "truck_location";
        String groupId = "navigation_app";

        Properties properties = new ConsumerProperties(brokerUrl, groupId).getProperties();
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        consumer.subscribe(singletonList(topic));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.of(100, ChronoUnit.MILLIS));
            records.forEach((record) -> LOGGER.info("Received an event: \n" +
                    "Key: " + record.key() + ", value: " + record.value() + "\n" +
                    "Topic: " + record.topic() + "\n" +
                    "Partition: " + record.partition() + "\n" +
                    "Offset: " + record.offset() + "\n" +
                    "Timestamp: " + record.timestamp() + "\n"));
        }
    }
}
