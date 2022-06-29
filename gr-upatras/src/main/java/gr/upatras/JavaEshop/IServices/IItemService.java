/**
 * 
 */
package gr.upatras.JavaEshop.IServices;

import java.util.ArrayList;
import java.util.List;

import gr.upatras.JavaEshop.Item;

/**
 * @author loupis.io
 *
 */
public interface IItemService {
	/**
	 * @param {@link Item}
	 * @returns the @Item added to the eshop application
	 * */
	Item addItem(Item item);
	
	/**
	 * @param id
	 * @return @Item
	 * */
	Item findById(int id);
	
	/**
	 * @param @Item
	 * @return
	 */
	void removeItem(Item item);
	
	/**
	 * 
	 * @return All products
	 */
	
	List<Item> returnAll();
	
	/**
	 * 
	 * @param @number id
	 * @param @number number
	 * @return @Item
	 */
	Item setStock(int id,int number);
	
	/**
	 * 
	 * @param @string category
	 * @return A list of @Item of that category
	 */
	List<Item> findByCategory(String category); 
	
	
	
	
	
	
}
