package br.com.apitcu.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TermosContratuais {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String tipoContratacao;
	@Column
	private Long numero;
	@Column
	private Long ano;
	@Column
	private String unidadeGestora;
	@Column
	private String nomeFornecedor;
	@Column
	private String cnpjFornecedor;
	@Column(columnDefinition = "TEXT")
	private String objeto;
	@Column
	private BigDecimal valorInicial;
	@Column
	private String numeroProcesso;
	@Column
	private String modalidadeLicitacao;
	@Column
	private BigDecimal valorAtualizado;
	
	public TermosContratuais(String tipoContratacao, Long numero, Long ano, String unidadeGestora,
			String nomeFornecedor, String cnpjFornecedor, String objeto, BigDecimal valorInicial,
			String numeroProcesso, String modalidadeLicitacao, BigDecimal valorAtualizado) {
		super();
		this.tipoContratacao = tipoContratacao;
		this.numero = numero;
		this.ano = ano;
		this.unidadeGestora = unidadeGestora;
		this.nomeFornecedor = nomeFornecedor;
		this.cnpjFornecedor = cnpjFornecedor;
		this.objeto = objeto;
		this.valorInicial = valorInicial;
		this.numeroProcesso = numeroProcesso;
		this.modalidadeLicitacao = modalidadeLicitacao;
		this.valorAtualizado = valorAtualizado;
	}
	
}
