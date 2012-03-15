package com.everis.factoriesexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

public class AlterExternalSystemGateway implements ExternalSystemGateway {
	
	AlterExternalSystemGateway(){
		System.out.println("Creating alternative gateway...");
	}
	
	private AlterExternalSystemClient createClient() {
		return new AlterExternalSystemClient();
	}

	private Element convert(AESElement e) {
		Element result = new Element();
		result.setId(e.getId());
		result.setPropertyX(e.getProperty());
		return result;
	}

	private AESElement convert(Element e) {
		AESElement result = new AESElement();
		result.setId(e.getId());
		result.setProperty(e.getPropertyX());
		return result;
	}

	@Override
	public void deleteElement(long id) {
		createClient().delete(id);
	}

	@Override
	public Element retrieveElement(long id) {
		return convert(createClient().findById(id));
	}

	@Override
	public void createElement(Element e) {
		createClient().create(convert(e));
	}

	@Override
	public List<Element> findElementsByPropertyX(String value) {
		return new ArrayList<Element>(CollectionUtils.collect(
				Arrays.asList(createClient().searchByProperty(value)),
				new Transformer() {
					@Override
					public Object transform(Object arg0) {
						if (!(arg0 instanceof AESElement)) {
							return null;
						}
						return convert((AESElement) arg0);
					}
				}));
	}

}
