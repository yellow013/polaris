package io.ffreedom.indicators;

import io.ffreedom.common.charset.Charsets;
import io.ffreedom.transport.core.role.Receiver;
import io.ffreedom.transport.rabbitmq.RabbitMqReceiver;
import io.ffreedom.transport.rabbitmq.config.RmqReceiverConfigurator;

public class MarketDataTest {

	public static void main(String[] args) {

		Receiver receiver = new RabbitMqReceiver("test-receiver",
				RmqReceiverConfigurator.configuration().setConnectionParam("", 5672)
						.setUserParam("reduser", "Centos123").setReceiveQueue("ctp_marketdata")
						.setAutomaticRecovery(true),
				bytes -> {
					System.out.println(new String(bytes, Charsets.UTF8));
				});

		receiver.receive();

	}

}
