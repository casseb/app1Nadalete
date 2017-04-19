package edu.fatec.spring.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Embeddable
@Data
@SuppressWarnings("serial")
@NoArgsConstructor
public class HistoricoPK implements Serializable {
	@NonNull
	@Column(name = "id_livro")
	private Long idLivro;
	@NonNull
	@Column(name = "id_leitor")
	private Long idLeitor;
}