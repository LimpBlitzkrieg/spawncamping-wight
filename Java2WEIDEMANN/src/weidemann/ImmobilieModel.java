package weidemann;

public class ImmobilieModel implements ModelBase{
	
	@Override
	public void setContent(String[] theContent) {
		itsData[0] = theContent[0];
		itsData[1] = theContent[1];
		itsData[2] = theContent[2];
		
	}

	@Override
	public String[] getContent() {
		return itsData;
	}

}
