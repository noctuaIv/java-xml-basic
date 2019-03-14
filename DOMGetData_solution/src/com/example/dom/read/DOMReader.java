package com.example.dom.read;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.example.model.Customer;

public class DOMReader {
	
	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public List<Customer> getDataFromXML(String filename) {
		
		List<Customer> data = new ArrayList<>();

		File xmlFile = new File(filename);
		Document doc = null;
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(xmlFile);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

//		Element root = doc.getDocumentElement();
//		System.out.println(root.getNodeName());
		
		NodeList list = doc.getElementsByTagName("customer");
		System.out.println("Nodes found: " + list.getLength());
		
		for (int i = 0; i < list.getLength(); i++) {
			Customer customer = new Customer();
			data.add(customer);
			
			Element custElement = (Element) list.item(i);
			String idAsString = custElement.getAttribute(Customer.ID);
			customer.setId(Integer.parseInt(idAsString));

			String content = getTextFromElement(custElement, Customer.NAME);
			customer.setName(content);
			
			String joined = getTextFromElement(custElement, Customer.JOINED);
			DateFormat df = new SimpleDateFormat(XMLDATEFORMAT);
			try {
				customer.setJoined(df.parse(joined));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
		return data;
		
	}

	private String getTextFromElement(Element custElement, String elementName) {
		Element node = (Element) custElement.getElementsByTagName(elementName).item(0);
		String content = node.getTextContent();
		return content;
	}

}
