package weidemann;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControlBase {
	XMLParser itsXMLParser = new XMLParser();
	AbstractFactory itsViewFactory = FactoryProducer.getFactory("VIEW");
	AbstractFactory itsModelFactory = FactoryProducer.getFactory("MODEL");
	
	void parseXML();
	void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
