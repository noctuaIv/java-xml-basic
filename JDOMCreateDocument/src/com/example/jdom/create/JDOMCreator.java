package com.example.jdom.create;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;

import com.example.model.Customer;

public class JDOMCreator {

	@SuppressWarnings("unused")
	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public JDOMCreator() {
	}
	
	public Document createXMLDocument(List<Customer> data) {
		Document doc = new Document();
		Element root = new Element("customers");
		doc.addContent(root);
		
		for (Customer customer : data) {
			Element custElement = new Element("customer");
			root.addContent(custElement);
		}
		
		return doc;
	}
}
