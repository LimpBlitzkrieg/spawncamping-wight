package weidemann;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AGGControl implements ControlBase{	

	ModelBase itsModel = itsModelFactory.getModel("AGG");
	ViewBase itsView = itsViewFactory.getView("AGG");
	
	@Override
	public void parseXML() {
		String[] aContent = itsModel.getContent();
		String aFilename = "AGG_" + itsDateFormat.format(itsDate);
		itsXMLParser.parseXML(aContent, aFilename);
	}

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

	@Override
	public int doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String[] aContent = new String[2];
		int aBack = Integer.parseInt(request.getParameter("return"));
		String aPlace = request.getParameter("agg_ort");
		String aDate = request.getParameter("agg_date");

		if(aBack == 1)			
			return -1;
		
		else if(aPlace.isEmpty() || !validateDate(aDate)) {
			itsView.createFelder("Error");
			itsView.show(pw);
			pw.flush();
			pw.close();
			
			return 0;
		}
		else {
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

	public boolean validateDate(String theDate){
		 
		if(theDate == null){
			return false;
		}
		
		SimpleDateFormat aDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date aDate = new Date();
		aDateFormat.setLenient(false);
 
		try {
			
			if(aDateFormat.parse(theDate).after(aDate))
				return false;
 
		} catch (ParseException e) {
 
			e.printStackTrace();
			return false;
		}
 
		return true;
	}
}
