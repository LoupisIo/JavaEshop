

package gr.upatras.JavaEshop.Services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.upatras.JavaEshop.Item;
import gr.upatras.JavaEshop.IServices.IItemService;
import gr.upatras.JavaEshop.IServices.IPenService;
import gr.upatras.JavaEshop.Pen;


/**
 * 
 * @author loupis.io
 *
 */
@Service
public class PenService implements IPenService {
	@Autowired
	private IItemService itemService;
	
	public PenService() {
		super();
	}
	
	
	
	

	/**
	 * Add a Pen object to the Item's List.
	 * 
	 * @param {@link Pen}
	 * @return the @Pen added to the eshop application
	 * */
	@Override
	public Pen addPen(Pen pen) {
		
		
		return (Pen) itemService.addItem(pen);
	}
	
	@Override
	public List<Item> getAllPens() {
		
		
		return itemService.findByCategory("Pen");
	}



	


	@Override
	public Pen editPen(Pen pen) {
		Pen toEdit = (Pen) itemService.findById(pen.getId());
		if(toEdit != null) {
			itemService.removeItem(toEdit);
			
			return (Pen) itemService.addItem(pen);
			
		}
		return null;
	}





	@Override
	public List<Pen> findByColour(String colour) {
		List<Pen> penList = new ArrayList<Pen>();
		for(Item item :itemService.returnAll()) {
			if(item instanceof Pen) {
				if(((Pen) item).getColor().equals(colour))
				penList.add((Pen) item);
			}
		}
		return penList;	
	}





	@Override
	public List<Pen> findByTipSize(double tipsize) {
		List<Pen> penList = new ArrayList<Pen>();
		for(Item item :itemService.returnAll()) {
			if(item instanceof Pen) {
				if(((Pen) item).getTipSize() == tipsize)
				penList.add((Pen) item);
			}
		}
		return penList;	
	}

	
	
	
	
	
	
	
	
}
