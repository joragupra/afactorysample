package com.everis.factoriesexample;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

public class SimpleExternalSystemGateway implements ExternalSystemGateway {

	SimpleExternalSystemGateway() {
		System.out.println("Creating simple gateway...");
	}

	private ExternalSystemClient createClient() {
		return new ExternalSystemClient();
	}

	private Element convert(ESElement e) {
		Element result = new Element();
		result.setId(e.getIdentifier());
		result.setPropertyX(e.getProp());
		return result;
	}

	private ESElement convert(Element e) {
		ESElement result = new ESElement();
		result.setIdentifier(e.getId());
		result.setProp(e.getPropertyX());
		return result;
	}

	@Override
	public void deleteElement(long id) {
		createClient().delete(id);
	}

	@Override
	public Element retrieveElement(long id) {
		return convert(createClient().retrieve(id));
	}

	@Override
	public void createElement(Element e) {
		createClient().create(convert(e));
	}

	@Override
	public List<Element> findElementsByPropertyX(String value) {
		return new ArrayList<Element>(CollectionUtils.collect(createClient()
				.search("X", value), new Transformer() {
			@Override
			public Object transform(Object arg0) {
				if (!(arg0 instanceof ESElement)) {
					return null;
				}
				return convert((ESElement) arg0);
			}
		}));
	}
}
