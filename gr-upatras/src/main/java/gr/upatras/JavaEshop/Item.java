package gr.upatras.JavaEshop;
import java.util.*;

/**
 * 
 */

/**
 * @author loupis.io
 *
 */
public abstract class Item {
	public String name;
	public double price;
	public String description;
	public int stock;
    public int id;
    public String Category;
    
    
    //Constructor
    public Item(int id,String name, String description, double price, int stock,String category) {
        this.description = description;
        this.name= name;
        this.price= price;
        this.stock= stock;
        this.id=id;
        this.Category= category;
    }
    
    
    //Setters and getters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDiscripsion() {
		return description;
	}
	
	public void setDiscripsion(String discripsion) {
		this.description = discripsion;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCategory() {
		return Category;
	}
	
	public void setCategory(String category) {
		Category = category;
	}
    
	public String getBasicInfo(){
        return id + " " + name + " " + price + '€' + " " + stock + " " + description ;
    }
	
    public abstract String getDetails();

    public String getFullDetails(){
        return getBasicInfo() +" " +getCategory() +" "+ getDetails() ;

     }
    
	

}
