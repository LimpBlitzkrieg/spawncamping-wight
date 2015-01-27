package weidemann;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class ImmobilieControl.
 * Control class for Immobilie.
 * Handles data flow of the model and the view.
 */
public class ImmobilieControl implements ControlBase {

	/** The Immobilie model. */
	ModelBase itsModel = itsModelFactory.getModel("IMM");

	/** The Immobilie view. */
	ViewBase itsView = itsViewFactory.getView("IMM");

	/** The date format for time stamping the XML-Filenames. */
	DateFormat itsDateFormat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");

	/*
	 * 
	 * @see weidemann.ControlBase#parseXML()
	 */
	@Override
	public void parseXML() {
		String[] aContent = itsModel.getContent();
		String aFilename = "IMM_" + itsDateFormat.format(itsDate);
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
		String[] aContent = new String[6];
		int aBack = 0;
		String aStreet = request.getParameter("imm_street");
		String aHnum = request.getParameter("imm_hnum");
		String aPLZ = request.getParameter("imm_plz");
		String aPlace = request.getParameter("imm_ort");
		String aCount = request.getParameter("imm_rooms");
		String aHasElevator = request.getParameter("imm_elevator");

		try {
			aBack = Integer.parseInt(request.getParameter("return"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if (aBack == 1)
			return -1;

		if (aStreet.isEmpty() || aHnum.isEmpty() || aPLZ.isEmpty()
				|| aPlace.isEmpty() || aCount.isEmpty()
				|| aHasElevator.isEmpty()) {
			itsView.createFelder("Error");
			itsView.show(pw);
			pw.flush();
			pw.close();

			return 0;
		} else {
			aContent[0] = aStreet;
			aContent[1] = aHnum;
			aContent[2] = aPLZ;
			aContent[3] = aPlace;
			aContent[4] = aCount;
			aContent[5] = aHasElevator;
			itsModel.setContent(aContent);
			parseXML();
			itsView.createFelder("Success");
			itsView.show(pw);
			pw.flush();
			pw.close();

			return 0;
		}

	}

}
