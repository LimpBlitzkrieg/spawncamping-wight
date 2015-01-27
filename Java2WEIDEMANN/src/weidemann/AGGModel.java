package weidemann;

public class AGGModel implements ModelBase{
	
	@Override
	public void setContent(String[] theContent) {
		itsData[0] = "agg_ort";
		itsData[1] = theContent[0];
		itsData[2] = "agg_date";
		itsData[3] = theContent[1];
		for(int i = 4; i < itsData.length; i++) {
			itsData[i] = null;
		}
	}

	@Override
	public String[] getContent() {
		return itsData;
	}

}
