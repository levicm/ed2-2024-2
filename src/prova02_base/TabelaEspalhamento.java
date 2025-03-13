package prova02_base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaEspalhamento {

	private class Celula {
		private Object chave;
		private Object valor;

		public Celula(Object chave) {
			super();
			this.chave = chave;
		}

		public Celula(Object chave, Object valor) {
			super();
			this.chave = chave;
			this.valor = valor;
		}

		public Object getChave() {
			return chave;
		}

		public void setChave(Object chave) {
			this.chave = chave;
		}

		public Object getValor() {
			return valor;
		}

		public void setValor(Object valor) {
			this.valor = valor;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Celula) {
				Celula outra = (Celula) obj;
				return chave.equals(outra.chave);
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return chave.hashCode();
		}

		@Override
		public String toString() {
			return String.valueOf(chave) + ": " + String.valueOf(valor);
		}
	}

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
	    // Implementar
	    return false;
	}

	public List chaves() {
		// Implementar
	    return null;
	}
}
