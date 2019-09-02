package com.demo.springkafka.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import com.demo.springkafka.serializer.AvroSerializer;

import com.demo.springkafka.Order;

/*
 * It's important that we use the same type of key/value deserializers which we used in the
 * SenderConfig class.
 */
@EnableKafka
@Configuration
public class ReceiverConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;

  @Value("${spring.kafka.consumer.group-id}")
  private String group_id;

  @Value("${spring.kafka.consumer.auto-offset-reset}")
  private String offset_reset;

  @Bean
  public Map<String, Object> consumerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AvroSerializer.class);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, group_id);
    /*
     * earliest: automatically reset the offset to the earliest offset latest: automatically reset
     * the offset to the latest offset none: throw exception to the consumer if no previous offset
     * is found for the consumer’s group
     */
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offset_reset);

    return props;
  }

  @Bean
  public ConsumerFactory<String, Message> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
        new JsonDeserializer<>(Message.class));
  }

  @Bean
  public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Message>> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, Message> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }
}
