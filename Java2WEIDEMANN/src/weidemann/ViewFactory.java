package weidemann;

/**
 * A factory for creating View objects.
 */
public class ViewFactory extends AbstractFactory {

	/*
	 * @see weidemann.AbstractFactory#getView(java.lang.String)
	 */
	@Override
	ViewBase getView(String theView) {
		switch (theView) {
		case "IMM":
			return new ImmobilieView();
		case "INV":
			return new InventarView();
		case "AGG":
			return new AGGView();
		case "MAIN":
			return new MainView();
		default:
			return new MainView();
		}
	}

	/*
	 * @see weidemann.AbstractFactory#getModel(java.lang.String)
	 */
	@Override
	ModelBase getModel(String theModel) {
		// Mandatory overrides
		return null;
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
