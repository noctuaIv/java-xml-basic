package com.example.dom.read;

import java.io.File;
import java.io.IOException;
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
	
	@SuppressWarnings("unused")
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
		}
		
		return data;
		
	}

}
