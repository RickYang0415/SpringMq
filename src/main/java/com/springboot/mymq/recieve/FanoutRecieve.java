package com.springboot.mymq.recieve;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class FanoutRecieve {

	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = "fanoutExchange", type = ExchangeTypes.FANOUT), value = @Queue(value = "fanout1")))
	public void receiverFanout1(String msg, Channel channel, Message message) {
		System.out.println("receiverFanout1: " + msg);
	}

}
