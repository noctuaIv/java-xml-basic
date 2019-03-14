package com.example.stax.create;

import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.example.model.Customer;

public class StAXStreamCreator {

	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public void createDocument(List<Customer> data, String filename) throws XMLStreamException {
	
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		
		StringWriter sw = new StringWriter();
		XMLStreamWriter writer = factory.createXMLStreamWriter(sw);
		
		writer.writeStartDocument();
		writer.writeStartElement("customers");
		
		for (Customer customer : data) {
			createCustElement(writer, customer);
		}
		
		writer.writeEndElement();
		writer.writeEndDocument();
		
		writer.flush();
		writer.close();
		
		System.out.println(sw.toString());
		
	}

	private void createCustElement(XMLStreamWriter writer, Customer customer) 
			throws XMLStreamException {
		writer.writeStartElement("customer");
		writer.writeAttribute(Customer.ID, Integer.toString(customer.getId()));
		
		writeDataElement(writer, customer.getName(), Customer.NAME);
		writeDataElement(writer, customer.getPhone(), Customer.PHONE);
		writeDataElement(writer, customer.getAbout(), Customer.ABOUT);
		writeDataElement(writer, Integer.toString(customer.getAge()), Customer.AGE);
		writeDataElement(writer, customer.getBalance().toString(), Customer.BALANCE);
		writeDataElement(writer, Boolean.toString(customer.getActive()), Customer.ACTIVE);
		
		DateFormat df = new SimpleDateFormat(XMLDATEFORMAT);
		writeDataElement(writer, df.format(customer.getJoined()), Customer.JOINED);
		
		writer.writeEndElement();
		
	}

	private void writeDataElement(XMLStreamWriter writer, String value, String elementName)
			throws XMLStreamException {
		writer.writeStartElement(elementName);
		writer.writeCharacters(value);
		writer.writeEndElement();
	}

}
