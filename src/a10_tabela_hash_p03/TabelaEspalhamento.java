package a10_tabela_hash_p03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaEspalhamento {

	private static final int TAMANHO = 26;

	private List<List<String>> tabela;

	public TabelaEspalhamento() {
		this.tabela = new ArrayList<List<String>>();
		for (int i = 0; i < TAMANHO; ++i) {
			this.tabela.add(new LinkedList<String>());
		}
	}

	private int calculaHash(String info) {
		int hash = 0; 
		for (int i =0; i < info.length(); ++i) {
			hash += (int) info.toLowerCase().charAt(i);
		}
		return hash;
	}

	private int calculaPosicao(String info) {
		return calculaHash(info) % TAMANHO;
	}

	public void adiciona(String info) {
		int posicao = calculaPosicao(info);
		List<String> balde = tabela.get(posicao);
		balde.add(info);
	}

	public void remove(String info) {
		int posicao = calculaPosicao(info);
		List<String> balde = tabela.get(posicao);
		balde.remove(info);
	}

	public boolean contem(String info) {
		int posicao = calculaPosicao(info);
		List<String> balde = tabela.get(posicao);
		return balde.contains(info);
	}
	
	@Override
	public String toString() {
		return tabela.toString();
	}
}
