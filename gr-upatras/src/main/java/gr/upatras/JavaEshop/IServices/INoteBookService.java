package gr.upatras.JavaEshop.IServices;



import java.util.ArrayList;
import java.util.List;

import gr.upatras.JavaEshop.Item;
import gr.upatras.JavaEshop.NoteBook;

/**
 * @author loupis.io
 *
 */
public interface INoteBookService {
	/**
	 * Add a NoteBook object to the Item's List.
	 * 
	 * @param {@link NoteBook}
	 * @return the @NoteBook added to the eshop application
	 * */
	NoteBook addNoteBook(NoteBook noteBook);

	
	/**
	 * Updates a NoteBook Item.
	 * 
	 * @param @NoteBook NoteBook
	 * @return the edited NoteBook
	 */
	NoteBook editNoteBook(NoteBook noteBook);
	
	/**
	 * 
	 * @param @number pageNum
	 * @return A list of @NoteBook @Item matching the PageNum 
	 */
	List<NoteBook> findByPageNum(int pageNum);
	
	/**
	 * 
	 * @param @Dnumber sections 
	 * @return A list of @NoteBook @Item matching the sections
	 */
	
	List<NoteBook> findBySections(int sections);
	
	
	
	List<NoteBook> getAll();
	
	
	
	
	
	
	
	
	
}