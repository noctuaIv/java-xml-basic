package com.example.dom.read;

import java.util.List;

import com.example.dataprovider.DataProvider;
import com.example.model.Customer;

public class ReadXMLWithDOM {

	public static void main(String[] args) {

		DOMReader reader = new DOMReader();
		
		List<Customer> data = reader.getDataFromXML(DataProvider.DATADIR + "customers.xml");
		System.out.println("There are " + data.size() + " records");
		
		for (Customer customer : data) {
			System.out.println(customer);
		}
	}

}
