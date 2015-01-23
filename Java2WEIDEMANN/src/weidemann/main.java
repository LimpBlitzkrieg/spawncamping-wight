package weidemann;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AbstractFactory itsControlFactory = FactoryProducer.getFactory("CONTROL");
	ControlBase itsControl = itsControlFactory.getControl("MAIN");
       
    public main() {
    	super();
    }
    
    public void setItsControl(ControlBase theControl){
    	itsControl = theControl;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		itsControl.doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		itsControl.doPost(request, response);
		//String aChoice = request.getParameter("gegenstand_art");
		//itsView = itsViewFactory.getView(aChoice);
		//doGet(request, response);
	}

}
