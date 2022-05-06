package gr.upatras;
/**
 * 
 */

/**
 * @author loupis.io
 *
 */
public class Buyer extends User {
	// Saves the User's bonus
	public int bonus;
	//Saves the User's bonus level ( Bronze, Silver, Gold )
	public String buyerCategory;
	// Represents the shopping cart of the User
	public ShoppingCart shc;
	
	//Constructor
	public Buyer(String name, String email){
        super(name,email);
        this.bonus=0;
        setCategory();
        this.shc=  new ShoppingCart(this);
    }
	
	//Function to set the buyers Category according to his bonus
	public void setCategory() {
		if (bonus<101) {
			this.buyerCategory = "BRONZE";
		}else if (bonus<201) {
			this.buyerCategory = "SILVER";
		}else {
			this.buyerCategory = "GOLD";
		}	
	}
	
	//Function to update the bonus of a user and his category
	public void setBonus(int x) {
		bonus = bonus + x;
		setCategory();
	}
	

}
