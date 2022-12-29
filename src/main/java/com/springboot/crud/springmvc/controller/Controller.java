package com.springboot.crud.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.springboot.crud.springmvc.service.KafkaProducerService;

@RestController
@RequestMapping("/kafka")
@Component
public class Controller {
	private static final Logger LOGGER=LoggerFactory.getLogger(Controller.class);
	
	private KafkaProducerService kafkaProducerService;

	public Controller(KafkaProducerService kafkaProducerService) {


		this.kafkaProducerService = kafkaProducerService;
	}
	@GetMapping("/adaptorTest")
	public String getAdatorTest()
	{
		return "ok success";
		
	}
	/*
	 * @GetMapping("/publish") public ResponseEntity<String>
	 * publish(@RequestParam("message")String message) {
	 * kafkaProducerService.sendMessage(message); return
	 * ResponseEntity.ok("message sent succesfully to the topic yes ");
	 * 
	 * }
	 */
	
	//@PostMapping(value="/publishMessage",consumes="application/json")
	@RequestMapping(value="/publishMessage",method=RequestMethod.POST ,consumes = "application/json")
	public ResponseEntity<String>publish(@RequestBody JsonNode jsonNode)
	{
	LOGGER.info("message recevied :"+jsonNode);
	try
	{
		kafkaProducerService.sendMessage(jsonNode.toString());
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return ResponseEntity.ok("message sent to kafka topic");
	}
	

}
