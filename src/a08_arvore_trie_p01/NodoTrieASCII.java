package a08_arvore_trie_p01;

public class NodoTrieASCII {
	
	public static int MAXIMO = 255;

	private NodoTrieASCII[] filhos = new NodoTrieASCII[MAXIMO];
	private Object valor;
	
	public Object getValor() {
		return valor;
	}
	
	public void setValor(Object valor) {
		this.valor = valor;
	}
	
	public NodoTrieASCII getFilho(char letra) {
		int posicao = (int) letra;
		return filhos[posicao];
	}
	
	public void setFilho(char letra, NodoTrieASCII filho) {
		int posicao = (int) letra;
		filhos[posicao] = filho;
	}
	
	public int getQtdFilhos() {
		int qtd = 0;
		for (int i = 0; i < MAXIMO; ++i) {
			if (filhos[i] != null) {
				qtd++;
			}
		}
		return qtd;
	}
}

















