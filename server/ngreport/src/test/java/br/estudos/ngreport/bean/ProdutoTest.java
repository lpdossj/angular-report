package br.estudos.ngreport.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProdutoTest {

	public static List<Produto> createBeanCollection() {
		List<Produto> lista = new ArrayList<Produto>();
		
		for (int i = 0; i < 1000; i++) {
			lista.add(createProduto(i));
		}
		return lista;
	}
	
	private static BigDecimal random(int casasInt, int casasDec) {
		Random r = new Random();
		double valor = r.nextDouble();
		int multiplicador = r.nextInt(casasInt);
		valor = Math.pow(10, multiplicador) * valor;

		return new BigDecimal(String.valueOf(valor)).setScale(casasDec, RoundingMode.HALF_UP);
	}
	
	private static Produto createProduto(int i) {
		Produto produto = new Produto(i + 1L, "Nome " + (i+1), random(5, 2));
		Random r = new Random();
		int intRandom = r.nextInt(100) % 3;
		
		switch (intRandom) {
		case 0:
			produto.setStatus("ATIVO");
			break;
		case 1:
			produto.setStatus("INATIVO");
			break;
		case 2:
			produto.setStatus("PENDENTE");
			break;
		default:
			produto.setStatus("DESCONHECIDO");
			break;
		}
		
		intRandom = r.nextInt(100) % 3;
		
		switch (intRandom) {
		case 0:
			produto.setTipoProduto("ELETRONICO");
			break;
		case 1:
			produto.setTipoProduto("CAMA E MESA");
			break;
		case 2:
			produto.setTipoProduto("PERECÍVEL");
			break;
		default:
			produto.setTipoProduto("NÃO CATALOGADO");
			break;
		}
		
		return produto;
	}
}
