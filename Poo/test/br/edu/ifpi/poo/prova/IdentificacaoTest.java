package br.edu.ifpi.poo.prova;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.ifpi.poo.prova.model.Identificacao;

public class IdentificacaoTest {
	private static Identificacao i;
	
	@BeforeClass
	public static void inicializar(){
		i = new Identificacao();
	}
	
	@Test
	public void testValidarNome(){
		i.setNome("Francisco");
		Assert.assertTrue(i.ValidarNome());
	}
	//TEST AssertTrue
	@Test
	public void testValidarCpf(){
		i.setCpf("054.759.123-45");
		Assert.assertTrue(i.ValidarCpf());
	}
	
	//Test Expected Excecao
	@Test(expected = IllegalArgumentException.class)
	public void testValidaNomeNulo(){
		Identificacao i = new Identificacao("Francisco");
		i = new Identificacao(null);
	}
	
	//Test AssertEquals
	
	//Test AssertEquals(o,10, c.calcula) precissão
	
	//Test Expected = excecao
	
	//Test AssertTrue/ Assert False
}
