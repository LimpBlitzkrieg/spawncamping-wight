package weidemann;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * The Class XMLParser.
 * Creates a XML-Document from a given String[] of Content 'theContent' and a Filename 'theFilename'.
 */
public class XMLParser {

	/**
	 * Parses the xml.
	 * Creates a new XML-document and writes 'theContent' into its nodes.
	 *
	 * @param theContent the content
	 * @param theFilename the filename
	 */
	void parseXML(String[] theContent, String theFilename) {
		try {
			 
			DocumentBuilderFactory aDoc_F = DocumentBuilderFactory.newInstance();
			DocumentBuilder aDoc_B = aDoc_F.newDocumentBuilder();
	 
			Document aDoc = aDoc_B.newDocument();
			Element rootElement = aDoc.createElement("Objekt");
			aDoc.appendChild(rootElement);
			
			for(int i = 0; i + 2 < theContent.length; i += 2) {
				if(theContent[i] != null){
					Element aElement = aDoc.createElement(theContent[i]);
					aElement.appendChild(aDoc.createTextNode(theContent[i + 1]));
					rootElement.appendChild(aElement);
				}
			}
	 
			TransformerFactory aTrans_F = TransformerFactory.newInstance();
			Transformer aTrans = aTrans_F.newTransformer();
			DOMSource aDOMS = new DOMSource(aDoc);
			File aDir = new File("XMLFiles");
			 if (!aDir.exists())
				aDir.mkdir();
			StreamResult aOutput = new StreamResult(new File("/" + aDir + "/" + theFilename + ".xml"));
	 
			aTrans.setOutputProperty(OutputKeys.INDENT, "yes");
			aTrans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTrans.transform(aDOMS, aOutput);
	 
		  } catch (ParserConfigurationException PCE) {
			PCE.printStackTrace();
		  } catch (TransformerException TFE) {
			TFE.printStackTrace();
		  }
		
	}
}
