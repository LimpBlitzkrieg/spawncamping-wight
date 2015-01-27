package weidemann;

/**
 * The Class FactoryProducer.
 */
public class FactoryProducer {
	   
   	/**
   	 * Gets the factory.
   	 *
   	 * @param choice the choice
   	 * @return the factory
   	 */
   	public static AbstractFactory getFactory(String choice){
	   
	      if(choice.equalsIgnoreCase("VIEW")){
	         return new ViewFactory();
	      }else if(choice.equalsIgnoreCase("MODEL")){
		         return new ModelFactory();
		  }else if(choice.equalsIgnoreCase("CONTROL")){
		         return new ControlFactory();
		  }
	      
	      return null;
	   }
	}
