package com.vvw;

import java.io.PrintWriter;

/**
 * The Class ImmobilieView.
 * View class for Immobilie.
 */
public class ImmobilieView implements ViewBase{

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
							itsHTDoc.add("if (document.immForm.proc.disabled==true"
									+ " && document.immForm.imm_street.value != ''"
									+ " && document.immForm.imm_hnum.value != 0"
									+ " && document.immForm.imm_plz.value != 0"
									+ " && document.immForm.imm_ort.value != ''"
									+ " && document.immForm.imm_rooms.value != 0)"); // TODO: Check, whether a radio is checked or not
								itsHTDoc.add("document.immForm.proc.disabled=false");
							itsHTDoc.add("}");
					itsHTDoc.add("}");
					itsHTDoc.add("function go_back(){");
						itsHTDoc.add("document.immForm.return.value = 1;");
						itsHTDoc.add("document.immForm.submit();");
					itsHTDoc.add("}");
				itsHTDoc.add("</script>");
				itsHTDoc.add("<head>");
					itsHTDoc.add("<meta charset='ISO-8859-1'>");
					itsHTDoc.add("<title>Inventarerfassung</title>");
				itsHTDoc.add("</head>");
				itsHTDoc.add("<body style='font-family:Verdana'>");
					itsHTDoc.add("<h1><u>Inventarerfassung</u></h1>");
					itsHTDoc.add("<form name='immForm' method='POST'>");
						itsHTDoc.add("<p>Sie haben 'Immobilie' gewählt. Bitte spezifizieren Sie die folgenden Eigenschaften:</p>");
							itsHTDoc.add("<table>");
								itsHTDoc.add("<tr>");
									itsHTDoc.add("<td>Straße: </td><td><input type='text' name='imm_street' onkeypress='enable_proceeding()'></td><td>Hausnummer: </td><td><input type='number' min='1' name='imm_hnum' onchange='enable_proceeding()'><br></td>");
								itsHTDoc.add("</tr>");
								itsHTDoc.add("<tr>");
									itsHTDoc.add("<td>Postleitzahl: </td><td><input type='number' min='01001' max='99998' name='imm_plz' onchange='enable_proceeding()'></td><td>Ort: </td><td><input type='text' name='imm_ort' onkeypress='enable_proceeding()'><br></td>");
								itsHTDoc.add("</tr>");
								itsHTDoc.add("<tr>");
									itsHTDoc.add("<td>Zimmeranzahl: </td><td><input type='number' min='1' name='imm_rooms' onchange='enable_proceeding()'></td><td>Mit Aufzug: </td><td><input type='radio' name='imm_elevator' value='true' onselect='enable_proceeding()'> Ja <input type='radio' name='imm_elevator' value='false' onselect='enable_proceeding()'> Nein<br></td>");
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
							itsHTDoc.add("if (document.immForm.proc.disabled==true)");
								itsHTDoc.add("document.immForm.proc.disabled=false");
							itsHTDoc.add("}");
					itsHTDoc.add("}");
				itsHTDoc.add("</script>");
				itsHTDoc.add("<head>");
					itsHTDoc.add("<meta charset='ISO-8859-1'>");
					itsHTDoc.add("<title>Inventarerfassung</title>");
				itsHTDoc.add("</head>");
				itsHTDoc.add("<body style='font-family:Verdana'>");
					itsHTDoc.add("<h1><u>Inventarerfassung</u></h1>");
					itsHTDoc.add("<form name='immForm' action='MainServlet' method='POST'>");
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
							itsHTDoc.add("if (document.immForm.proc.disabled==true)");
								itsHTDoc.add("document.immForm.proc.disabled=false");
							itsHTDoc.add("}");
					itsHTDoc.add("}");
				itsHTDoc.add("</script>");
				itsHTDoc.add("<head>");
					itsHTDoc.add("<meta charset='ISO-8859-1'>");
					itsHTDoc.add("<title>Inventarerfassung</title>");
				itsHTDoc.add("</head>");
				itsHTDoc.add("<body style='font-family:Verdana'>");
					itsHTDoc.add("<h1><u>Inventarerfassung</u></h1>");
					itsHTDoc.add("<form name='immForm'>");
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
