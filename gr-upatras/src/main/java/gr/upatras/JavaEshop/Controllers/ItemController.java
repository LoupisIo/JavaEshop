package gr.upatras.JavaEshop.Controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.upatras.JavaEshop.Item;
import gr.upatras.JavaEshop.IServices.IItemService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class ItemController {
	@Autowired
	private IItemService itemService;
	private static final Logger log = LoggerFactory.getLogger(ItemController.class);
	
	
	@ApiOperation(value="Returns all the Items",
			notes="This operation retrieves all Item objects",
			response = Item.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Item.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/item" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public List<Item> getItem(){
		List<Item> items = itemService.returnAll();
		return items;
	}
	
	@ApiOperation(value="Adds an Item to the shop",
			notes="This operation adds an Item Object to the shop",
			response = Item.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Item.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/item" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.POST)
	public ResponseEntity<Item> createItem(@ApiParam(value = "The Item Object to be added", required = true) @RequestBody Item i) {
		log.info( "Adding New Item to the shop" );
		Item item = itemService.addItem(i);
		return new ResponseEntity<Item>( item, HttpStatus.OK);
	}
	

	@ApiOperation(value="Returns an Item from the shop",
			notes="This operation returns an Item Object from the shop according to the id",
			response = Item.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Item.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/item/{id}" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public ResponseEntity<Item> findItem(@ApiParam(value = "The Item Object to be added", required = true) @PathVariable("id") int id) {
		Item item = itemService.findById(id);
		return new ResponseEntity<Item>( item, HttpStatus.OK);
	}
	
	

	@ApiOperation(value="Deletes an Item form the shop",
			notes="This operation deletes an item from the shop")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success" ),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 406, message = "Not Acceptable", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/item/{id}" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.DELETE)
	public ResponseEntity<Void> removeItem(@ApiParam(value = "The id of the Item to be deleted", required = true) @PathVariable("id") int id) {
		Item toDelete = itemService.findById(id);
		if(toDelete != null) {
			itemService.removeItem(toDelete);
			return new ResponseEntity<Void>(HttpStatus.OK);	
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	
	@ApiOperation(value="Updates the Stock of an Item",
			notes="This operation replases the stock of an item with the given number")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success" ),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 406, message = "Not Acceptable", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/item/{id}/{number}" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.PATCH)
	public ResponseEntity<Item> setStock(@ApiParam(value = "The id of the Item to be deleted", required = true) @PathVariable("id") int id,
			@ApiParam(value = "The new stock number for the item", required = true)@PathVariable("number")int number) {
		Item item = itemService.setStock(id,number);
		if(item != null) {
			return new ResponseEntity<Item>(item,HttpStatus.OK);	
		}
		return new ResponseEntity<Item>(item,HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	

}
