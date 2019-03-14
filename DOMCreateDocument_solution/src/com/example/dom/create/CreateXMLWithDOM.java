package com.example.dom.create;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class CreateXMLWithDOM {

	public static void main(String[] args) throws ParserConfigurationException {

		DOMCreator creator = new DOMCreator();
		Document doc = creator.createXMLDoc();
		System.out.println(doc.toString());
		
		Node root = doc.getFirstChild();
		System.out.println(root.getNodeName());
	}

}
