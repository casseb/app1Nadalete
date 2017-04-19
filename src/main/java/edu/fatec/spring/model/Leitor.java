package edu.fatec.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@Entity
@Table(name = "leitor")
@AllArgsConstructor
@NoArgsConstructor
public class Leitor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_leitor")
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private String email;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@OneToMany(mappedBy = "leitor", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Historico> historico;
}
