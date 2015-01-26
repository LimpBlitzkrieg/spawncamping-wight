package weidemann;

import java.io.PrintWriter;
import java.util.ArrayList;

public interface ViewBase {
	ArrayList<String> itsHTDoc = new ArrayList<String>();
	
	void createFelder(String theCase);
	void deleteFelder();
	void show(PrintWriter thePW);
}
