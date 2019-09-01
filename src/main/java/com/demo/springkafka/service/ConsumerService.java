package com.demo.springkafka.service;

import com.demo.springkafka.model.Message;

public interface ConsumerService {
  public void consume(Message message);
}
