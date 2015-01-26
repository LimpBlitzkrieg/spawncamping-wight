package weidemann;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImmobilieControl implements ControlBase{	

	ModelBase itsModel = itsModelFactory.getModel("IMM");
	ViewBase itsView = itsViewFactory.getView("IMM");
	
	@Override
	public void parseXML() {
		String[] aContent = itsModel.getContent();
		String aFilename = "IMM_" + itsDateFormat.format(itsDate);
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
		String[] aContent = new String[6];
		int aBack = Integer.parseInt(request.getParameter("return"));
		String aStreet = request.getParameter("imm_street");
		String aHnum = request.getParameter("imm_hnum");
		String aPLZ = request.getParameter("imm_plz");
		String aPlace = request.getParameter("imm_ort");
		String aCount = request.getParameter("imm_rooms");
		String aHasElevator = request.getParameter("imm_elevator");
		
		if(aBack == 1)
			return -1;
		
		if( aStreet.isEmpty() || aHnum.isEmpty() || aPLZ.isEmpty() || aPlace.isEmpty() || aCount.isEmpty() || aHasElevator.isEmpty()) {
			itsView.createFelder("Error");
			itsView.show(pw);
			pw.flush();
			pw.close();
			
			return 0;
		}
		else {
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
