package com.springboot.mymq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.mymq.recieve.DirectRecieve;

@SpringBootTest
class SpringMqSampleApplicationTests {

	@Autowired
	DirectRecieve DirectRecieve;
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	@Test
	public void directModeTest() {
		this.rabbitTemplate.convertAndSend("directExchange", "direct1", "direct mode message~!!");
	}
	
	@Test
	public void TopicModeTest() {
		this.rabbitTemplate.convertAndSend("topicExchange", "topic_key", "topic_key");
		this.rabbitTemplate.convertAndSend("topicExchange", "topic_key.aaaa", "topic_key.aaa");
	}
	
	@Test
	public void FanoutModeTest() {
		this.rabbitTemplate.convertAndSend("fanoutExchange", "", "Fanout message~!!");
	}
}
