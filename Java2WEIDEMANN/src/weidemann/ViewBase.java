package weidemann;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * The Interface ViewBase.
 */
public interface ViewBase {
	
	/** The virtual HTML-document. */
	ArrayList<String> itsHTDoc = new ArrayList<String>();
	
	/**
	 * Creates the response to requests implementing HTML and JavaScript.
	 * For further comment @see derivative overrides.
	 *
	 * @param theCase the the case
	 */
	void createFelder(String theCase);
	
	/**
	 * Empties the HTML-document.
	 */
	void deleteFelder();
	
	/**
	 * Presents the HTML-document using the specified PrintWriter 'thePW'.
	 *
	 * @param thePW the PrintWriter
	 */
	void show(PrintWriter thePW);
}
