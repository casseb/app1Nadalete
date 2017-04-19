package edu.fatec.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.fatec.spring.model.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {
	Livro findById(Long id);
	List<Livro> findAll();
}
