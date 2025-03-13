package prova02_base;

public class ArvoreTrie {

	private class NodoTrieASCII {
		
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
	
	public void remove(String chave) {
		remove(chave, raiz, 0);
	}

	private Object remove(String chave, NodoTrieASCII nodo, int posicao) {
		if (posicao == chave.length()) {
			// Chegou no elemento da string completa da chave
			Object valor = nodo.getValor(); 
			nodo.setValor(null);
			return valor;
		} else {
			char letra = chave.charAt(posicao);
			NodoTrieASCII filho = nodo.getFilho(letra);
			if (filho != null) {
				Object valor = remove(chave, filho, posicao + 1);
				if (valor != null && filho.getQtdFilhos() == 0 && filho.getValor() == null) {
					nodo.setFilho(letra, null);
				}
				return valor;
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

	public boolean contemValor(Object valor) {
		// Implementar
	    return false;
	}

	public void adicionaTodos(ArvoreTrie outra) {
		// Implementar
	}
}







