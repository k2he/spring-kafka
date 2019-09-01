package com.demo.springkafka.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.springkafka.model.Message;
import com.demo.springkafka.service.ProducerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

  @NonNull
  private ProducerService producerService;

  // Eg: http://localhost:9000/kafka/publish?message=test
  @PostMapping(value = "/publish")
  public ResponseEntity<String> sendMessageToKafkaTopic(@RequestBody Message message) {
    this.producerService.sendMessage(message);
    return new ResponseEntity<>("Message published successfully!", HttpStatus.OK);
  }
}
