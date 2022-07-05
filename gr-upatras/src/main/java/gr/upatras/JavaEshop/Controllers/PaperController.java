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
import gr.upatras.JavaEshop.Paper;
import gr.upatras.JavaEshop.IServices.IItemService;
import gr.upatras.JavaEshop.IServices.IPaperService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class PaperController {
	@Autowired
	private IPaperService paperService;
	private static final Logger log = LoggerFactory.getLogger(PaperController.class);
	
	@ApiOperation(value="Adds an Paper Item to the shop",
			notes="This operation adds an Paper Item Object to the shop",
			response = Paper.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Paper.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/paper" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.POST)
	public ResponseEntity<Paper> addPaper(@ApiParam(value = "The Paper Object to be patched", required = true) @RequestBody Paper paper) {
		log.info( "Adding New Paper Item to the shop" );
		Paper item = paperService.addPaper(paper);
		return new ResponseEntity<Paper>( item, HttpStatus.OK);
	}
	
	@ApiOperation(value="Patches an Paper Item from the shop",
			notes="This operation patches an Paper Item Object from the shop",
			response = Paper.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Paper.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/paper" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.PATCH)
	public ResponseEntity<Paper> editPaper(@ApiParam(value = "The Paper Object to be Patched", required = true) @RequestBody Paper paper) {
		log.info( "Patching a Paper Item" );
		Paper item = paperService.editPaper(paper);
		return new ResponseEntity<Paper>( item, HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Returns a List of Paper matching the weight",
			notes="This operation returns a List of Paper object that match the given weight",
			response = Paper.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Paper.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/paper/weightSearch/{weight}" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public List<Paper> findByWeight(@ApiParam(value = "The search param weight search param", required = true) @PathVariable("weight") int weight) {
		log.info( "Find by weight" );
		
		List<Paper> paperList = paperService.findByWeight(weight);
		return paperList;
	}
	
	@ApiOperation(value="Returns a List of Paper matching the pageNum",
			notes="This operation returns a List of Paper object that match the given pageNum",
			response = Paper.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Paper.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/paper/pageNumSearch/{pageNum}" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public List<Paper> findByPageNum(@ApiParam(value = "The search param page-Num search param", required = true) @PathVariable("pageNum") int pageNum) {
		log.info( "Find by tip-size" );
		log.info("pageNum: %s",pageNum);
		List<Paper> paperList = paperService.findByPageNum(pageNum);
		return paperList;
	}
	
	
	@ApiOperation(value="Returns a List of all the Papers ",
			notes="This operation returns a List of all the Paper objects",
			response = Paper.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Paper.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/paper/pageNumSearch/{pageNum}" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public List<Item> getAll() {
		List<Item> paperList = paperService.getAll();
		return paperList;
	}
	
	
	
	
	
}
