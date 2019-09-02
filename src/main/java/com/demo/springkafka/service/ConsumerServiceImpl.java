package com.demo.springkafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.demo.springkafka.Order;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConsumerServiceImpl implements ConsumerService {

  @Override
  @KafkaListener(topics = "${kafka.topic-name}", groupId = "kafka-loggers")
  public void consume(Order order) {
    log.info(String.format("$$ -> Consumed Message -> %s", order));
  }

}
