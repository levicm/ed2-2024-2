package a07_arvore_trie_p01;

public class ArvoreTrie {

	private NodoTrieASCII raiz = new NodoTrieASCII();

	public void adiciona(String chave, Object valor) {
		adiciona(chave, valor, raiz, 0);
	}

	private void adiciona(String chave, Object valor, NodoTrieASCII nodo, int posicao) {
		if (posicao == chave.length()) {
			nodo.setValor(valor);
		} else {
			char letra = chave.charAt(posicao);
			NodoTrieASCII filho = nodo.getFilho(letra);
			if (filho == null) {
				// Criar o filho correspondente à letra
				filho = new NodoTrieASCII();
				nodo.setFilho(letra, filho);
			}
			adiciona(chave, valor, filho, posicao + 1);
		}
	}
	
	public Object busca(String chave) {
		return busca(chave, raiz, 0);
	}
	
	private Object busca(String chave, NodoTrieASCII nodo, int posicao) {
		if (posicao == chave.length()) {
			return nodo.getValor();
		} else {
			char letra = chave.charAt(posicao);
			NodoTrieASCII filho = nodo.getFilho(letra);
			if (filho != null) {
				return busca(chave, filho, posicao + 1);
			} else {
				return null;
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		montaString(raiz, sb, 0);
		return sb.toString();
	}

	private void montaString(NodoTrieASCII nodo, StringBuilder sb, int posicao) {
		if (nodo.getValor() != null) {
			sb.append(nodo.getValor());
		}
		for (int i = 0; i < NodoTrieASCII.MAXIMO; ++i) {
			char letra = (char) i;
			NodoTrieASCII filho = nodo.getFilho(letra);
			if (filho != null) {
				sb.append("\n");
				for (int j = 0; j < posicao; ++j) {
					sb.append("  ");
				}
				sb.append("(");
				sb.append(letra);
				sb.append(")");
				montaString(filho, sb, posicao + 1);
			}
		}
	}

}







