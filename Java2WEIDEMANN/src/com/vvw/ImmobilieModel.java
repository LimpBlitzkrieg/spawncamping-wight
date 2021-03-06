package com.vvw;

/**
 * The Class ImmobilieModel.
 * Model class for Immobilie.
 */
public class ImmobilieModel implements ModelBase{
	
	/*
	 * @see com.vvw.ModelBase#setContent(java.lang.String[])
	 */
	@Override
	public void setContent(String[] theContent) {
		itsData[0] = "imm_street";
		itsData[1] = theContent[0];
		itsData[2] = "imm_hnum";
		itsData[3] = theContent[1];
		itsData[4] = "imm_plz";
		itsData[5] = theContent[2];
		itsData[6] = "imm_ort";
		itsData[7] = theContent[3];
		itsData[8] = "imm_rooms";
		itsData[9] = theContent[4];
		itsData[10] = "imm_elevator";
		itsData[11] = theContent[5];
		for(int i = 12; i < itsData.length; i++) {
			itsData[i] = null;
		}
		
	}

	/*
	 * @see com.vvw.ModelBase#getContent()
	 */
	@Override
	public String[] getContent() {
		return itsData;
	}

}
