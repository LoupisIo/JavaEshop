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
import gr.upatras.JavaEshop.Pencil;
import gr.upatras.JavaEshop.IServices.IItemService;
import gr.upatras.JavaEshop.IServices.IPencilService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class PencilController {
	@Autowired
	private IPencilService pencilService;
	private static final Logger log = LoggerFactory.getLogger(PencilController.class);
	
	@ApiOperation(value="Adds an Pencil Item to the shop",
			notes="This operation adds an Pencil Item Object to the shop",
			response = Pencil.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Pencil.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/pencil" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.POST)
	public ResponseEntity<Pencil> addPencil(@ApiParam(value = "The Pencil Object to be patched", required = true) @RequestBody Pencil pencil) {
		log.info( "Adding New Pencil Item to the shop" );
		Pencil item = pencilService.addPencil(pencil);
		return new ResponseEntity<Pencil>( item, HttpStatus.OK);
	}
	
	@ApiOperation(value="Patches an Pencil Item from the shop",
			notes="This operation patches an Pencil Item Object from the shop",
			response = Pencil.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Pencil.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/pencil" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.PATCH)
	public ResponseEntity<Pencil> editPencil(@ApiParam(value = "The Pencil Object to be Patched", required = true) @RequestBody Pencil pencil) {
		log.info( "Patching a Pencil Item" );
		Pencil item = pencilService.editPencil(pencil);
		return new ResponseEntity<Pencil>( item, HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Returns a List of Pencil matching the type",
			notes="This operation returns a List of Pencil objects that match the given type",
			response = Pencil.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Pencil.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/pencil/typeSearch/{type}" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public List<Pencil> findByType(@ApiParam(value = "The search param type search param", required = true) @PathVariable("type") String type) {
		log.info( "Find by type" );
		log.info(type);
		List<Pencil> pencilList = pencilService.findByType(type);
		return pencilList;
	}
	
	@ApiOperation(value="Returns a List of Pencil matching the tipSize",
			notes="This operation returns a List of Pencil object that match the given tipSize",
			response = Pencil.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Pencil.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/pencil/tipSizeSearch/{tipSize}" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public List<Pencil> findByTipSize(@ApiParam(value = "The search param tip-Size search param", required = true) @PathVariable("tipSize") double tipSize) {
		log.info( "Find by tip-size" );
		log.info("tipSize: %s",tipSize);
		List<Pencil> pencilList = pencilService.findByTipSize(tipSize);
		return pencilList;
	}
	
	
	
}
