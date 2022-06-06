package gr.upatras;
import java.util.*;

public class menu {
	
	
public static User loggedUser;
public static Eshop eshop;
    
    public static void initEshop(final Eshop eshop) {
    	menu.eshop = eshop;
    }
    
    
    public static void login() throws BuyerEx, NoBuyerEx, NoItemEx{
    	final boolean logged = false;
    	do {
    		System.out.println("Please type your email to enter the application");
    		final Scanner scanner = new Scanner(System.in);
    		final String email = scanner.nextLine();
    		
    		final ArrayList<Buyer> buyersList = menu.eshop.getBuyerList();
    		if(eshop.owner.getEmail().equalsIgnoreCase(email)){
    			menu.loggedUser = eshop.owner;
    			displayUserMenu();
    			
    			
    		}
    		
    		for(final Buyer buyer : buyersList) {
    			if(buyer.getEmail().equals(email)) {
    				menu.loggedUser =(User) buyer;
    				displayUserMenu();
    				
    			}
    		}
    		System.out.println("There is not a user with this email, would you like to register? Y/N");
    		final String answer = scanner.nextLine();
    		if (answer.equalsIgnoreCase("y")) {
    			try {
                menu.loggedUser = (User)registerUser();
                displayUserMenu();
                
    			}
    			catch(BuyerEx ex) {
    				System.out.println(ex.ExceptionMessage());
    			}
                
                return ;
            }
    	}while(!logged);
    }
    
    
	private static Buyer registerUser() throws BuyerEx{
		
		final Scanner scanner = new Scanner(System.in);
		Buyer newbuyer = null;
		boolean exists;
		do {
			System.out.println("Give your name:");
			final String name = scanner.nextLine();
			System.out.println("Give your email:");
			final String mailString = scanner.nextLine();
			try {
				newbuyer = new Buyer(name,mailString);
				eshop.addBuyer(newbuyer);	
				exists = false;
			}catch(BuyerEx ex) {
				exists = true;
				System.out.println(ex.ExceptionMessage());	
			}
		}while(exists);
		return newbuyer;
	}
	
	public static void displayUserMenu() throws BuyerEx, NoBuyerEx, NoItemEx {
		int choice;
		final Scanner scanner = new Scanner(System.in);
		do {
			if(menu.loggedUser instanceof Buyer) {
				System.out.println("Hello "+ menu.loggedUser.getName());
				System.out.println("Your Bonus points are: "+((Buyer) menu.loggedUser).getBonus()+" and your level: "+((Buyer) menu.loggedUser).getBuyerCategory());
				System.out.println("Choose one of the following actions by typing the coresponding number \n");
				System.out.println("(1)... Browse Store");
				System.out.println("(2)... View Cart");
				System.out.println("(3)... CheckOut");
				System.out.println("(4)... Got Back");
				System.out.println("(5)... Log Out");
				System.out.println("(6)... Exit");
				choice = scanner.nextInt();
				actionAccordingToSelectionForBuyer(choice);
					
			}else {
				System.out.println("Hello Owner "+ menu.loggedUser.getName());
				System.out.println("Choose one of the following actions by typing the coresponding number \n");
				System.out.println("(1)... Browse Store");
				System.out.println("(2)... Check Buyer's Status");
				System.out.println("(3)... Go back");
				System.out.println("(4)... Log Out");
				System.out.println("(5)... Exit");
				choice = scanner.nextInt();
				actionAccordingToSelectionForOwner(choice);
			}
			
		}while((menu.loggedUser instanceof Buyer && choice != 6) || (menu.loggedUser instanceof Owner && choice != 5));
	}

	private static void browseStoreOwner() throws NoItemEx {
		Item product = null;
		System.out.println(menu.eshop.StoreName);
		System.out.println("The product categories are:");
		menu.eshop.showCategories();
		System.out.println("Please choose one to continue");
		int choice = getUserChoice();
		menu.eshop.showProductperCategory(menu.eshop.productCategories[choice -1]);
		System.out.println("Please choose a product by entering its ID to continue");
		choice = getUserChoice();
		product = menu.eshop.getItemById(choice);
		menu.eshop.showProduct(product);
		System.out.println("Would you like to change the stock of the product; (Y/N)");
		Scanner scanner =new Scanner(System.in);
		String answer = scanner.next();
		if(answer.equalsIgnoreCase("y")) {
			System.out.println("Please enter the new stock value");
			choice = getUserChoice();
			menu.eshop.updateStock(product.getId(),product.getStock()- choice);
			System.out.println("The stock has been updated");
		}	
	}
	
	private static void clients() {
		menu.eshop.checkStatus();
		System.out.println("Choose a User to continue");
		final int choice = getUserChoice();
		final Buyer buyer = menu.eshop.getBuyerList().get(choice -1);
		buyer.shc.showCart();
		Scanner scanner =new Scanner(System.in);
		System.out.println("Would you like to delete this user? (Y/N");
		String answer = scanner.next();
		if(answer.equalsIgnoreCase("y")) {
			buyer.shc.clearCart();
			menu.eshop.removeBuyer(buyer);
			
		} 
	}	
	
	
	
	private static void actionAccordingToSelectionForBuyer(final int choice) throws BuyerEx, NoBuyerEx, NoItemEx{
	        switch (choice) {
	            case 1: {
	            	browseStore();
	            	break;
	            }
	            case 2: {
	                viewCart();
	                break;
	            }
	            case 3: {
	                final Buyer buyer = (Buyer)menu.loggedUser;
	                buyer.shc.checkOut();
	                break;
	            }
	            case 4: {
	                login();
	                displayUserMenu();
	                break;
	            }
	            case 5: {
	            	System.exit(0);
	            }
	        }
	    }
	
	
	
	private static void actionAccordingToSelectionForOwner(final int choice) throws BuyerEx, NoBuyerEx, NoItemEx{
	        switch (choice) {
	            case 1: {
	                browseStoreOwner();
	                break;
	            }
	            case 2: {
	                clients();
	                break;
	            }
	            case 3: {
	                login();
	                displayUserMenu();
	                break;
	            }
	            case 4: {
	            	System.exit(0);
	            }
	        }
	    }
	 
	 
	 public static void browseStore() {
		 Item product = null;
		 
		 
		 
		 do {
			 
			 System.out.println(menu.eshop.StoreName);
			 System.out.println("Choose an item category:");
			 menu.eshop.showCategories();
			 final int choice = getUserChoice();
			 menu.eshop.showProductperCategory(menu.eshop.productCategories[choice -1]);
			 System.out.println("Choose the id of an item to add to your shoping cart:");
			 final int id = getUserChoice();
			 
			 try {
				 product = menu.eshop.getItemById(id);
			 }catch(NoItemEx error) {
				 System.out.println(error.ExceptionMessage());
			 }
			 
		 }while(product == null);
		 
		 menu.eshop.showProduct(product);
		 System.out.println("Do you wish to add this item in your shopping cart?");
		 Scanner read = new Scanner(System.in);
		 final String choice = read.nextLine();
		 if(choice.equalsIgnoreCase("y")) {
			 System.out.println("Input the quantity you want:");
			 final int quantity = getUserChoice();
			 final Buyer buyer = (Buyer)menu.loggedUser;
			 buyer.placeOrder(product, quantity);
			 
			 System.out.printf("The item %s is in your Shopping Cart\n",product.getName());
			 
		 }
		 
		 
		 
		 
	 }
	 
	 
	 private static int getUserChoice() {
		 final Scanner read = new Scanner(System.in);
		 final int num = read.nextInt();
		 
		 return num;
		 
	 }
	 
	 
	 private static void viewCart() {
		 final Buyer buyer = (Buyer)menu.loggedUser;
		 buyer.shc.showCart();
		 if(!buyer.shc.cartIsEmpty()) {
			 System.out.println("(Would ypu like to:");
			 System.out.println("(1)...Change an order");
			 System.out.println("(2)...Clear your cart");
			 System.out.println("(3)...Check Out");
			 final int answer = getUserChoice();
			 switch (answer) {
			 case 1:{
				 System.out.println("PLease input the order number to continue");
				 final int orderNum = getUserChoice();
				 System.out.println("Would you like to:");
				 System.out.println("(1)...Remove the item from the shopping cart");
				 System.out.println("(2)...Change the quantity of the order");
				 final int choice = getUserChoice();
				 switch(choice) {
				 case 1:{
					 buyer.shc.removeItemOrdered(orderNum - 1);
					 System.out.println("The item has been removed from your shopping Cart");
					 break;
   
				 }
				 case 2:{
					 final Scanner scanner = new Scanner(System.in);
					 System.out.println("Please enter the new quantity");
					 final int quantity = scanner.nextInt();
                     buyer.shc.changeItemOrderedQuantity(orderNum - 1, quantity);
                     
                     break;
                     
				 }
				 }
				 
			 }
			 case 2:{
				 buyer.shc.clearCart();
				 System.out.println("Your cart has been cleared");
				 
				 
			 }
			 case 3: {
                 buyer.shc.checkOut();
                 break;
             }
			 }
		 }
	 }
	
}
