package gr.upatras.JavaEshop.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.upatras.JavaEshop.Buyer;
import gr.upatras.JavaEshop.Item;
import gr.upatras.JavaEshop.ItemOrdered;
import gr.upatras.JavaEshop.MyUser;
import gr.upatras.JavaEshop.ShoppingCart;
import gr.upatras.JavaEshop.IServices.IBuyerService;
import gr.upatras.JavaEshop.IServices.IUserService;
import gr.upatras.JavaEshop.Services.UserService;

/**
 * 
 * @author loupis.io
 *
 */

@Service
public class BuyerService implements IBuyerService {
	
	
	@Autowired
	IUserService userService;
	
	List<Buyer> buyersList = new ArrayList<Buyer>();
	
	
	public BuyerService() {
		
		super();
		
		
	}
	

	@Override
	public List<Buyer> getAll() {
		
		return buyersList;
	}

	@Override
	public Buyer addBuyer(Buyer buyer) {
		List<Buyer> buyersList = new ArrayList<Buyer>();
		buyersList = userService.getBuyers();
		for(Buyer tempBuyer : buyersList) {
			if(tempBuyer.email.equals(buyer.email)) {
				return null;				
			}
		}
		buyersList.add(buyer);
		
		return buyer;
	}
	

	@Override
	public ShoppingCart getShpc(Buyer buyer) {
		List<Buyer> buyersList = new ArrayList<Buyer>();
		buyersList = userService.getBuyers();
			for(Buyer tempBuyer : buyersList) {
				if(tempBuyer.email.equals(buyer.email) && (tempBuyer.getPassWord().equals(buyer.getPassWord()))) {
					return tempBuyer.getShc();				
				}
			}
			return null;
	}

	@Override
	public ItemOrdered addItemToSpc(Item order,int quantity, Buyer buyer) {
		List<Buyer> buyersList = new ArrayList<Buyer>();
		buyersList = userService.getBuyers();
		for(Buyer tempBuyer : buyersList) {
			if(tempBuyer.email.equals(buyer.email) && (tempBuyer.getPassWord().equals(buyer.getPassWord()))) {
				return tempBuyer.shc.addItemOrdered(order, quantity);		
			}
		}
		return null;
	}

	@Override
	public ItemOrdered deleteOrder(Buyer buyer, ItemOrdered order) {
		List<Buyer> buyersList = new ArrayList<Buyer>();
		buyersList = userService.getBuyers();
		for(Buyer tempBuyer : buyersList) {
			if(tempBuyer.email.equals(buyer.email) && (tempBuyer.getPassWord().equals(buyer.getPassWord()))) {
				if(tempBuyer.shc.removeItemOrdered(order.getItem().id)) {
					return order;
					
				};		
			}
		}
		return null;
	}

	@Override
	public ItemOrdered changeQuantity(Buyer buyer, ItemOrdered order, int newQuant) {
		List<Buyer> buyersList = new ArrayList<Buyer>();
		buyersList = userService.getBuyers();
		for(Buyer tempBuyer : buyersList) {
			if(tempBuyer.email.equals(buyer.email) && (tempBuyer.getPassWord().equals(buyer.getPassWord()))) {
				return tempBuyer.shc.changeItemOrderedQuantity(order.getItem().getId(),newQuant);
			}
		}
		return null;
	}

	@SuppressWarnings("null")
	@Override
	public double calculateNet(Buyer buyer) {
		List<Buyer> buyersList = new ArrayList<Buyer>();
		buyersList = userService.getBuyers();
		for(Buyer tempBuyer : buyersList) {
			if(tempBuyer.email.equals(buyer.email) && (tempBuyer.getPassWord().equals(buyer.getPassWord()))) {
				return tempBuyer.shc.calculateNet();
				
			}
		}
		return (Double) null;
	}
		
		
		
	

	@Override
	public double calculateCost(Buyer buyer) {
		List<Buyer> buyersList = new ArrayList<Buyer>();
		buyersList = userService.getBuyers();
		for(Buyer tempBuyer : buyersList) {
			if(tempBuyer.email.equals(buyer.email) && (tempBuyer.getPassWord().equals(buyer.getPassWord()))) {
				return tempBuyer.shc.calculateCost();
				
			}
		}
		return (Double) null;
	}

	@Override
	public double calculateCourier(Buyer buyer) {
		List<Buyer> buyersList = new ArrayList<Buyer>();
		buyersList = userService.getBuyers();
		for(Buyer tempBuyer : buyersList) {
			if(tempBuyer.email.equals(buyer.email) && (tempBuyer.getPassWord().equals(buyer.getPassWord()))) {
				return tempBuyer.shc.calculateCourierCost();
				
			}
		}
		return (Double) null;
	}


	@Override
	public Buyer createBuyer(String name, String password, String email) {
		Buyer buyer = new Buyer(name,email,password);
		buyersList.add(buyer);
		
		
		
		return buyer;
	}
	

}
