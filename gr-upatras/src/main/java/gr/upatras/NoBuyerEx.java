package gr.upatras;

public class NoBuyerEx extends Exception{
    
	public String exceptionMessage()
    {
        return "This Buyer does not exists";
    }
}
