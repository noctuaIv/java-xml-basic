package com.example.stax.create;

import java.io.StringWriter;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.example.model.Customer;

public class StAXStreamCreator {

	@SuppressWarnings("unused")
	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public void createDocument(List<Customer> data, String filename) throws XMLStreamException {
	
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		
		StringWriter sw = new StringWriter();
		XMLStreamWriter writer = factory.createXMLStreamWriter(sw);
		
		writer.writeStartDocument();
		writer.writeStartElement("customers");
		
		writer.writeEndElement();
		writer.writeEndDocument();
		
		writer.flush();
		writer.close();
		
		System.out.println(sw.toString());
		
	}

}
