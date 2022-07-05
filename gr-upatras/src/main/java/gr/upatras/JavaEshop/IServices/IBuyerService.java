package gr.upatras.JavaEshop.IServices;

import java.util.List;
import gr.upatras.JavaEshop.Buyer;
import gr.upatras.JavaEshop.Item;
import gr.upatras.JavaEshop.ItemOrdered;
import gr.upatras.JavaEshop.ShoppingCart;

/**
 * 
 * @author loupis.io
 *
 */

public interface IBuyerService {
	
	List<Buyer> getAll();
	
	Buyer addBuyer(Buyer buyer);
	
	Buyer createBuyer(String name, String password,String email);
	
	ShoppingCart getShpc(Buyer buyer);
	
	
	ItemOrdered addItemToSpc(Item order, int quantity, Buyer buyer);
	
	
	ItemOrdered deleteOrder(Buyer buyer,ItemOrdered order);
	
	
	ItemOrdered changeQuantity(Buyer buyer,ItemOrdered order,int newQuant);
	
	double calculateNet(Buyer buyer);
	
	
	double calculateCost(Buyer buyer);
	
	
	
	
	double calculateCourier(Buyer buyer);
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
