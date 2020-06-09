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
public class DirectRecieve {

	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = "directExchange", type = ExchangeTypes.DIRECT), value = @Queue(value = "direct1"), key = "direct1"))
	@RabbitHandler
	public void direct1Receiver(String msg, Message message, Channel channel) throws Exception {
		System.out.println("direct1Receiver: " + msg);
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
	}

}
