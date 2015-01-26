package weidemann;

public class AGGModel implements ModelBase{
	
	@Override
	public void setContent(String[] theContent) {
		itsData[0] = "agg_ort";
		itsData[1] = theContent[0];
		itsData[2] = "agg_date";
		itsData[3] = theContent[1];
	}

	@Override
	public String[] getContent() {
		return itsData;
	}

}
