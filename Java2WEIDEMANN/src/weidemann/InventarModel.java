package weidemann;

public class InventarModel implements ModelBase{
		
	@Override
	public void setContent(String[] theContent) {
		itsData[0] = "inv_bez";
		itsData[1] = theContent[0];
		itsData[2] = "inv_date";
		itsData[3] = theContent[1];
		itsData[4] = "inv_responsible";
		itsData[5] = theContent[2];
		for(int i = 6; i < itsData.length; i++) {
			itsData[i] = null;
		}
		
	}


	@Override
	public String[] getContent() {
		return itsData;
	}

}
