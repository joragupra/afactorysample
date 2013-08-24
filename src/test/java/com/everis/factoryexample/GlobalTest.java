package com.everis.factoriesexample;

import junit.framework.TestCase;

public class GlobalTest extends TestCase {
	
	public void testAll(){
		Element e = ExternalSystemGatewayFactory.getFactory().createGateway().retrieveElement(1);
		assertNotNull(e);
	}
}
