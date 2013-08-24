package com.everis.factoriesexample;

public class AlterExternalSystemGatewayFactory extends
		ExternalSystemGatewayFactory {

	@Override
	public ExternalSystemGateway createGateway() {
		return new AlterExternalSystemGateway();
	}

}
