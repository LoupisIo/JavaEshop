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
import gr.upatras.JavaEshop.NoteBook;
import gr.upatras.JavaEshop.IServices.IItemService;
import gr.upatras.JavaEshop.IServices.INoteBookService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class NoteBookController {
	@Autowired
	private INoteBookService noteBookService;
	private static final Logger log = LoggerFactory.getLogger(NoteBookController.class);
	
	@ApiOperation(value="Adds an NoteBook Item to the shop",
			notes="This operation adds an NoteBook Item Object to the shop",
			response = NoteBook.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = NoteBook.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/noteBook" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.POST)
	public ResponseEntity<NoteBook> addNoteBook(@ApiParam(value = "The NoteBook Object to be patched", required = true) @RequestBody NoteBook noteBook) {
		log.info( "Adding New NoteBook Item to the shop" );
		NoteBook item = noteBookService.addNoteBook(noteBook);
		return new ResponseEntity<NoteBook>( item, HttpStatus.OK);
	}
	
	@ApiOperation(value="Patches an NoteBook Item from the shop",
			notes="This operation patches an NoteBook Item Object from the shop",
			response = NoteBook.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = NoteBook.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/noteBook" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.PATCH)
	public ResponseEntity<NoteBook> editNoteBook(@ApiParam(value = "The NoteBook Object to be Patched", required = true) @RequestBody NoteBook noteBook) {
		log.info( "Patching a NoteBook Item" );
		NoteBook item = noteBookService.editNoteBook(noteBook);
		return new ResponseEntity<NoteBook>( item, HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Returns a List of NoteBook matching the sections",
			notes="This operation returns a List of NoteBook object that match the given sections",
			response = NoteBook.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = NoteBook.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/noteBook/sectionsSearch/{sections}" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public List<NoteBook> findBySections(@ApiParam(value = "The search param sections search param", required = true) @PathVariable("sections") int sections) {
		log.info( "Find by sections" );
		
		List<NoteBook> noteBookList = noteBookService.findBySections(sections);
		return noteBookList;
	}
	
	@ApiOperation(value="Returns a List of NoteBook matching the pageNum",
			notes="This operation returns a List of NoteBook object that match the given pageNum",
			response = NoteBook.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = NoteBook.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/noteBook/pageNumSearch/{pageNum}" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public List<NoteBook> findByPageNum(@ApiParam(value = "The search param page-Num search param", required = true) @PathVariable("pageNum") int pageNum) {
		log.info( "Find by tip-size" );
		log.info("pageNum: %s",pageNum);
		List<NoteBook> noteBookList = noteBookService.findByPageNum(pageNum);
		return noteBookList;
	}
	
	
	
}
