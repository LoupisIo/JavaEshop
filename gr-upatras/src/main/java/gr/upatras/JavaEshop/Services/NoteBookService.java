package gr.upatras.JavaEshop.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.upatras.JavaEshop.Item;
import gr.upatras.JavaEshop.IServices.IItemService;
import gr.upatras.JavaEshop.IServices.INoteBookService;
import gr.upatras.JavaEshop.NoteBook;


/**
 * 
 * @author loupis.io
 *
 */
@Service
public class NoteBookService implements INoteBookService {
	@Autowired
	private IItemService itemService;
	
	public NoteBookService() {
		super();
	}
	
	
	

	/**
	 * Add a NoteBook object to the Item's List.
	 * 
	 * @param {@link NoteBook}
	 * @return the @NoteBook added to the eshop application
	 * */
	@Override
	public NoteBook addNoteBook(NoteBook noteBook) {
		return (NoteBook) itemService.addItem(noteBook);
	}





	@Override
	public NoteBook editNoteBook(NoteBook noteBook) {
		NoteBook toEdit = (NoteBook) itemService.findById(noteBook.getId());
		if(toEdit != null) {
			itemService.removeItem(toEdit);
			
			return (NoteBook) itemService.addItem(noteBook);
			
		}
		return null;
	}





	@Override
	public List<NoteBook> findBySections(int sections) {
		List<NoteBook> noteBookList = new ArrayList<NoteBook>();
		for(Item item :itemService.returnAll()) {
			if(item instanceof NoteBook) {
				if(((NoteBook) item).getSections()==sections)
				noteBookList.add((NoteBook) item);
			}
		}
		return noteBookList;	
	}





	@Override
	public List<NoteBook> findByPageNum(int pagenum) {
		List<NoteBook> noteBookList = new ArrayList<NoteBook>();
		for(Item item :itemService.returnAll()) {
			if(item instanceof NoteBook) {
				if(((NoteBook) item).getPageNum() == pagenum)
				noteBookList.add((NoteBook) item);
			}
		}
		return noteBookList;	
	}


	
	
}
