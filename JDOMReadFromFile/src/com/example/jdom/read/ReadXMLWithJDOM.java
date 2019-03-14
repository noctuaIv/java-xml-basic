package com.example.jdom.read;

import java.util.List;

import com.example.dataprovider.DataProvider;
import com.example.model.Customer;

public class ReadXMLWithJDOM {

	public static void main(String[] args) {

		JDOMReader reader = new JDOMReader();
		List<Customer> data = reader.getDataFromXML(DataProvider.DATADIR + "customers.xml");
		
		System.out.println("Number of customers: " + data.size());
		
	}

}
