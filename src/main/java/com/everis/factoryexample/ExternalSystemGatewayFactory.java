package com.everis.factoriesexample;


public abstract class ExternalSystemGatewayFactory {
	
	public static final String SIMPLE = "SIMPLE";
	public static final String PERFORMANCE = "PERFORMANCE";
	public static final String LOGGING = "LOGGING";
	
	public static ExternalSystemGatewayFactory getFactory(){
		ExternalSystemGatewayFactory factory = null;
		if(readProperty(SIMPLE)){
			factory = new SimpleExternalSystemGatewayFactory();
		}
		else{
			factory = new AlterExternalSystemGatewayFactory();
		}
		if(readProperty(PERFORMANCE)){
			factory = new PerformanceExternalSystemGatewayDecoratorFactory(factory);
		}
		if(readProperty(LOGGING)){
			factory = new LoggingExternalSystemGatewayFactory(factory);
		}
		return factory;
	}
	
	private static boolean readProperty(String property){
		//read from DB or properties file
		if("SIMPLE".equals(property)){
			return System.currentTimeMillis()%2==0;
		}
		return true;
	}
	
	public abstract ExternalSystemGateway createGateway();
}
