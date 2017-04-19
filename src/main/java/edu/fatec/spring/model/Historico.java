package edu.fatec.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.fatec.spring.model.pk.HistoricoPK;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@Entity
@Table(name = "historico")
@AllArgsConstructor
@NoArgsConstructor
public class Historico {
	@EmbeddedId
	private HistoricoPK id;
	@NotNull
	@Column(name = "data")
	private Date createdDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idLivro")
	@JoinColumn(name = "id_livro", referencedColumnName = "id_livro", insertable = false, updatable = false)
	@JsonIgnore
	private Livro livro;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idLeitor")
	@JoinColumn(name = "id_leitor", referencedColumnName = "id_leitor", insertable = false, updatable = false)
	@JsonIgnore
	private Leitor leitor;
}
