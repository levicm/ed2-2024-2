package a05_abb_p01;

import a06_abb_p02.NodoABB;

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
				}
			}
		}
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		montaStringEmPreOrdemEsquerda(raiz, sb, 0, "R");
		return sb.toString();
	}

	private void montaStringEmPreOrdemEsquerda(NodoABB nodo, StringBuilder sb, int nivel, String lado) {
		// Travessia em profundidade, pré-ordem (processamento da raiz antes dos filhos)
		for (int i = 0; i < nivel; ++i) {
			sb.append("  ");
		}

		sb.append("(" + lado + ") ");
		sb.append(String.valueOf(nodo.getInfo()));
		sb.append("\n");

		if (nodo.getEsquerdo() != null) {
			montaStringEmPreOrdemEsquerda(nodo.getEsquerdo(), sb, nivel + 1, "E");
		}
		 
		if (nodo.getDireito() != null) {
			montaStringEmPreOrdemEsquerda(nodo.getDireito(), sb, nivel + 1, "D");
		}
	}
	
}













