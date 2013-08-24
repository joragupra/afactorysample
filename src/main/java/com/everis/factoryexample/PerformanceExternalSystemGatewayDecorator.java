package com.everis.factoriesexample;

import java.util.List;

public class PerformanceExternalSystemGatewayDecorator implements
		ExternalSystemGateway {
	
	private ExternalSystemGateway decoratedGateway;
	
	PerformanceExternalSystemGatewayDecorator(ExternalSystemGateway gateway){
		this.decoratedGateway = gateway;
	}
	
	@Override
	public void deleteElement(long id) {
		long init = System.currentTimeMillis();
		decoratedGateway.deleteElement(id);
		System.out.println("Duration: " + (System.currentTimeMillis()-init));
	}

	@Override
	public Element retrieveElement(long id) {
		long init = System.currentTimeMillis();
		Element result = decoratedGateway.retrieveElement(id);
		System.out.println("Duration: " + (System.currentTimeMillis()-init));
		return result;
	}

	@Override
	public void createElement(Element e) {
		long init = System.currentTimeMillis();
		decoratedGateway.createElement(e);
		System.out.println("Duration: " + (System.currentTimeMillis()-init));
	}

	@Override
	public List<Element> findElementsByPropertyX(String value) {
		long init = System.currentTimeMillis();
		List<Element> result = decoratedGateway.findElementsByPropertyX(value);
		System.out.println("Duration: " + (System.currentTimeMillis()-init));
		return result;
	}

}
