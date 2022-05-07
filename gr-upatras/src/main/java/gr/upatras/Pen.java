package gr.upatras;
import java.util.*;
/**
 * 
 */

/**
 * @author loupis.io
 *
 */
public class Pen extends Item{
	
	public String color;
	public double tipSize; /* In mm */
	
	
	public String getDetails() {
        return color + " " + tipSize;
    }
	
	public Pen(int id, String name, String description, double price, int stock, String color, Double tipSize) {
		super(id, name, description, price, stock,"Pen");
		this.color = color;
		this.tipSize = tipSize;
		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getTipSize() {
		return tipSize;
	}

	public void setTipSize(double tipSize) {
		this.tipSize = tipSize;
	}
	
	
	
}
