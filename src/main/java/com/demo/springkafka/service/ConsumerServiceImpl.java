package com.demo.springkafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConsumerServiceImpl implements ConsumerService {
  
//  @Override
//  @KafkaListener(topics = "${kafka.topic-name}", groupId = "kafka-loggers")
//  public void consume(ConsumerRecord record) {
//    log.info(String.format("Topic - %s, Partition - %d, Value: %s", record.topic(), record.partition(), record.value()));
//  }

  @Override
  @KafkaListener(topics = "${kafka.topic-name}", groupId = "kafka-loggers")
  public void consume(String message) {
    System.out.println(String.format("$Kafka Message -> %s", message));
  }
  
}
