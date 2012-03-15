package com.everis.factoriesexample;

import java.util.ArrayList;
import java.util.Collection;

public class ExternalSystemClient {
	
	public void delete(long id){
		//stuff
	}
	
	public void create(ESElement e){
		//stuff
	}
	
	public ESElement retrieve(long id){
		//look for element here
		//...
		return new ESElement();
	}
	
	public Collection<ESElement> search(String property, String value){
		Collection<ESElement> result = new ArrayList<ESElement>();
		for(int i=1;i<11;i++){
			ESElement e = new ESElement();
			e.setIdentifier(i);
			result.add(e);
		}
		return result;
	}
}
