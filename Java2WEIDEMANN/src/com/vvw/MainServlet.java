package com.vvw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class MainServlet.
 * Main servlet to be executed on tomcat server.
 * BE ADVISED: Minimum required tomcat version is 8.0 for this and all according servlets!
 * Get the latest tomcat server at: http://tomcat.apache.org/
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The control factory. */
	AbstractFactory itsControlFactory = FactoryProducer.getFactory("CONTROL");
	
	/** The MainServlet control. */
	ControlBase itsControl = itsControlFactory.getControl("MAIN");
       
    /**
     * Instantiates a new MainServlet.
     */
    public MainServlet() {
    	super();
    }
    
    /**
     * Sets the control.
     *
     * @param theControl the new control
     */
    private void setControl(String theControl) {
    	itsControl = itsControlFactory.getControl(theControl);
    }
    
	/*
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		itsControl.doGet(request, response);
	}

	/*
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(itsControl.doPost(request, response)) {
			case 1:
				setControl("INV");
				break;
			case 2:
				setControl("IMM");
				break;
			case 3:
				setControl("AGG");
				break;
			case -1:
				setControl("MAIN");
				break;
			default:
				break;
		}
		
		doGet(request, response);
	}

}
