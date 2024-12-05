package a06_abb_p01;

public class ArvoreBinariaBusca {
	
	private NodoABB raiz;
	
	public ArvoreBinariaBusca() {
	}
	
	public NodoABB getRaiz() {
		return raiz;
	}

	public void adiciona(Comparable info) {
		// Implementar lógica de adicionar
		NodoABB novoNodo = new NodoABB(info);

		if (raiz == null) {
			raiz = novoNodo;
		} else {
			NodoABB nodo = raiz;
			while (nodo != null) {
				int comparacao = info.compareTo(nodo.getInfo());
				if (comparacao < 0) {
					// vai pra esquerda
					if (nodo.getEsquerdo() == null) {
						nodo.setEsquerdo(novoNodo);
						novoNodo.setPai(nodo);
						nodo = null;
					} else {
						nodo = nodo.getEsquerdo();
					}
				} else if (comparacao > 0) {
					// vai pra dierita
					if (nodo.getDireito() == null) {
						nodo.setDireito(novoNodo);
						novoNodo.setPai(nodo);
						nodo = null;
					} else {
						nodo = nodo.getDireito();
					}
				} else {
					break;
				}
			}
		}
	}
	
	public NodoABB busca(Comparable info) {
		NodoABB resultado = null;
		int comparacoes = 0;
		NodoABB nodo = raiz;
		while (nodo != null) {
			int comp = info.compareTo(nodo.getInfo());
			comparacoes++;
			if (comp == 0) {
				resultado = nodo;
				break;
			} else if (comp < 0) {
				// Informação é menor do que o que está no nodo
				nodo = nodo.getEsquerdo();
			} else if (comp > 0) {
				// Informação é maior do que o que está no nodo
				nodo = nodo.getDireito();
			}
		}
		System.out.println(comparacoes + " comparacoes!");

		return resultado;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		montaStringEmPreOrdemEsquerda(raiz, sb, 0);
		return sb.toString();
	}

	private void montaStringEmPreOrdemEsquerda(NodoABB nodo, StringBuilder sb, int nivel) {
		// Travessia em profundidade, pré-ordem (processamento da raiz antes dos filhos)
		for (int i = 0; i < nivel; ++i) {
			sb.append("  ");
		}

		sb.append(String.valueOf(nodo.getInfo()));
		sb.append("\n");

		if (nodo.getEsquerdo() != null) {
			montaStringEmPreOrdemEsquerda(nodo.getEsquerdo(), sb, nivel + 1);
		}
		 
		if (nodo.getDireito() != null) {
			montaStringEmPreOrdemEsquerda(nodo.getDireito(), sb, nivel + 1);
		}
	}
	
}













