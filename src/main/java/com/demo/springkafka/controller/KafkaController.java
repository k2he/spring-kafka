package com.demo.springkafka.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo.springkafka.service.ConsumerServiceImpl;
import com.demo.springkafka.service.ProducerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping(value = "/kafka")
public class KafkaController {

  @NonNull
  private ProducerService producerService;

  // Eg: http://localhost:9000/kafka/publish?message=test
  @PostMapping(value = "/publish")
  public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
    log.info(message);
//    this.producerService.sendMessage(message);
  }
}
