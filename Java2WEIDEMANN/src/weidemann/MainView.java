package weidemann;

import java.io.PrintWriter;

public class MainView implements ViewBase{

	@Override
	public void createFelder(String theCase) {
		
		deleteFelder();
		switch(theCase) {
			case "Erfassung":
				itsHTDoc.add("<html>");
				itsHTDoc.add("<script type='text/javascript'>");
					itsHTDoc.add("function enable_proceeding(){");
						itsHTDoc.add("if (document.all || document.getElementById){");
							itsHTDoc.add("if (document.mainForm.proc.disabled==true)");
								itsHTDoc.add("document.mainForm.proc.disabled=false;");
							itsHTDoc.add("}");
					itsHTDoc.add("}");
					itsHTDoc.add("function go_back(){");
						itsHTDoc.add("document.mainForm.return.value = 1;");
						itsHTDoc.add("document.mainForm.submit();");
					itsHTDoc.add("}");
				itsHTDoc.add("</script>");
				itsHTDoc.add("<head>");
					itsHTDoc.add("<meta charset='ISO-8859-1'>");
					itsHTDoc.add("<title>Inventarerfassung</title>");
				itsHTDoc.add("</head>");
				itsHTDoc.add("<body style='font-family:Verdana'>");
					itsHTDoc.add("<h1><u>Inventarerfassung</u></h1>");
					itsHTDoc.add("<form name='mainForm' method='POST'>");
						itsHTDoc.add("<p>Willkommen bei der Inventarerfassung. Bitte wählen Sie zunächst die Art des zu erfassenden Gegenstands.</p>");
						itsHTDoc.add("<p>");
							itsHTDoc.add("<input type='radio' name='gegenstand_art' value='Inv' onclick='enable_proceeding()'> Inventar<br>");
							itsHTDoc.add("<input type='radio' name='gegenstand_art' value='Imm' onclick='enable_proceeding()'> Immobilie<br>");
							itsHTDoc.add("<input type='radio' name='gegenstand_art' value='Agg' onclick='enable_proceeding()'> Ausstattungsgegenstand");
						itsHTDoc.add("</p>");
						itsHTDoc.add("<p>");
							itsHTDoc.add("<input type='submit' name='proc' value='Weiter' disabled>");
						itsHTDoc.add("</p>");
					itsHTDoc.add("</form>");
				itsHTDoc.add("</body>");
			itsHTDoc.add("</html>");
				break;
				
			case "Error":
				itsHTDoc.add("<html>");
				itsHTDoc.add("<script type='text/javascript'>");
					itsHTDoc.add("function enable_proceeding(){");
						itsHTDoc.add("if (document.all || document.getElementById){");
							itsHTDoc.add("if (document.mainForm.proc.disabled==true)");
								itsHTDoc.add("document.mainForm.proc.disabled=false");
							itsHTDoc.add("}");
					itsHTDoc.add("}");
				itsHTDoc.add("</script>");
				itsHTDoc.add("<head>");
					itsHTDoc.add("<meta charset='ISO-8859-1'>");
					itsHTDoc.add("<title>Inventarerfassung</title>");
				itsHTDoc.add("</head>");
				itsHTDoc.add("<body style='font-family:Verdana'>");
					itsHTDoc.add("<h1><u>Inventarerfassung</u></h1>");
					itsHTDoc.add("<form name='mainForm' method='POST'>");
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
	
	@Override
	public void deleteFelder() {
		itsHTDoc.clear();
	}

	@Override
	public void show(PrintWriter aPW) {
		for(String ausgabe : itsHTDoc) {
			aPW.println(ausgabe);
		};
	}

}
