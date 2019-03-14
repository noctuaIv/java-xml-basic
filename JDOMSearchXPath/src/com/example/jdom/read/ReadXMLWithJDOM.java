package com.example.jdom.read;

import java.text.ParseException;
import java.util.List;

import org.jdom2.DataConversionException;

import com.example.dataprovider.DataProvider;
import com.example.model.Customer;

public class ReadXMLWithJDOM {

	public static void main(String[] args) throws DataConversionException, ParseException {

		JDOMReader reader = new JDOMReader();
		List<Customer> data = reader.getDataFromXML(DataProvider.DATADIR + "customers.xml", "//customer[age>= 65]");
		
		System.out.println("Number of customers: " + data.size());
		
		for (Customer customer : data) {
			System.out.println(customer);
		}
		
	}

}
