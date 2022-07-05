

package gr.upatras.JavaEshop.Services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.upatras.JavaEshop.Item;
import gr.upatras.JavaEshop.IServices.IItemService;
import gr.upatras.JavaEshop.IServices.IPencilService;
import gr.upatras.JavaEshop.Pencil;


/**
 * 
 * @author loupis.io
 *
 */
@Service
public class PencilService implements IPencilService {
	@Autowired
	private IItemService itemService;
	
	public PencilService() {
		super();
	}
	
	
	

	/**
	 * Add a Pencil object to the Item's List.
	 * 
	 * @param {@link Pencil}
	 * @return the @Pencil added to the eshop application
	 * */
	@Override
	public Pencil addPencil(Pencil pencil) {
		return (Pencil) itemService.addItem(pencil);
	}

	@Override
	public List<Item> getAllPencils() {
		
		
		return itemService.findByCategory("Pencil");
	}





	@Override
	public Pencil editPencil(Pencil pencil) {
		Pencil toEdit = (Pencil) itemService.findById(pencil.getId());
		if(toEdit != null) {
			itemService.removeItem(toEdit);
			
			return (Pencil) itemService.addItem(pencil);
			
		}
		return null;
	}





	@Override
	public List<Pencil> findByType(String type) {
		List<Pencil> pencilList = new ArrayList<Pencil>();
		for(Item item :itemService.returnAll()) {
			if(item instanceof Pencil) {
				if(((Pencil) item).getType().equals(type))
				pencilList.add((Pencil) item);
			}
		}
		return pencilList;	
	}





	@Override
	public List<Pencil> findByTipSize(double tipsize) {
		List<Pencil> pencilList = new ArrayList<Pencil>();
		for(Item item :itemService.returnAll()) {
			if(item instanceof Pencil) {
				if(((Pencil) item).getTipSize() == tipsize)
				pencilList.add((Pencil) item);
			}
		}
		return pencilList;	
	}

	
	
	
	
	
	
	
	
}
