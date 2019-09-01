package com.demo.springkafka.model;

import lombok.Data;

@Data
public class Message {
  private int id;
  private String message;
  private String category;
}
