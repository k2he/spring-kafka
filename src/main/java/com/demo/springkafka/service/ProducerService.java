package com.demo.springkafka.service;

import com.demo.springkafka.Order;

public interface ProducerService {
  public void sendMessage(Order order);
}
