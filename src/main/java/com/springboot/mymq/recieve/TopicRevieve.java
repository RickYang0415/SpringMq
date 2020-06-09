package com.springboot.mymq.recieve;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class TopicRevieve {
	
	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = "topicExchange", type = ExchangeTypes.TOPIC), 
			value = @Queue(value = "topic1"), key = "topic_key.#"))
	@RabbitHandler
	public void topicReceiver(String msg, Message message, Channel channel) throws Exception {
		System.out.println("topicReceiver: " + msg);
		System.out.println("topicReceiver: " + message.getMessageProperties().getConsumerQueue());
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
	}
	
}
