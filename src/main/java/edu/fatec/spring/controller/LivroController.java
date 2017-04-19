package edu.fatec.spring.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fatec.spring.model.Livro;
import edu.fatec.spring.repositories.LivroRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/livro")
@Transactional
public class LivroController {
	@Autowired
	LivroRepository livroRepository;

	@ApiOperation(value = "Query all books stored in database", response = Livro.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list") })
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Livro>> getAll() {
		return new ResponseEntity<Iterable<Livro>>(livroRepository.findAll(), HttpStatus.OK);
	}

	@ApiOperation(value = "Get one Book base on your ID", response = Livro.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully retrieved list"),
			@ApiResponse(code = 404, message = "The resource was not found") })
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livro> getBook(@PathVariable Long id) {
		Livro livro = livroRepository.findById(id);
		return (livro != null) ? new ResponseEntity<Livro>(livro, HttpStatus.CREATED)
				: new ResponseEntity<Livro>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(value = "Remove one Book base on your ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Book deleted with success"),
			@ApiResponse(code = 406, message = "Fail to delete the book") })
	@DeleteMapping(value = "/remove/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		try {
			livroRepository.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}

	}
}
