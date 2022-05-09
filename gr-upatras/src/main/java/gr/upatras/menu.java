package gr.upatras;
import java.util.*;

public class menu {
	private static User loggedUser;
    private static Eshop eshop;
    
    public static void initEshop(final Eshop eshop) {
    	menu.eshop = eshop;
    }
    
    public static void login() throws BuyerEx, NoBuyerEx{
    	final boolean logged = false;
    	do {
    		System.out.println("Please type your email to enter the application");
    		final Scanner scanner = new Scanner(System.in);
    		final String email = scanner.nextLine();
    		scanner.close();
    		
    		for(final Buyer buyer : menu.eshop.getBuyerList()) {
    			if(buyer.getEmail() == email) {
    				menu.loggedUser =(User) buyer;
    				
    				return ;
    			}
    		}
    		System.out.println("There is not a user with this email, would you like to register? Y/N");
    		final String answer = scanner.nextLine();
    		if (answer.equalsIgnoreCase("y")) {
    			try {
                menu.loggedUser = (User)registerUser();
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
	
	public static void displayUserMenu() {
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

	
	 private static void actionAccordingToSelectionForBuyer(final int choice){
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
	                System.out.println("\u039a\u03b1\u03bb\u03ae \u03a3\u03c5\u03bd\u03ad\u03c7\u03b5\u03b9\u03b1 :)");
	                break;
	            }
	        }
	    }
	
	 private static void actionAccordingToSelectionForOwner(final int choice){
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
	                System.out.println(" :)");
	                break;
	            }
	        }
	    }
	
}
