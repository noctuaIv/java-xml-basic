package com.example.jdom.create;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
			
			custElement.setAttribute(Customer.ID, Integer.toString(customer.getId()));
			
			addChildElement(custElement, Customer.NAME, customer.getName());
			addChildElement(custElement, Customer.PHONE, customer.getPhone());
			addChildElement(custElement, Customer.AGE, Integer.toString(customer.getAge()));
			addChildElement(custElement, Customer.ABOUT, customer.getAbout());
			addChildElement(custElement, Customer.BALANCE, customer.getBalance().toString());
			addChildElement(custElement, Customer.ACTIVE, Boolean.toString(customer.getActive()));
			
			DateFormat df = new SimpleDateFormat(XMLDATEFORMAT);
			addChildElement(custElement, Customer.JOINED, df.format(customer.getJoined()));
		}
		
		return doc;
		
	}
	
	private void addChildElement(Element parent, String elementName, String textValue) {
		Element child = new Element(elementName);
		child.setText(textValue);
		parent.addContent(child);
	}
	
}
