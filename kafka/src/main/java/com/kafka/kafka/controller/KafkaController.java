package com.kafka.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	String topic = "test";

	@RequestMapping
	public String produce(@RequestBody String body) {
		kafkaTemplate.send(topic, body);
		return "sent successfully";
	}
}
