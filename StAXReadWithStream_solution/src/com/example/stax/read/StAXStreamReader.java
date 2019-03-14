package com.example.stax.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javanet.staxutils.XMLStreamUtils;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.example.model.Customer;

public class StAXStreamReader {

	@SuppressWarnings("unused")
	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public List<Customer> getDataFromXML(String filename) throws FileNotFoundException, XMLStreamException {

		List<Customer> data = new ArrayList<>();

		InputStream in = new FileInputStream(new File(filename));
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(in);
		
		int eventType = reader.next();
		System.out.println(XMLStreamUtils.getEventTypeName(eventType));
		
		while (reader.hasNext()) {
			eventType = reader.next();
			System.out.println(XMLStreamUtils.getEventTypeName(eventType));
		}
		
		return data;
	}

}
