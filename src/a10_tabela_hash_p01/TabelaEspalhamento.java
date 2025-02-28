package a10_tabela_hash_p01;

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

	private int calculaPosicao(String info) {
		int hash = (int) info.toLowerCase().charAt(0); 
		return hash % TAMANHO;
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
