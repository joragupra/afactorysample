package com.everis.factoriesexample;

import java.util.List;

public interface ExternalSystemGateway {
	
	public void deleteElement(long id);
	
	public Element retrieveElement(long id);
	
	public void createElement(Element e);
	
	public List<Element> findElementsByPropertyX(String value);
}
