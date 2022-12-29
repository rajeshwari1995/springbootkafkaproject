package com.springboot.crud.springmvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
 private static final Logger LOGGER=LoggerFactory.getLogger(KafkaProducerService.class);
 @Value("${adaptor.kafka.topic}") 
 private String topic;
 @Autowired
 private KafkaTemplate<String,Object> kafkaTemplate;
 
 public void sendMessage(String message)
 {
	 try {
		 kafkaTemplate.send(topic, message);
		 
	 }
	 catch(Exception e)
	 {
		e.printStackTrace(); 
	 }
 }


}
