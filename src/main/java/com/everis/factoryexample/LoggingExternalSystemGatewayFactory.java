package com.everis.factoriesexample;

public class LoggingExternalSystemGatewayFactory extends
		ExternalSystemGatewayFactory {

	private ExternalSystemGatewayFactory decoratedElementsFactory;

	LoggingExternalSystemGatewayFactory(
			ExternalSystemGatewayFactory decoratedElementsFactory) {
		this.decoratedElementsFactory = decoratedElementsFactory;
	}

	@Override
	public ExternalSystemGateway createGateway() {
		return new LoggingExternalSystemGatewayDecorator(
				decoratedElementsFactory.createGateway());
	}

}
