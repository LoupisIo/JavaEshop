/**
 * 
 */
package gr.upatras;

/**
 * @author loupis.io
 *
 */
public class Pencil extends Item {
	
	public double tipSize;
	public String type; /*H,B,HB*/
	
	public Pencil(int id, String name, String description, double price, int stock, String type, Double tipSize) {
		super(id, name, description, price, stock,"Pencil");
		this.type = type;
		this.tipSize = tipSize;
	}
	
	public String getDetails() {
        return type + " " + tipSize;
    }

	public double getTipSize() {
		return tipSize;
	}

	public void setTipSize(double tipSize) {
		this.tipSize = tipSize;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
