package weidemann;

public class FactoryProducer {
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
