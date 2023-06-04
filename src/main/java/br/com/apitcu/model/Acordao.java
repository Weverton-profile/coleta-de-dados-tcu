package br.com.apitcu.model;

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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Acordao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String chave;
	@Column
	private String tipo;
	@Column
	private String anoAcordao;
	@Column
	private String titulo;
	@Column
	private String numeroAcordao;
	@Column
    private String numeroAta;
	@Column
    private String colegiado;
	@Column
    private String dataSessao;
	@Column
    private String relator;
	@Column
    private String situacao;
	@Column(columnDefinition = "TEXT")
    private String sumario;
	@Column(columnDefinition = "TEXT")
    private String urlArquivo;
	@Column(columnDefinition = "TEXT")
    private String urlArquivoPdf;
	@Column(columnDefinition = "TEXT")
    private String urlAcordao;
    
	public Acordao(String key, String tipo, String anoAcordao, String titulo, String numeroAcordao, String numeroAta,
			String colegiado, String dataSessao, String relator, String situacao, String sumario, String urlArquivo,
			String urlArquivoPdf, String urlAcordao) {
		this.chave = key;
		this.tipo = tipo;
		this.anoAcordao = anoAcordao;
		this.titulo = titulo;
		this.numeroAcordao = numeroAcordao;
		this.numeroAta = numeroAta;
		this.colegiado = colegiado;
		this.dataSessao = dataSessao;
		this.relator = relator;
		this.situacao = situacao;
		this.sumario = sumario;
		this.urlArquivo = urlArquivo;
		this.urlArquivoPdf = urlArquivoPdf;
		this.urlAcordao = urlAcordao;
	}
    

}
