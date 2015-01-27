package weidemann;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * The Class MainControl.
 * Control class for MainView.
 */
public class MainControl implements ControlBase{	
	
	/** The view. */
	ViewBase itsView = itsViewFactory.getView("MAIN");
	
	/*
	 * @see weidemann.ControlBase#parseXML()
	 */
	@Override
	public void parseXML() {
		// MainModel and XML-parsing not necessary until now.
		
	}

	/*
	 * @see weidemann.ControlBase#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
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
	 * @see weidemann.ControlBase#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public int doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String aChoice = request.getParameter("gegenstand_art");		
		
		if( aChoice == null || aChoice.isEmpty() ) {
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
