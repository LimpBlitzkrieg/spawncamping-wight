package com.vvw;

/**
 * A factory for creating Model objects.
 */
public class ModelFactory extends AbstractFactory {

	/*
	 * @see com.vvw.AbstractFactory#getView(java.lang.String)
	 */
	@Override
	ViewBase getView(String theView) {
		// Mandatory overrides
		return null;
	}

	/*
	 * @see com.vvw.AbstractFactory#getModel(java.lang.String)
	 */
	@Override
	ModelBase getModel(String theModel) {
		switch (theModel) {
		case "IMM":
			return new ImmobilieModel();
		case "INV":
			return new InventarModel();
		case "AGG":
			return new AGGModel();
		default:
			return null;
		}
	}

	/*
	 * @see com.vvw.AbstractFactory#getControl(java.lang.String)
	 */
	@Override
	ControlBase getControl(String theControl) {
		// Mandatory overrides
		return null;
	}

}
