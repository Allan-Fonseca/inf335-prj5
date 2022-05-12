package br.unicamp.ic.inf335.app.inf33_prj02;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AnuncianteBeanTest {
	
	private static ProdutoBean nProg = new ProdutoBean("CD00001","Celular Galaxy S10", "128 Gb, Preto, com Carregador",1250.0,"Poucos riscos, estado de novo.");
	private static ProdutoBean nProg2 = new ProdutoBean("CD00002","Prod 2 ...", "Bla Bla Bla",1100.0,"Bla Bla Bla");
	private static ArrayList<URL> fotos = new ArrayList<URL>();
	private static AnuncioBean anuncio1 = new AnuncioBean(nProg, fotos, 0.25);
	private static AnuncioBean anuncio2 = new AnuncioBean(nProg2, fotos, 0.25);
	private static ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();

	@Test
	void testAddAnuncio() {
		anuncios = new ArrayList<AnuncioBean>();
		anuncios.add(anuncio1);
		AnuncianteBean anunciante = new AnuncianteBean("Joao", "123456789-00", anuncios);
		anunciante.addAnuncio(anuncio2);
		ArrayList<AnuncioBean> ans = anunciante.getAnuncios();
		assertEquals(anuncio2, ans.get(ans.size() - 1));
	}
	
	@Test
	void testRemoveAnuncio() {
		anuncios = new ArrayList<AnuncioBean>();
		anuncios.add(anuncio1);
		anuncios.add(anuncio2);
		int size = anuncios.size();
		AnuncianteBean anunciante = new AnuncianteBean("Joao", "123456789-00", anuncios);
		anunciante.removeAnuncio(anuncios.size() - 1);
		ArrayList<AnuncioBean> ans = anunciante.getAnuncios();
		assertEquals(size, ans.size() + 1);
	}
	
	@Test
	void testValorMedioAnuncios() {
		anuncios = new ArrayList<AnuncioBean>();
		anuncios.add(anuncio1);
		anuncios.add(anuncio2);
		AnuncianteBean anunciante = new AnuncianteBean("Joao", "123456789-00", anuncios);
		assertEquals((anuncio1.getValor() + anuncio2.getValor()) / 2, anunciante.valorMedioAnuncios());
	}

}
