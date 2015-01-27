package weidemann;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class InventarControl.
 * Control class for Inventargegenstand.
 */
public class InventarControl implements ControlBase {

	/** The Inventar model. */
	ModelBase itsModel = itsModelFactory.getModel("INV");

	/** The Inventar view. */
	ViewBase itsView = itsViewFactory.getView("INV");

	/** The Inventar date format for time stamping XML-Files. */
	DateFormat itsDateFormat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");

	/*
	 * 
	 * @see weidemann.ControlBase#parseXML()
	 */
	@Override
	public void parseXML() {
		String[] aContent = itsModel.getContent();
		String aFilename = "INV_" + itsDateFormat.format(itsDate);
		itsXMLParser.parseXML(aContent, aFilename);

	}

	/*
	 * 
	 * @see weidemann.ControlBase#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		itsView.createFelder("Erfassung");
		itsView.show(pw);
		pw.flush();
		pw.close();

	}

	/*
	 * 
	 * @see weidemann.ControlBase#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public int doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String[] aContent = new String[3];
		int aBack = 0;
		String aString = request.getParameter("inv_bez");
		String aDate = request.getParameter("inv_date");
		String aPerson = request.getParameter("inv_responsible");

		try {
			aBack = Integer.parseInt(request.getParameter("return"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if (aBack == 1)
			return -1;

		if (aString.isEmpty() || aPerson.isEmpty() || !validateDate(aDate)) {
			itsView.createFelder("Error");
			itsView.show(pw);
			pw.flush();
			pw.close();

			return 0;
		} else {
			aContent[0] = aString;
			aContent[1] = aDate;
			aContent[2] = aPerson;
			itsModel.setContent(aContent);
			parseXML();
			itsView.createFelder("Success");
			itsView.show(pw);
			pw.flush();
			pw.close();

			return 0;
		}

	}

	/**
	 * Validate date.
	 *
	 * @param theDate
	 *            the the date
	 * @return true, if successful
	 */
	public boolean validateDate(String theDate) {

		if (theDate == null) {
			return false;
		}

		SimpleDateFormat aDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date aDate = new Date();
		aDateFormat.setLenient(false);

		try {

			if (aDateFormat.parse(theDate).after(aDate))
				return false;

		} catch (ParseException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

}
