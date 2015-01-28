package com.vvw;

/**
 * The Interface ModelBase.
 */
public interface ModelBase {
	
	/** The String-array for all model related data. */
	String[] itsData = new String[30];
	
	/**
	 * Sets the content.
	 * Titles and every String from 'theContent' get inserted.
	 * The remaining space is being filled with null data.
	 *
	 * @param theContent the new content
	 */
	void setContent(String[] theContent);
	
	/**
	 * Gets the content, returns the 'itsData' array with all model data.
	 *
	 * @return the content
	 */
	String[] getContent();
}
