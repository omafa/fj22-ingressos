package br.com.caelum.ingresso.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Test;

public class SessaoTest {

	@Test
	public void oPrecoDaSessaoDeveerIgualASomaDoPrecoDaSalaMaisoPrecoDoFilme() {

		Sala sala = new Sala("Eldorado - IMAX", new BigDecimal(120));
		Filme filme = new Filme("rocky", Duration.ofMinutes(120), "drama", new BigDecimal("12.0"));
	
		BigDecimal somaDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());
		
		Sessao sessao = new Sessao (LocalTime.now(),filme,sala);
		
		assertEquals(somaDosPrecosDaSalaEFilme,sessao.getPreco());
	}

}
