/**
 * 
 */
package gr.upatras.JavaEshop;
import java.util.*;

/**
 * @author loupis.io
 *
 */
public class Eshop {
	
	public Owner owner;
	public String StoreName;
    public String ownersName ;
    public static ArrayList<Buyer> buyersList = new ArrayList<Buyer>();
    public static ArrayList<Item> itemsList = new ArrayList<Item>();
    public String[] productCategories = {"Pen","Pencil","Notebook","Paper"};
    
    public Eshop(String nameOwner, String emailOwner, String soname){
        this.owner= new Owner(nameOwner,emailOwner);
        this.ownersName=nameOwner;
        this.StoreName= soname;
    }
    
    
    
    public ArrayList<Buyer> getBuyerList() {
        return buyersList;
    }
    
    public void addItem(Item newitem) throws ItemEx{
        for(Item item: itemsList){
            if(item==newitem){
                throw new ItemEx();
            }
        }
        itemsList.add(newitem);
    }
    
    public Item getItemById(int id)throws NoItemEx {
        Boolean flag=true;
        Item result = null;
        for(Item x: itemsList){
            if(x.getId()==id){
                result= x;
                flag=false;
            }
        }
        if(flag==true){
        	throw new NoItemEx();
        }
        else {
            return result;
        }
    }
    
    public void deleteitem(int id) throws NoItemEx{
    	Boolean flag = false;
    	for(Item x:itemsList) {
    		if(x.getId()==id) {
    			itemsList.remove(x);
    			flag = true;
    			break;
    		}
    		if(!flag) {
    			throw new NoItemEx();	
    		}	
    	}
    }
	
    public void addBuyer(Buyer newBuyer) throws BuyerEx {
    	System.out.println("Adding a user");
    	for (Buyer x: buyersList) {
    		if (x==newBuyer) {
    			System.out.println("Before I throw an");
    			throw new BuyerEx();
    		}
    		
    		
    	}
    	buyersList.add(newBuyer);
    	
    }
    
    public void deleteBuyer(Buyer a) throws NoBuyerEx{
    	Boolean flag = false;
    	for(Buyer x:buyersList) {
    		if(x==a) {
    			buyersList.remove(x);
    			flag = true;
    			break;
    		}
    		if(!flag) {
    			throw new NoBuyerEx();	
    		}	
    	}
    }
    
    static void updateStock(int id, int stockChange) {
    	for(Item item: itemsList) {
    		if(id== item.getId()) {
    			item.setStock(item.getStock() + stockChange);
    		}
    	}
    }
    
    public void showCategories() {

        //HashMap<String, Integer> itemsCategories = new HashMap<String, Integer>();

        System.out.println("THE PRODUCT CATEGORIES ARE:");
        for (int i = 0; i < productCategories.length; i++) {
            int temp = 0;
            for (Item b : itemsList) {
                if (b.getCategory().equals(productCategories[i])) {
                    temp++;
                }
            }
            System.out.println((i + 1) + "." + productCategories[i] + " (" + temp + ")");
        }
    }
    
    public void showProductperCategory(String category) {
    	System.out.println("The products in the "+category+" category are:");
    	for(Item item :itemsList) {
    		if (item.getCategory()== category) {
    			System.out.println(item.getFullDetails());
    		}
    	}
    }
    

    
    public void showProduct(Item product) {
    	for(Item item :itemsList) {
    		if(item.getId()==product.getId()) {
    			System.out.println(item.getFullDetails());
    		}
    	}
    }
    
    public void checkStatus() {
    	int i=0;
    	for (Buyer buyer :buyersList) {
    		i=i+1;
    		System.out.println("["+i+"] "+buyer.getName()+" | "+buyer.getEmail()+" | "+buyer.getBonus()+" | "+buyer.getBuyerCategory());
    	}
    }
    
    public void removeBuyer(Buyer buyer) {
    	buyersList.remove(buyer);
    	System.out.println("The User "+buyer.getName()+" was deleted");
    }
}
