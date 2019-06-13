package com.demo.springkafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringKafkaApplication {

  private static final int PARTITION_NUM = 3; 
  private static final short REPLAICATION_NUM = 1;
  
  public static void main(String[] args) {
    SpringApplication.run(SpringKafkaApplication.class, args);
  }

  @Value("${kafka.topic-name}")
  private String topicName;

  @Bean
  public NewTopic adviceTopic() {
    return new NewTopic(topicName, PARTITION_NUM, REPLAICATION_NUM);
  }
}
