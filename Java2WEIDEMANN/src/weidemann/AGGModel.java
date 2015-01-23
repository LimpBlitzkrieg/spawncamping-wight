package weidemann;

public class AGGModel implements ModelBase{
	
	@Override
	public void setContent(String[] theContent) {
		itsData[0] = theContent[0];
		itsData[1] = theContent[1];
	}

	@Override
	public String[] getContent() {
		return itsData;
	}

}
