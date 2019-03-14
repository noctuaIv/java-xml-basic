package com.example.jaxb.create;

import java.io.IOException;
import java.util.List;

import com.example.dataprovider.DataProvider;
import com.example.jaxb.model.Customer;

public class CreateXMLWithJAXB {

	public static void main(String[] args) throws IOException {

		List<Customer> data = DataProvider.getData(DataProvider.SMALL);
		
	}

}
