package weidemann;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControl implements ControlBase{	

	ModelBase itsModel = itsModelFactory.getModel("MAIN");
	ViewBase itsView = itsViewFactory.getView("MAIN");
	
	@Override
	public void parseXML() {
		// TODO Auto-generated method stub
		
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
		String aChoice = request.getParameter("gegenstand_art");		
		
		if( aChoice.isEmpty() ) {
			itsView.createFelder("Error");
			itsView.show(pw);
			return -1;
		}
		else
			switch (aChoice) {
				case "Inv":
					return 1;
				case "Imm":
					return 2;
				case "Agg":
					return 3;
				default:
					return -1;
			}
		
	}

}
