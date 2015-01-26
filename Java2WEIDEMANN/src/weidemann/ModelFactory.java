package weidemann;

public class ModelFactory extends AbstractFactory {

	@Override
	ViewBase getView(String theView) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	ModelBase getModel(String theModel) {
		switch (theModel) {
		case "IMM":
			return new ImmobilieModel();
		case "INV":
			return new InventarModel();
		case "AGG":
			return new AGGModel();
		case "MAIN":
			return new MainModel();
		default:
			return new MainModel();
		}
	}

	@Override
	ControlBase getControl(String theControl) {
		// TODO Auto-generated method stub
		return null;
	}

}
