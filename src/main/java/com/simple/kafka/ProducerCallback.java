package com.simple.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerCallback implements Callback {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerCallback.class);

    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        if (exception != null) {
            LOGGER.error("Error sending event", exception);
        } else {
            LOGGER.info("Successfully published event: \n" +
                    "Topic: " + metadata.topic() + "\n" +
                    "Partition: " + metadata.partition() + "\n" +
                    "Offset: " + metadata.offset() + "\n" +
                    "Timestamp: " + metadata.timestamp() + "\n");
        }
    }
}
