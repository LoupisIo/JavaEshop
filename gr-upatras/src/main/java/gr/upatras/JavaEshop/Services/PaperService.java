package gr.upatras.JavaEshop.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.upatras.JavaEshop.Item;
import gr.upatras.JavaEshop.IServices.IItemService;
import gr.upatras.JavaEshop.IServices.IPaperService;
import gr.upatras.JavaEshop.Paper;


/**
 * 
 * @author loupis.io
 *
 */
@Service
public class PaperService implements IPaperService {
	@Autowired
	private IItemService itemService;
	
	public PaperService() {
		super();
	}
	
	
	

	/**
	 * Add a Paper object to the Item's List.
	 * 
	 * @param {@link Paper}
	 * @return the @Paper added to the eshop application
	 * */
	@Override
	public Paper addPaper(Paper paper) {
		return (Paper) itemService.addItem(paper);
	}





	@Override
	public Paper editPaper(Paper paper) {
		Paper toEdit = (Paper) itemService.findById(paper.getId());
		if(toEdit != null) {
			itemService.removeItem(toEdit);
			
			return (Paper) itemService.addItem(paper);
			
		}
		return null;
	}





	@Override
	public List<Paper> findByWeight(int weight) {
		List<Paper> paperList = new ArrayList<Paper>();
		for(Item item :itemService.returnAll()) {
			if(item instanceof Paper) {
				if(((Paper) item).getWeight()==weight)
				paperList.add((Paper) item);
			}
		}
		return paperList;	
	}





	@Override
	public List<Paper> findByPageNum(int pagenum) {
		List<Paper> paperList = new ArrayList<Paper>();
		for(Item item :itemService.returnAll()) {
			if(item instanceof Paper) {
				if(((Paper) item).getPageNum() == pagenum)
				paperList.add((Paper) item);
			}
		}
		return paperList;	
	}


	
	
}
