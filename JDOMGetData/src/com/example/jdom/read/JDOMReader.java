package com.example.jdom.read;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.DataConversionException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.example.model.Customer;

public class JDOMReader {

	@SuppressWarnings("unused")
	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public List<Customer> getDataFromXML(String filename) throws DataConversionException, ParseException {

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
		
		Element root = doc.getRootElement();
		List<Element> custElements = root.getChildren("customer");
		
		for (Element ce : custElements) {
			Customer customer = new Customer();
			data.add(customer);
			
			int id = Integer.parseInt(ce.getAttributeValue(Customer.ID));
			
			Attribute att = ce.getAttribute(Customer.ID);
			customer.setId(att.getIntValue());
			
			customer.setName(ce.getChildText(Customer.NAME));
			customer.setPhone(ce.getChildText(Customer.PHONE));
			customer.setAbout(ce.getChildText(Customer.ABOUT));
			customer.setAge(Integer.parseInt(ce.getChildText(Customer.AGE)));
			customer.setBalance(new BigDecimal(ce.getChildText(Customer.BALANCE)));
			customer.setActive(Boolean.parseBoolean(ce.getChildText(Customer.ACTIVE)));
			
			DateFormat df = new SimpleDateFormat(XMLDATEFORMAT);
			customer.setJoined(df.parse(ce.getChildText(Customer.JOINED)));
			
		}
		
//		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
//		String xmlString = outputter.outputString(doc);
//		System.out.println(xmlString);
		
		return data;

	}

}
