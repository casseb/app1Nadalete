package edu.fatec.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.fatec.spring.model.Leitor;

@Repository
public interface LeitorRepository extends CrudRepository<Leitor, Long> {
	Leitor findById(Long id);
	List<Leitor> findAll();
}
