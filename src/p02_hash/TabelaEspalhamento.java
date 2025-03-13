package p02_hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaEspalhamento {

	private static final int TAMANHO = 26;

	private List<List<Celula>> tabela;

	public TabelaEspalhamento() {
		this.tabela = new ArrayList<List<Celula>>();
		for (int i = 0; i < TAMANHO; ++i) {
			this.tabela.add(new LinkedList<Celula>());
		}
	}

	private int calculaHash(Object info) {
		return Math.abs(info.hashCode());
	}

	private int calculaPosicao(Object info) {
		return calculaHash(info) % TAMANHO;
	}

	public void adiciona(Object chave) {
		adiciona(chave, chave);
	}

	public void adiciona(Object chave, Object valor) {
		int posicao = calculaPosicao(chave);
		List<Celula> balde = tabela.get(posicao);
		balde.add(new Celula(chave, valor));
	}

	public Object busca(Object chave) {
		int posicao = calculaPosicao(chave);
		List<Celula> balde = tabela.get(posicao);
		int index = balde.indexOf(new Celula(chave));
		if (index > -1) {
			return balde.get(index).getValor();
		}
		return null;
	}

	public boolean contem(Object chave) {
		return busca(chave) != null;
	}

	public void remove(Object chave) {
		int posicao = calculaPosicao(chave);
		List<Celula> balde = tabela.get(posicao);
		balde.remove(new Celula(chave));
	}

	@Override
	public String toString() {
		return tabela.toString();
	}

	public boolean isVazia() {
		return false;
	}
	
	public List chaves() {
		return null;
	}
}
