package com.demo.springkafka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.demo.springkafka.model.Message;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {
  
  @Value("${kafka.topic-name}")
  private String TOPIC;

  @NonNull
  private KafkaTemplate<String, Message> kafkaTemplate;

  public void sendMessage(Message message) {
    log.info(String.format("$$ -> Producing message --> %s", message));
    this.kafkaTemplate.send(TOPIC, message);
  }
}
