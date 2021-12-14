package com.rislah;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;

import java.util.Properties;

public class Main {
    public static void main(String[] arg) {
        Properties properties = new Properties();
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(StreamsConfig.STATE_DIR_CONFIG, "/tmp/asd4");
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "dev");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        Topology clickAnalysisTopology = ClickAnalysisTopology.build();
        KafkaStreams streams = new KafkaStreams(clickAnalysisTopology, properties);
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}
