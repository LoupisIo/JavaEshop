package gr.upatras.JavaEshop.IServices;

import java.util.ArrayList;
import java.util.List;

import gr.upatras.JavaEshop.Item;
import gr.upatras.JavaEshop.Pencil;

/**
 * @author loupis.io
 *
 */
public interface IPencilService {
	/**
	 * Add a Pencil object to the Item's List.
	 * 
	 * @param {@link Pencil}
	 * @return the @Pencil added to the eshop application
	 * */
	Pencil addPencil(Pencil Pencil);

	
	/**
	 * Updates a Pencil Item.
	 * 
	 * @param @Pencil Pencil
	 * @return the edited Pencil
	 */
	Pencil editPencil(Pencil Pencil);
	
	/**
	 * 
	 * @param @String colour
	 * @return A list of @Pencil @Item matching the colour 
	 */
	List<Pencil> findByType(String type);
	
	/**
	 * 
	 * @param @Double tip-size 
	 * @return A list of @Pencil @Item matching the tip-size 
	 */
	
	List<Pencil> findByTipSize(double tipsize);
	
}