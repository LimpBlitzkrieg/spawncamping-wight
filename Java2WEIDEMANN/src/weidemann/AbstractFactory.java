package weidemann;

public abstract class AbstractFactory {
	   abstract ViewBase getView(String theView);
	   abstract ModelBase getModel(String theModel);
	   abstract ControlBase getControl(String theControl);
}
