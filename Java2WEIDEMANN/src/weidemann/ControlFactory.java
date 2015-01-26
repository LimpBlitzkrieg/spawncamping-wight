package weidemann;

public class ControlFactory extends AbstractFactory {

	@Override
	ViewBase getView(String theView) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	ModelBase getModel(String theModel) {
		// TODO Auto-generated method stub
		return null;
	}

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
