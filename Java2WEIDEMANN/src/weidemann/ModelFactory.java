package weidemann;

/**
 * A factory for creating Model objects.
 */
public class ModelFactory extends AbstractFactory {

	/*
	 * @see weidemann.AbstractFactory#getView(java.lang.String)
	 */
	@Override
	ViewBase getView(String theView) {
		// Mandatory overrides
		return null;
	}

	/*
	 * @see weidemann.AbstractFactory#getModel(java.lang.String)
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
	 * @see weidemann.AbstractFactory#getControl(java.lang.String)
	 */
	@Override
	ControlBase getControl(String theControl) {
		// Mandatory overrides
		return null;
	}

}
