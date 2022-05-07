/**
 * 
 */
package gr.upatras;
import java.util.*;

/**
 * @author loupis.io
 *
 */
public class ItemOrdered  {
    Item item;
    int quantity;
    
    public ItemOrdered(Item item, int quaintity){

        this.item=item;
        this.quantity= quaintity;
    }
    public Item getItemOrd(){
        return item;
    }
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
}

