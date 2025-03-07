package a11_p02_hash_object;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaEspalhamento {

	private static final int TAMANHO = 26;

	private List<List<Object>> tabela;

	public TabelaEspalhamento() {
		this.tabela = new ArrayList<List<Object>>();
		for (int i = 0; i < TAMANHO; ++i) {
			this.tabela.add(new LinkedList<Object>());
		}
	}

	private int calculaHash(Object info) {
		return Math.abs(info.hashCode());
	}

	private int calculaPosicao(Object info) {
		return calculaHash(info) % TAMANHO;
	}

	public void adiciona(Object info) {
		int posicao = calculaPosicao(info);
		List<Object> balde = tabela.get(posicao);
		balde.add(info);
	}

	public void remove(Object info) {
		int posicao = calculaPosicao(info);
		List<Object> balde = tabela.get(posicao);
		balde.remove(info);
	}

	public boolean contem(Object info) {
		int posicao = calculaPosicao(info);
		List<Object> balde = tabela.get(posicao);
		return balde.contains(info);
	}
	
	@Override
	public String toString() {
		return tabela.toString();
	}
}
