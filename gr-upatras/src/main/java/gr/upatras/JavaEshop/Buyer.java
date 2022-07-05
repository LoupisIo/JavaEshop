package gr.upatras.JavaEshop;
/**
 * 
 */

/**
 * @author loupis.io
 *
 */
public class Buyer extends MyUser {
	// Saves the User's bonus
	public double bonus;
	//Saves the User's bonus level ( Bronze, Silver, Gold )
	public String buyerCategory;
	// Represents the shopping cart of the User
	public ShoppingCart shc;
	
	//Constructor
	public Buyer(String name, String email,String password){
        super(name,email,password);
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
	
	public void placeOrder(Item item, int quantity) {
		shc.addItemOrdered(item,quantity);
	}
	
	//Function to update the bonus of a user and his category
	public void setBonus(double x) {
		bonus = bonus + x;
		setCategory();
	}

	public String getBuyerCategory() {
		return buyerCategory;
	}

	public void setBuyerCategory(String buyerCategory) {
		this.buyerCategory = buyerCategory;
	}

	public ShoppingCart getShc() {
		return shc;
	}

	public void setShc(ShoppingCart shc) {
		this.shc = shc;
	}

	public double getBonus() {
		return bonus;
	}
	
	
	

}
