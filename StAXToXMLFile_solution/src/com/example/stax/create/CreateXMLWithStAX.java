package com.example.stax.create;

import java.io.IOException;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import com.example.dataprovider.DataProvider;
import com.example.model.Customer;
import com.example.utilities.Stopwatch;

public class CreateXMLWithStAX {

	public static void main(String[] args) throws XMLStreamException, IOException {

		List<Customer> data = DataProvider.getData(DataProvider.LARGE);
		
		Stopwatch watch = new Stopwatch().start("Create XML with StAX");
		StAXStreamCreator creator = new StAXStreamCreator();
		creator.createDocument(data, "./output/customersLarge.xml");
		watch.stop();
		
	}
}
