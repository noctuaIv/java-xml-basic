package com.example.stax.read;

import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import com.example.dataprovider.DataProvider;
import com.example.model.Customer;

public class ReadXMLWithStAXStream {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

		StAXStreamReader reader = new StAXStreamReader();
		List<Customer> data = reader.getDataFromXML(DataProvider.DATADIR + "customers.xml");
		for (Customer customer : data) {
			System.out.println(customer);
		}
		System.out.println("Data returned: " + data.size() + " customers");
	}

}
