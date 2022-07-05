package gr.upatras.JavaEshop.Services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.upatras.JavaEshop.Item;
import gr.upatras.JavaEshop.NoteBook;
import gr.upatras.JavaEshop.Paper;
import gr.upatras.JavaEshop.Pen;
import gr.upatras.JavaEshop.Pencil;
import gr.upatras.JavaEshop.IServices.IItemService;

/**
 * @author loupis.io
 *  
 */


@Service
public class ItemService implements IItemService {
	
	List<Item> items = new ArrayList<Item>();
	int itemCounter = 99;
	
	public ItemService() {
		
		super();
		items.add(new Pencil(18, "Farbel-Castell Basic", "A basic Pencil for your everyday needs", 1.25 , 200,"HB",0.7));
		items.add(new Pencil(19, "Farbel-Castell Premium", "A premium Pencil for the expierienced user", 2.0 , 200,"HB",0.5));
		items.add(new Pencil(20, "Farbel-Castell Basic-H", "A basic Pencil for your everyday needs", 1.25 , 220,"H",0.7));
		items.add(new Pencil(121, "Farbel-Castell Premium-H", "A premium Pencil for the expierienced user", 2.0 , 280,"H",0.5));
		items.add(new Pen(47, "Bic-Basic-blue", "Simple blue pen", 2.00, 144, "blue", 0.5));
		items.add(new Pen(48, "Bic-Basic-red", "Simple red pen", 2.00, 158, "red", 0.5));
		items.add(new Pen(49, "Bic-Basic-black", "Simple black pen", 2.00, 280, "black", 0.5));
		items.add(new NoteBook(23,"big-NoteBook-A4","Basic big NoteBook",2.5,150,5,250));
		items.add(new NoteBook(22,"NoteBook-A4","Basic small NoteBook",2.5,99,3,150));
		items.add(new Paper(57,"Paper-A4", "500 sheets of A4 paper", 3.5, 500, 80, 500));
		items.add(new Paper(58,"Paper-A5", "500 sheets of A5 paper", 2.8, 500, 40, 500));    
		
	}

	
	
	
	
	@Override
	public List<Item> returnAll(){
		return items;
	}
	@Override
	public Item findById(int id) {
		for (Item i : items) {
			if(i.getId() == id) {
				return i;
			}
		}
		return null;
		
	}
	
	@Override
	public Item addItem(Item i) {
		itemCounter =+1;
		i.setId(itemCounter);
		items.add(i);
		return i;
	}
	@Override
	public void removeItem(Item i) {
		Item temp = findById(i.getId());
		if(temp != null) {
			items.remove(temp);
			return;
					}
		return;
	}
	
	@Override
	public Item setStock(int id,int number) {
		Item temp = findById(id);
		if(temp != null && number >= 0) {
			temp.setStock(number);
			return temp;
		}
		return null;
	}
	@Override
	public List<Item> findByCategory(String category){
		List<Item> result = new ArrayList<Item>() ;
		for(Item i : items) {
			if(i.getCategory().endsWith(category) ) {
				result.add(i);
			}
		}
		return result;	
	}
	
	
	public Paper makePaper(int id, String name, String description, double price, int stock, int weight, int pageNum) {
		Paper paper = new Paper(id, name, description, price, stock, weight, pageNum);
		addItem(paper);
		
		return (Paper) addItem(paper);
		
	}
	

}
