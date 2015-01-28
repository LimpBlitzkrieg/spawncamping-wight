package com.vvw;

import java.io.PrintWriter;

/**
 * The Class InventarView.
 * View class for Inventargegenstand.
 */
public class InventarView implements ViewBase{

	/*
	 * @see com.vvw.ViewBase#createFelder(java.lang.String)
	 */
	@Override
	public void createFelder(String theCase) {
		
		deleteFelder();
		switch(theCase) {
			case "Erfassung":
				itsHTDoc.add("<html>");
				itsHTDoc.add("<script type='text/javascript'>");
					itsHTDoc.add("function enable_proceeding(){");
						itsHTDoc.add("if (document.all || document.getElementById){");
							itsHTDoc.add("if (document.invForm.proc.disabled==true && document.invForm.inv_bez.value != '' && document.invForm.inv_date.value != '' && document.invForm.inv_responsible.value != '')");
								itsHTDoc.add("document.invForm.proc.disabled=false");
							itsHTDoc.add("}");
					itsHTDoc.add("}");
					itsHTDoc.add("function go_back(){");
						itsHTDoc.add("document.invForm.return.value = 1;");
						itsHTDoc.add("document.invForm.submit();");
					itsHTDoc.add("}");
				itsHTDoc.add("</script>");
				itsHTDoc.add("<head>");
					itsHTDoc.add("<meta charset='ISO-8859-1'>");
					itsHTDoc.add("<title>Inventarerfassung</title>");
				itsHTDoc.add("</head>");
				itsHTDoc.add("<body style='font-family:Verdana'>");
					itsHTDoc.add("<h1><u>Inventarerfassung</u></h1>");
					itsHTDoc.add("<form name='invForm' method='POST'>");
						itsHTDoc.add("<p>Sie haben 'Inventar' gewählt. Bitte spezifizieren Sie die folgenden Eigenschaften:</p>");
							itsHTDoc.add("<table>");
								itsHTDoc.add("<tr>");
									itsHTDoc.add("<td>Bezeichnung: </td><td><input type='text' name='inv_bez' onkeypress='enable_proceeding()'><br></td>");
								itsHTDoc.add("</tr>");
								itsHTDoc.add("<tr>");
									itsHTDoc.add("<td>Anschaffungsdatum: </td><td><input type='text' name='inv_date' value='TT.MM.JJJJ' onselect='enable_proceeding()'><br></td>"); // TODO: max='Todays Date'
								itsHTDoc.add("</tr>");
								itsHTDoc.add("<tr>");
									itsHTDoc.add("<td>Verantw. Mitarbeiter: </td><td><input type='text' name='inv_responsible' onkeypress='enable_proceeding()'><br></td>");
								itsHTDoc.add("</tr>");
								itsHTDoc.add("<tr>");
									itsHTDoc.add("<td><br><input name='return' type='hidden' value='0'><input type='button' name='back' value='Zurück' onclick='go_back()'> <input type='submit' name='proc' value='Weiter' disabled></td>");
								itsHTDoc.add("</tr>");
							itsHTDoc.add("</table>");
					itsHTDoc.add("</form>");
				itsHTDoc.add("</body>");
				itsHTDoc.add("</html>");
				break;
				
			case "Success":
				itsHTDoc.add("<html>");
				itsHTDoc.add("<script type='text/javascript'>");
					itsHTDoc.add("function enable_proceeding(){");
						itsHTDoc.add("if (document.all || document.getElementById){");
							itsHTDoc.add("if (document.invForm.proc.disabled==true)");
								itsHTDoc.add("document.invForm.proc.disabled=false");
							itsHTDoc.add("}");
					itsHTDoc.add("}");
				itsHTDoc.add("</script>");
				itsHTDoc.add("<head>");
					itsHTDoc.add("<meta charset='ISO-8859-1'>");
					itsHTDoc.add("<title>Inventarerfassung</title>");
				itsHTDoc.add("</head>");
				itsHTDoc.add("<body style='font-family:Verdana'>");
					itsHTDoc.add("<h1><u>Inventarerfassung</u></h1>");
					itsHTDoc.add("<form name='invForm' action='main' method='POST'>");
						itsHTDoc.add("<p>Datei wurde erfolgreich angelegt.</p>");
							itsHTDoc.add("<input type='hidden' name='return' value='1'><input type='submit' name='proceed' value='OK'>");
					itsHTDoc.add("</form>");
				itsHTDoc.add("</body>");
				itsHTDoc.add("</html>");
				break;
				
			case "Error":
				itsHTDoc.add("<html>");
				itsHTDoc.add("<script type='text/javascript'>");
					itsHTDoc.add("function enable_proceeding(){");
						itsHTDoc.add("if (document.all || document.getElementById){");
							itsHTDoc.add("if (document.invForm.proc.disabled==true)");
								itsHTDoc.add("document.invForm.proc.disabled=false");
							itsHTDoc.add("}");
					itsHTDoc.add("}");
				itsHTDoc.add("</script>");
				itsHTDoc.add("<head>");
					itsHTDoc.add("<meta charset='ISO-8859-1'>");
					itsHTDoc.add("<title>Inventarerfassung</title>");
				itsHTDoc.add("</head>");
				itsHTDoc.add("<body style='font-family:Verdana'>");
					itsHTDoc.add("<h1><u>Inventarerfassung</u></h1>");
					itsHTDoc.add("<form name='invForm' method='POST'>");
						itsHTDoc.add("<p>FEHLER! Bitte überprüfen Sie ihre Eingaben!</p>");
							itsHTDoc.add("<input type='button' name='return' value='Zurück' onclick='history.back()'>");
					itsHTDoc.add("</form>");
				itsHTDoc.add("</body>");
				itsHTDoc.add("</html>");
				break;
				
				default:
					break;
		}
	}
	
	/*
	 * @see com.vvw.ViewBase#deleteFelder()
	 */
	@Override
	public void deleteFelder() {
		itsHTDoc.clear();
	}

	/*
	 * @see com.vvw.ViewBase#show(java.io.PrintWriter)
	 */
	@Override
	public void show(PrintWriter aPW) {
		for(String ausgabe : itsHTDoc) {
			aPW.println(ausgabe);
		};
	}

}
