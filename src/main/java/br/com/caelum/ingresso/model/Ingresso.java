package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingresso {

	public TipodeIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}

	public void setTipoDeIngresso(TipodeIngresso tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	private Sessao sessao;

	private BigDecimal preco;

	@ManyToOne
	private Lugar lugar;

	@Enumerated(EnumType.STRING)
	private TipodeIngresso tipoDeIngresso;

	public Ingresso() {
		// TODO Auto-generated constructor stub
	}

	public Ingresso(Sessao sessao, TipodeIngresso tipoDeDesconto, Lugar lugar) {
		this.sessao = sessao;
		this.tipoDeIngresso = tipoDeDesconto;
		this.preco = this.tipoDeIngresso.aplicaDesconto(sessao.getPreco());
		this.setLugar(lugar);
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

}
