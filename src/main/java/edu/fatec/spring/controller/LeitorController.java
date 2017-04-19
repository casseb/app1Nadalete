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

import edu.fatec.spring.model.Leitor;
import edu.fatec.spring.model.Livro;
import edu.fatec.spring.repositories.LeitorRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/leitor")
@Transactional
public class LeitorController {
	@Autowired
	LeitorRepository leitorRepository;

	@ApiOperation(value = "Query all Readers stored in database", response = Leitor.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list") })
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Leitor>> getAll() {
		return new ResponseEntity<Iterable<Leitor>>(leitorRepository.findAll(), HttpStatus.OK);
	}

	@ApiOperation(value = "Get one Reader base on your ID", response = Livro.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully retrieved list"),
			@ApiResponse(code = 404, message = "The resource was not found") })
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Leitor> getReader(@PathVariable Long id) {
		Leitor leitor = leitorRepository.findById(id);
		return (leitor != null) ? new ResponseEntity<Leitor>(leitor, HttpStatus.CREATED)
				: new ResponseEntity<Leitor>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(value = "Remove one Reader base on your ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Reader deleted with success"),
			@ApiResponse(code = 406, message = "Fail to delete the reader") })
	@DeleteMapping(value = "/remove/{id}")
	public ResponseEntity<Void> deleteReader(@PathVariable Long id) {
		try {
			leitorRepository.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}

	}
}
