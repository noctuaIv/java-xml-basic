package com.example.stax.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.example.model.Customer;

public class StAXEventReader {

	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public List<Customer> getDataFromXML(String filename) throws FileNotFoundException, XMLStreamException {

		List<Customer> data = new ArrayList<>();
		Customer customer = null;

		InputStream in = new FileInputStream(new File(filename));
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader reader = factory.createXMLEventReader(in);
		
		while (reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
//			System.out.println(XMLStreamUtils.getEventTypeName(eventType));
			
			if (event.isStartElement()) {
				
//				String elementName = reader.getName().toString();
				StartElement se = event.asStartElement();
				String elementName = se.getName().getLocalPart();
				
				switch (elementName) {
				case "customer":
					customer = new Customer();
					data.add(customer);
					QName qName = new QName(Customer.ID);
					String idAsString = se.getAttributeByName(qName).getValue();
					customer.setId(Integer.parseInt(idAsString));
					break;
					
				case Customer.NAME:
					customer.setName(reader.getElementText());
					break;

				case Customer.PHONE:
					customer.setPhone(reader.getElementText());
					break;
					
				case Customer.ABOUT:
					customer.setAbout(reader.getElementText());
					break;
					
				case Customer.ACTIVE:
					customer.setActive(Boolean.parseBoolean(reader.getElementText()));
					break;

				case Customer.AGE:
					customer.setAge(Integer.parseInt(reader.getElementText()));
					break;
					
				case Customer.BALANCE:
					customer.setBalance(new BigDecimal(reader.getElementText()));
					break;
					
				case Customer.JOINED:
					DateFormat df = new SimpleDateFormat(XMLDATEFORMAT);
					try {
						customer.setJoined(df.parse(reader.getElementText()));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					break;
					
				default:
					break;
				}
				
			}
		}
		
		return data;
	}

}
