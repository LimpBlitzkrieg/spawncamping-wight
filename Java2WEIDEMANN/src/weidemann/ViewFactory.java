package weidemann;

public class ViewFactory extends AbstractFactory {

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

	@Override
	ModelBase getModel(String theModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	ControlBase getControl(String theControl) {
		// TODO Auto-generated method stub
		return null;
	}

}
