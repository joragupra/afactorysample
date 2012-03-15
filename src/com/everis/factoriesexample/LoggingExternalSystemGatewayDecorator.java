package com.everis.factoriesexample;

import java.util.List;

public class LoggingExternalSystemGatewayDecorator implements
		ExternalSystemGateway {
	
	private ExternalSystemGateway decoratedGateway;
	
	LoggingExternalSystemGatewayDecorator(ExternalSystemGateway decoratedGateway){
		this.decoratedGateway = decoratedGateway;
	}

	@Override
	public void deleteElement(long id) {
		System.out.println("Deleting...");
		decoratedGateway.deleteElement(id);
	}

	@Override
	public Element retrieveElement(long id) {
		System.out.println("Retrieving...");
		return decoratedGateway.retrieveElement(id);
	}

	@Override
	public void createElement(Element e) {
		System.out.println("Creating...");
		decoratedGateway.createElement(e);
	}

	@Override
	public List<Element> findElementsByPropertyX(String value) {
		System.out.println("Finding...");
		return decoratedGateway.findElementsByPropertyX(value);
	}

}
