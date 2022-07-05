package gr.upatras.JavaEshop.Controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.upatras.JavaEshop.Buyer;
import gr.upatras.JavaEshop.Item;
import gr.upatras.JavaEshop.ItemOrdered;
import gr.upatras.JavaEshop.MyUser;
import gr.upatras.JavaEshop.ShoppingCart;
import gr.upatras.JavaEshop.IServices.IBuyerService;
import gr.upatras.JavaEshop.IServices.IItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BuyerController {
	@Autowired
	private IBuyerService buyerService;
	@Autowired
	private IItemService itemService;
	
	@ApiOperation(value="Returns all the Buyers from the Eshop",
			notes="This operation retrieves all the buyers",
			response = Buyer.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Buyer.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/buyer/all" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public List<Buyer> getAll(){
		List<Buyer> buyers = buyerService.getAll();
		return buyers;
	}
	
	
	
	
	@ApiOperation(value="Adds a buyer to the shop",
			notes="This operation registers a Buyer to the eshop",
			response = Buyer.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Buyer.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/Buyer/add/{name}/{password}/{email}" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.POST)
	public Buyer createBuyer(@ApiParam(value = "The name", required = true) @PathVariable("name") String name,
			@ApiParam(value = "The Email", required = true) @PathVariable("email") String email,
			@ApiParam(value = "The password", required = true) @PathVariable("password") String password
			){
		Buyer tempbuyer = buyerService.createBuyer(name,password,email);
		return tempbuyer;
	}
	
	@ApiOperation(value="Returns the Shopping cart of the buyer",
			notes="Returns the Shopping cart of the buyer",
			response = ShoppingCart.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ShoppingCart.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/buyer/shc/getAll" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.POST)
	public ShoppingCart getEshoppingCart(@ApiParam(value = "A Buyer Class Object", required = true) @RequestBody Buyer buyer){
		ShoppingCart shc = buyerService.getShpc(buyer);
		return shc;
	}
	
	
	@ApiOperation(value="Adds an Item the Shopping cart of a buyer",
			notes="Adds an Item to the Shopping cart of a buyer",
			response = ItemOrdered.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ItemOrdered.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/buyer/shc/{qt}/{id}" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.POST)
	public ItemOrdered AddItemEshoppingCart(
			@ApiParam(value = "A Buyer Class Object", required = true) @RequestBody Buyer buyer,
			@ApiParam(value = "A Item Class Object", required = true) @PathVariable("id") int id,
			@ApiParam(value = "The quantity of the order", required = true) @PathVariable("qt") int qt)
	{	
		Item temp = itemService.findById(id);
		ItemOrdered order = buyerService.addItemToSpc(temp,qt,buyer);
		return order;
	}
	
	
	@ApiOperation(value="Deletes an Item from the Shopping cart of a buyer",
			notes="Deletes an Item from the Shopping cart of a buyer",
			response = ItemOrdered.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ItemOrdered.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/buyer/shc" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.DELETE)
	public ItemOrdered deleteItemEshoppingCart(
			@ApiParam(value = "A Buyer Class Object", required = true) @RequestBody Buyer buyer,
			@ApiParam(value = "A ItemOrdered Class Object", required = true) @RequestBody ItemOrdered item)
			
	{		
		ItemOrdered order = buyerService.deleteOrder(buyer,item);
		return order;
	}
	
	
	@ApiOperation(value="Changes the quantity an order in the Shopping cart of a buyer",
			notes="Changes the quantity an order in the Shopping cart of a buyer",
			response = ItemOrdered.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ItemOrdered.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/buyer/shc" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.PATCH)
	public ItemOrdered changeQtItem(
			@ApiParam(value = "A Buyer Class Object", required = true) @RequestBody Buyer buyer,
			@ApiParam(value = "A ItemOrdered Class Object", required = true) @PathVariable int id,
			@ApiParam(value = "A Buyer Class Object", required = true) @PathVariable("qt") int qt)
			
	{		
		Item temp = itemService.findById(id);
		ItemOrdered item = new ItemOrdered(temp,qt);
		ItemOrdered order = buyerService.changeQuantity(buyer,item,qt);
		return order;
	}
	
	@ApiOperation(value="Returns the Net Cost of a Buyer's shoppingCart",
			notes="Returns the Net Cost of a Buyer's shoppingCart",
			response = double.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = double.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/buyer/shc/net" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public double calculateNet(
			@ApiParam(value = "A Buyer Class Object", required = true) @RequestBody Buyer buyer)
			
			
	{		
		return buyerService.calculateNet(buyer);
		
	}
	
	@ApiOperation(value="Returns the  Cost of a Buyer's shoppingCart",
			notes="Returns the  Cost of a Buyer's shoppingCart",
			response = double.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = double.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/buyer/shc/cost" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public double calculateCost(
			@ApiParam(value = "A Buyer Class Object", required = true) @RequestBody Buyer buyer)
			
			
	{		
		return buyerService.calculateCost(buyer);
		
	}
	
	@ApiOperation(value="Returns the Courier  Cost of a Buyer's shoppingCart",
			notes="Returns the  Cost of a Buyer's shoppingCart",
			response = double.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = double.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/buyer/shc/courier" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public double calculateCourier(
			@ApiParam(value = "A Buyer Class Object", required = true) @RequestBody Buyer buyer)
			
			
	{		
		return buyerService.calculateCourier(buyer);
		
	}
	
	
	
	

}
