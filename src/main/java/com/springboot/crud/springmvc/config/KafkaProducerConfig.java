package com.springboot.crud.springmvc.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.provider.ConfigProvider;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.*;
@EnableKafka
@Configuration
public class KafkaProducerConfig {
	 private static final Logger LOGGER=LoggerFactory.getLogger(KafkaProducerConfig.class);
	 @Value("${adaptor.kafka.topic.broker}")
	 private String broker;
	 
	 @Bean
	 public ProducerFactory<String, Object> producerFactory()
	 {
		 Map<String,Object> configProps=new HashMap<>();
		 configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,broker);
		 configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		 configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		 
		 
		 return new DefaultKafkaProducerFactory<String, Object>(configProps);
	 }
	 @Bean
	 public KafkaTemplate<String, Object> kafkaTemplate()
	 {
		 return new KafkaTemplate<>(producerFactory());
	 }
}

