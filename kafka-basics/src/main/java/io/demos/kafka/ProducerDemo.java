package io.demos.kafka;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemo {
    private static final Logger log= LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());

    public static void main(String[] args) {
        log.info("Hello World");

        Properties properties=new Properties();
        //connect to local host
        properties.setProperty("bootstrap.servers","127.0.0.1:9092");
        //can also connect to cluster/playground/remote server/add security properties to your producer

        //Create producer Properties
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        //Create Producer
        KafkaProducer<String,String> producer= new KafkaProducer<String, String>(properties);

        //Producer Record
        ProducerRecord<String,String> producerRecord= new ProducerRecord<>("demo_java","helloWorld from Java");

        //Send data
        producer.send(producerRecord);

        //Flush and close the producer
        //send data to kafka
        producer.flush();

        producer.close();

    }
}
