package br.unicamp.ic.inf335.app.inf33_prj02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.util.ArrayList;
import java.net.URL;

class AnuncioBeanTest {
	
	private static ProdutoBean nProg = new ProdutoBean("CD00001","Celular Galaxy S10", "128 Gb, Preto, com Carregador",1250.0,"Poucos riscos, estado de novo.");
	private static ArrayList<URL> fotos = new ArrayList<URL>();

	@Test
	void testGetProduto() {
		AnuncioBean anuncio = new AnuncioBean(nProg, fotos, 0.25);
		assertEquals(nProg, anuncio.getProduto());
	}

	@Test
	void testGetDesconto() {
		double desconto = 0.25;
		AnuncioBean anuncio = new AnuncioBean(nProg, fotos, desconto);
		assertEquals(desconto, anuncio.getDesconto());
	}

	@Test
	void testGetValor() {
		double desconto = 0.25;
		AnuncioBean anuncio = new AnuncioBean(nProg, fotos, desconto);
		assertEquals(nProg.getValor() * (1 - desconto), anuncio.getValor());
	}

}
