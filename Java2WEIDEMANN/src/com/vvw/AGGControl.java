package com.vvw;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//
/**
 * The Class AGGControl. Control-Class for Ausstattungsgegenstand.
 * Controls the models and the views data flow. 
 */
public class AGGControl implements ControlBase {

	/** The AGG model. */
	ModelBase itsModel = itsModelFactory.getModel("AGG");

	/** The AGG view. */
	ViewBase itsView = itsViewFactory.getView("AGG");

	/** Date format for time stamping XML-filenames */
	DateFormat itsDateFormat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");

	/*
	 * 
	 * @see com.vvw.ControlBase#parseXML()
	 */
	@Override
	public void parseXML() {
		String[] aContent = itsModel.getContent();
		String aFilename = "AGG_" + itsDateFormat.format(itsDate);
		itsXMLParser.parseXML(aContent, aFilename);
	}

	/*
	 * 
	 * @see com.vvw.ControlBase#doGet(javax.servlet.http.HttpServletRequest,
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
	 * @see com.vvw.ControlBase#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public int doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String[] aContent = new String[2];
		int aBack = 0;
		String aPlace = request.getParameter("agg_ort");
		String aDate = request.getParameter("agg_date");

		try {
			aBack = Integer.parseInt(request.getParameter("return"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if (aBack == 1)
			return -1;

		else if (aPlace == null || aPlace.isEmpty() || !validateDate(aDate)) {
			itsView.createFelder("Error");
			itsView.show(pw);
			pw.flush();
			pw.close();

			return 0;
		} else {
			aContent[0] = aPlace;
			aContent[1] = aDate;
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
	 *            the date
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
