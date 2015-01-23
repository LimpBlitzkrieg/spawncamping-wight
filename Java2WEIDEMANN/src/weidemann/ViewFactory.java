package weidemann;

public class ViewFactory extends AbstractFactory {

	@Override
	ViewBase getView(String theView) {
		
		if(theView == null){
	         return null;
	      }		
	      
	      if(theView.equalsIgnoreCase("AGG")){
	         return new AGGView();
	         
	      }else if(theView.equalsIgnoreCase("IMM")){
	         return new ImmobilieView();
	         
	      }else if(theView.equalsIgnoreCase("INV")){
	         return new InventarView();
	         
	      }else if(theView.equalsIgnoreCase("MAIN")){
		         return new MainView();
	      }
		
		return null;
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
