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
import gr.upatras.JavaEshop.Pen;
import gr.upatras.JavaEshop.IServices.IItemService;
import gr.upatras.JavaEshop.IServices.IPenService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class PenController {
	@Autowired
	private IPenService penService;
	private static final Logger log = LoggerFactory.getLogger(PenController.class);
	
	@ApiOperation(value="Adds an Pen Item to the shop",
			notes="This operation adds an Pen Item Object to the shop",
			response = Pen.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Pen.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/pen" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.POST)
	public ResponseEntity<Pen> addPen(@ApiParam(value = "The Pen Object to be patched", required = true) @RequestBody Pen pen) {
		log.info( "Adding New Pen Item to the shop" );
		Pen item = penService.addPen(pen);
		return new ResponseEntity<Pen>( item, HttpStatus.OK);
	}
	
	@ApiOperation(value="Patches an Pen Item from the shop",
			notes="This operation patches an Pen Item Object from the shop",
			response = Pen.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Pen.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/pen" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.PATCH)
	public ResponseEntity<Pen> editPen(@ApiParam(value = "The Pen Object to be Patched", required = true) @RequestBody Pen pen) {
		log.info( "Patching a Pen Item" );
		Pen item = penService.editPen(pen);
		return new ResponseEntity<Pen>( item, HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Returns a List of Pen matching the colour",
			notes="This operation returns a List of Pen object that match the given colour",
			response = Pen.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Pen.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/pen/colourSearch/{colour}" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public List<Pen> findByColour(@ApiParam(value = "The search param colour search param", required = true) @PathVariable("colour") String colour) {
		log.info( "Find by colour" );
		log.info(colour);
		List<Pen> penList = penService.findByColour(colour);
		return penList;
	}
	
	@ApiOperation(value="Returns a List of Pen matching the tipSize",
			notes="This operation returns a List of Pen object that match the given tipSize",
			response = Pen.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Pen.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/pen/tipSizeSearch/{tipSize}" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public List<Pen> findByTipSize(@ApiParam(value = "The search param tip-Size search param", required = true) @PathVariable("tipSize") double tipSize) {
		log.info( "Find by tip-size" );
		log.info("tipSize: %s",tipSize);
		List<Pen> penList = penService.findByTipSize(tipSize);
		return penList;
	}
	
	
	
}
