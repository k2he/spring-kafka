package com.demo.springkafka.service;

import com.demo.springkafka.Order;

public interface ConsumerService {
  public void consume(Order order);
}
