package gr.upatras;
import java.util.*;


public class main {
    public static Pencil Basicpencil = new Pencil(18, "Farbel-Castell Basic", "A basic Pencil for your everyday needs", 1.25 , 200,"HB",0.7);
    public static Pencil Premiumpencil = new Pencil(19, "Farbel-Castell Premium", "A premium Pencil for the expierienced user", 2.0 , 200,"HB",0.5);
    
    public static Pencil BasicpencilH = new Pencil(20, "Farbel-Castell Basic-H", "A basic Pencil for your everyday needs", 1.25 , 220,"H",0.7);
    public static Pencil PremiumpencilH = new Pencil(121, "Farbel-Castell Premium-H", "A premium Pencil for the expierienced user", 2.0 , 280,"H",0.5);
    
    
    
    public static Pen bluepen = new Pen(47, "Bic-Basic-blue", "Simple blue pen", 2.00, 144, "blue", 0.5);
    public static Pen redpen = new Pen(48, "Bic-Basic-red", "Simple red pen", 2.00, 158, "red", 0.5);
    public static Pen blackpen = new Pen(49, "Bic-Basic-black", "Simple black pen", 2.00, 280, "black", 0.5);
    
    
    public static NoteBook Biga4notebook= new NoteBook(23,"big-NoteBook-A4","Basic big NoteBook",2.5,150,5,250);
    public static NoteBook Smalla4notebook= new NoteBook(22,"NoteBook-A4","Basic small NoteBook",2.5,99,3,150);
    
    
    
    public static Eshop myShop = new Eshop("Vassilis Koutroglou", "vasilisvasil@gmail.com","vivliopoleio");
    
    
    


    @SuppressWarnings("static-access")
	public static void main(String[] args) throws NoBuyerEx, BuyerEx, NoItemEx {

        try {
        	Buyer Kostas = new Buyer("kostas", "mail@gmail.com");
        	myShop.addBuyer(Kostas);
        	
        	}
        catch (BuyerEx by) {
        	System.out.println(by.ExceptionMessage());
        }
        
        try {
        	Buyer Ioannis = new Buyer("Ioannis", "magikoskinezos@gmail.com");
        	myShop.addBuyer(Ioannis);
        }
        catch (BuyerEx by) {
        	System.out.println(by.ExceptionMessage());
        }
        
        try {
        	Buyer Nasos = new Buyer("Ahanasios", "Diakoss@gmail.gr");
        	myShop.addBuyer(Nasos);
        }
        catch (BuyerEx by) {
        	System.out.println(by.ExceptionMessage());
        }
        
        try {
        	Buyer Nick = new Buyer("Nick Koromposs", "nkorompos@gmail.com");
        	myShop.addBuyer(Nick);
        }
        catch (BuyerEx by) {
        	System.out.println(by.ExceptionMessage());
        	}
        
        try {
        	myShop.addItem(Basicpencil);
        }
        catch(ItemEx error) {
        	System.out.println(error.ExceptionMessage());
        }
        
        try {
            myShop.addItem(Premiumpencil);
        }
        catch(ItemEx error) {
            	System.out.println(error.ExceptionMessage());
        }
        
        try {
            myShop.addItem(BasicpencilH);
            }
        catch(ItemEx error) {
            	System.out.println(error.ExceptionMessage());
        }
        try {
            myShop.addItem(PremiumpencilH);
        }
        catch(ItemEx error) {
            	System.out.println(error.ExceptionMessage());
        }
        
        try {
            myShop.addItem(bluepen);
        }
        catch(ItemEx error) {
            	System.out.println(error.ExceptionMessage());
        }
        
        try {
            myShop.addItem(redpen);
        }
        catch(ItemEx error) {
            	System.out.println(error.ExceptionMessage());
        }
        
        try {
            myShop.addItem(blackpen);
        }
        catch(ItemEx error) {
            	System.out.println(error.ExceptionMessage());
        }
        
        
        try {
            myShop.addItem(Biga4notebook);
        }
        catch(ItemEx error) {
            	System.out.println(error.ExceptionMessage());
        }
        
        try {
            myShop.addItem(Smalla4notebook);
        }
        catch(ItemEx error) {
            	System.out.println(error.ExceptionMessage());
        }
        
        final menu Menu = new menu();
       
        Menu.initEshop(myShop);
        Menu.login();
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}