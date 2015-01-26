package weidemann;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControlBase {
	XMLParser itsXMLParser = new XMLParser();
	AbstractFactory itsViewFactory = FactoryProducer.getFactory("VIEW");
	AbstractFactory itsModelFactory = FactoryProducer.getFactory("MODEL");
	DateFormat itsDateFormat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
	Date itsDate = new Date();
	
	void parseXML();
	void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	int doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
