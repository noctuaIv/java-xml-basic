package com.example.jdom.read;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.example.model.Customer;

public class JDOMReader {

	@SuppressWarnings("unused")
	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public List<Customer> getDataFromXML(String filename) {

		List<Customer> data = new ArrayList<>();

		File file = new File(filename);
		SAXBuilder builder = new SAXBuilder();
		Document doc = null;

		try {
			doc = builder.build(file);
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
			return null;

		}
		
		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		String xmlString = outputter.outputString(doc);
		System.out.println(xmlString);

		return data;

	}

}
