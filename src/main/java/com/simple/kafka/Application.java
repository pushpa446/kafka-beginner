package com.simple.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Application {

    public static void main(String[] args) {
        String brokerUrl = "localhost:9092";

        Properties properties = new ProducerProperties(brokerUrl).getProperties();
        Producer<String, String> producer = new KafkaProducer<>(properties);
        send(producer);
        producer.flush();
        producer.close();
    }

    private static void send(Producer<String, String> producer) {
        String topic = "truck_location";
        for (int i=0; i< 10; i ++){
            String key = "vehicle_" + i%2;
            String value = "at " + i + " km";
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
            producer.send(record, new ProducerCallback());
        }
    }
}
