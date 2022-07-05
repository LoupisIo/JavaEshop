package gr.upatras.JavaEshop.IServices;



import java.util.ArrayList;
import java.util.List;

import gr.upatras.JavaEshop.Item;
import gr.upatras.JavaEshop.Paper;

/**
 * @author loupis.io
 *
 */
public interface IPaperService {
	/**
	 * Add a Paper object to the Item's List.
	 * 
	 * @param {@link Paper}
	 * @return the @Paper added to the eshop application
	 * */
	Paper addPaper(Paper paper);

	
	/**
	 * Updates a Paper Item.
	 * 
	 * @param @Paper Paper
	 * @return the edited Paper
	 */
	Paper editPaper(Paper paper);
	
	/**
	 * 
	 * @param @number pageNum
	 * @return A list of @Paper @Item matching the PageNum 
	 */
	List<Paper> findByPageNum(int pageNum);
	
	/**
	 * 
	 * @param @Dnumber weight 
	 * @return A list of @Paper @Item matching the weight
	 */
	
	List<Paper> findByWeight(int weight);
	
	
	List<Item> getAll();
	
	
	
	
	
	
	
	
}