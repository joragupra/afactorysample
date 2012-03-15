package com.everis.factoriesexample;

public class SimpleExternalSystemGatewayFactory extends ExternalSystemGatewayFactory {

	@Override
	public ExternalSystemGateway createGateway() {
		return new SimpleExternalSystemGateway();
	}

}
