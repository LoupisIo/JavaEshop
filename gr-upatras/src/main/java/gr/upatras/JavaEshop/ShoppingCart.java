/**
 * 
 */
package gr.upatras.JavaEshop;
import java.util.*;

import gr.upatras.JavaEshop.IServices.IItemService;

/**
 * @author loupis.io
 *
 */

public class ShoppingCart {
	
	public static ArrayList<ItemOrdered> orderList = new ArrayList<ItemOrdered>();
	private IItemService itemService;
	private Buyer buyer;
	
	
	
	public ShoppingCart(Buyer buyer) {
        this.buyer=buyer;
    }
	public ShoppingCart() {
  
    }
	
	public boolean cartIsEmpty() {
		 
	        if(orderList.isEmpty()){
	            return true;
	        }else{
	            return false;
	        }
	        
	}
	
	public List<ItemOrdered> getAll(){
		return orderList;
	}
	
	public ItemOrdered addItemOrdered(Item item, int quantity) {
		
		for(Item x :itemService.returnAll()) {
			if(x.getId()==item.getId()) {
				//Check if there is enough stock
				if(quantity>x.getStock()) {
					
					return null;
				}else{
				//Check if the item already exists in the ShoppingCart
					for(ItemOrdered order:orderList) {
						if(order.getItem().getId()==item.getId()) {
							order.setQuantity(order.getQuantity()+quantity);
							itemService.setStock(item.id,item.getStock()- quantity);
							
							return order;
						}
					}
					
					//Add the item in the shopping Cart.
					ItemOrdered newOrder = new ItemOrdered(item,quantity);
					orderList.add(newOrder);
					itemService.setStock(item.getId(),item.getStock()-quantity);
					
					return newOrder;
					
				}	
			}
		}
		return null;
	}
	
	
	
	public boolean removeItemOrdered(int iOrd){
       
        for(ItemOrdered b:orderList) {
            if (b.getItem().getId() ==iOrd) {
                b.getItemOrd().setStock(b.getItemOrd().getStock() + b.quantity);
                orderList.remove(b);
                return true;
            }
        }
        return false;
    }
	
	public ItemOrdered changeItemOrderedQuantity(int id, int quantity){
	
        for(ItemOrdered b:orderList) {
            if (b.getItem().getId() ==id) {
            	for (Item item: itemService.returnAll()) {
            		if(item.getId()==id) {
            			itemService.setStock(id, item.getStock()+quantity);
            			b.setQuantity(quantity);
            		}
            	}
            	return null;
            }
        }
        return null;		
	}

	public void showCart() {
		for(ItemOrdered order:orderList){
            String Temp= String.format("%.2f",order.quantity*order.item.getPrice());
            System.out.println(order.item.getName() +" Quantity: "+ order.quantity +" Price: "+ Temp +" €");
        }
        System.out.println("Transit costs: "+ calculateCourierCost() +" €"+"\n");
        String Temp= String.format("%.2f",calculateNet());
        System.out.println("Final Cost:"+ Temp+" €");
	}

	public void clearCart(){
		//Clears the shopping Cart
        orderList.clear();
    }

	public void checkOut() {
		System.out.println("Do you wish to procced to checkout?  Y/N");
		final Scanner scanner = new Scanner(System.in);
		final String answer = scanner.nextLine();
				if (answer=="N") {
			return ;
		}else if(answer=="Y") {
			buyer.setBonus(calculateCost() * 0.1);
			clearCart();
			return;
			
		}else {
			checkOut();
		}
		
		
	}
	
    public  double calculateNet(){
        //Calculates the final cost
        double totalCost =calculateCost()+calculateCourierCost();
        return totalCost;
    }
    
    public  double calculateCost(){
        //Calculates the cost of the products
        double cost=0;
        for(ItemOrdered order:orderList){
            cost= cost + ((order.quantity)*(order.item.getPrice()));
        }
        return cost;
    }

    public  double calculateCourierCost(){
        //Calculates the shipping Cost
        double totalPrice= calculateCost();
        
        totalPrice=totalPrice*0.05;
        if(buyer.getBuyerCategory()== "GOLD"){
            totalPrice=0;
        }else if(buyer.getBuyerCategory()=="SILVER"){
            totalPrice=totalPrice/2;
        }else {
            if (totalPrice<3){

                totalPrice=3;
            }
        }
        return totalPrice;
    }
}
