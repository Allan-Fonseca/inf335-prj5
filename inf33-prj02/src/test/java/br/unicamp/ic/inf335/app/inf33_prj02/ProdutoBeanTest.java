package br.unicamp.ic.inf335.app.inf33_prj02;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class ProdutoBeanTest {
	
	private static ProdutoBean nProg = new ProdutoBean("CD00001","Celular Galaxy S10", "128 Gb, Preto, com Carregador",1250.0,"Poucos riscos, estado de novo.");
	private static ProdutoBean nProg2 = new ProdutoBean("CD00002","Prod 2 ...", "Bla Bla Bla",1100.0,"Bla Bla Bla");
	private static ProdutoBean nProg3 = new ProdutoBean("CD00003","Prod 3 ...", "Bla Bla Bla",1200.0,"Bla Bla Bla");
	
	@Test
	void testGetCodigo() {
		String codigo = nProg.getCodigo();
		assertEquals(codigo, "CD00001");
	}

	@Test
	void testGetNome() {
		String nome = nProg.getNome();
		assertEquals(nome, "Celular Galaxy S10");
	}

	@Test
	void testGetDescricao() {
		String descricao = nProg.getDescricao();
		assertEquals(descricao, "128 Gb, Preto, com Carregador");
	}

	@Test
	void testGetValor() {
		double valor = nProg.getValor();
		assertEquals(valor, (double)1250.0);
	}

	@Test
	void testGetEstado() {
		String estado = nProg.getEstado();
		assertEquals(estado, "Poucos riscos, estado de novo.");
	}

	@Test
	void testCompareTo() {
		final ArrayList<ProdutoBean> produtos = new ArrayList<ProdutoBean>();
		produtos.add(nProg);
		produtos.add(nProg2);
		produtos.add(nProg3);
		Collections.sort(produtos);
		assertAll("produtos",
			() -> assertTrue(produtos.get(0).getValor() < produtos.get(1).getValor()),
			() -> assertTrue(produtos.get(1).getValor() < produtos.get(2).getValor())
		);
	}

}
