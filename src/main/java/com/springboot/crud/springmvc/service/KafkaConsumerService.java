package com.springboot.crud.springmvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class KafkaConsumerService {
	 private static final Logger LOGGER=LoggerFactory.getLogger(KafkaConsumerService.class);
	 
	 @Autowired(required=true)
	 @Qualifier("pacsProcess")
	 private IPacsProcess process;
	 
	 @KafkaListener(topics="${adaptor.kafka.topic}",groupId="${adaptor.kafka.groupId}")
	 public void processMeassage(@Payload String message,
			 @Header(KafkaHeaders.RECEIVED_TOPIC)String topic,
			 @Header(KafkaHeaders.RECEIVED_TIMESTAMP)long ts)
	 {
	LOGGER.info("message recevied by consumer 1: "+message);
	boolean result=process.processRequest(message);
	LOGGER.debug("return value : {}",result);
	 }
	 
}
