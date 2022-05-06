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
	
	public Pen(String color , double tipSize) {
		super(id, name, description, price, stock,"Pen");
		this.color = color;
		this.tipSize = tipSize;
		
	}
	
}
