package com.simple.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Application {

    public static void main(String[] args) {
        Properties properties = new ProducerProperties("localhost:9092").getProperties();
        Producer<String, String> producer = new KafkaProducer<>(properties);
        ProducerRecord<String, String> record = new ProducerRecord<>("truck_location", "truck started");
        producer.send(record);
        producer.flush();
        producer.close();
    }
}
