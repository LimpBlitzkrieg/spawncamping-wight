package weidemann;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Interface ControlBase.
 */
public interface ControlBase {

	/** The xml parser. */
	XMLParser itsXMLParser = new XMLParser();

	/** The view factory. */
	AbstractFactory itsViewFactory = FactoryProducer.getFactory("VIEW");

	/** The model factory. */
	AbstractFactory itsModelFactory = FactoryProducer.getFactory("MODEL");

	/** The date for time stamping XML-Files in derivatives. */
	Date itsDate = new Date();

	/**
	 * Parses the xml.
	 * Get content from model class and hand it to the XML-Parser.
	 * Puts time stamp behind filename.
	 */
	void parseXML();

	/**
	 * Handles all GET-Requests to the servlet, depending on which control object is active.
	 * Initial dynamic HTML-Document is forwarded to the user.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * Handles all POST-Requests to the servlet, depending on which control object is active.
	 * Every HTML-Form input gets verified/checked and then is handed to the according model object to store.
	 * Following, the XML-Document is created from model data and stored. 
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the int
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	int doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
