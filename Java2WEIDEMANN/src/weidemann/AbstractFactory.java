package weidemann;

/**
 * A factory for creating Abstract objects.
 *
 * @author weidemann
 */
public abstract class AbstractFactory {
	
	/**
	 * Gets the view.
	 *
	 * @param theView  the view
	 * @return the view
	 */
	abstract ViewBase getView(String theView);

	/**
	 * Gets the model.
	 *
	 * @param theModel the model
	 * @return the model
	 */
	abstract ModelBase getModel(String theModel);

	/**
	 * Gets the control.
	 *
	 * @param theControl the control
	 * @return the control
	 */
	abstract ControlBase getControl(String theControl);

	/**
	 * Test.
	 *
	 * @param theString the string
	 */
	public void test(String theString) {
	}

}
