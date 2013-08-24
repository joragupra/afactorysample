package com.everis.factoriesexample;

public class PerformanceExternalSystemGatewayDecoratorFactory extends
		ExternalSystemGatewayFactory {

	private ExternalSystemGatewayFactory decoratedElementsFactory;

	PerformanceExternalSystemGatewayDecoratorFactory(
			ExternalSystemGatewayFactory decoratedElementsFactory) {
		this.decoratedElementsFactory = decoratedElementsFactory;
	}

	@Override
	public ExternalSystemGateway createGateway() {
		return new PerformanceExternalSystemGatewayDecorator(
				decoratedElementsFactory.createGateway());
	}

}
