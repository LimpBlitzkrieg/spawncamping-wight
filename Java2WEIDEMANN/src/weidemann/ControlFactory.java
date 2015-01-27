package weidemann;

/**
 * A factory for creating Control objects.
 */
public class ControlFactory extends AbstractFactory {

	/*
	 * Mandatory override.
	 */
	@Override
	ViewBase getView(String theView) {
		return null;
	}

	/* 
	 * Mandatory override.
	 */
	@Override
	ModelBase getModel(String theModel) {
		return null;
	}

	/* 
	 * Instantiate new control object depending on 'theControl'.
	 */
	@Override
	ControlBase getControl(String theControl) {
		switch (theControl) {
		case "IMM":
			return new ImmobilieControl();
		case "INV":
			return new InventarControl();
		case "AGG":
			return new AGGControl();
		case "MAIN":
			return new MainControl();
		default:
			return new MainControl();
		}
	}

}
