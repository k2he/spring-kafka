package com.demo.springkafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerService {
  public void consume(ConsumerRecord record);
}
