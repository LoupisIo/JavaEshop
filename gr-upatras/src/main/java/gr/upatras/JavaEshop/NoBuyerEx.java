package gr.upatras.JavaEshop;

public class NoBuyerEx extends Exception{
    
	public String exceptionMessage()
    {
        return "This Buyer does not exists";
    }
}
