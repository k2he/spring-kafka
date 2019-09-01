package com.demo.springkafka.service;

import com.demo.springkafka.model.Message;

public interface ProducerService {
  public void sendMessage(Message message);
}
