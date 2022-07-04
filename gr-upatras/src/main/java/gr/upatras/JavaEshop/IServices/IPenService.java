package gr.upatras.JavaEshop.IServices;

import java.util.ArrayList;
import java.util.List;

import gr.upatras.JavaEshop.Item;
import gr.upatras.JavaEshop.Pen;

/**
 * @author loupis.io
 *
 */
public interface IPenService {
	/**
	 * Add a Pen object to the Item's List.
	 * 
	 * @param {@link Pen}
	 * @return the @Pen added to the eshop application
	 * */
	Pen addPen(Pen pen);

	
	/**
	 * Updates a Pen Item.
	 * 
	 * @param @Pen Pen
	 * @return the edited Pen
	 */
	Pen editPen(Pen pen);
	
	/**
	 * 
	 * @param @String colour
	 * @return A list of @Pen @Item matching the colour 
	 */
	List<Pen> findByColour(String colour);
	
	/**
	 * 
	 * @param @Double tip-size 
	 * @return A list of @Pen @Item matching the tip-size 
	 */
	
	List<Pen> findByTipSize(double tipsize);
	
	
	
	
	
	
	
	
	
}