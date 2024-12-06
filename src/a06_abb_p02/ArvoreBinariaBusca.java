package a06_abb_p02;

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
	
	public void remove(Comparable info) {
		NodoABB nodo = busca(info);
		if (nodo != null) {
			remove(nodo);
		}
	}

	private void remove(NodoABB nodo) {
		if (eFolha(nodo)) {
			// Situação 1 dos slides (não tem filhos)
			NodoABB pai = nodo.getPai();
			if (pai.getEsquerdo() == nodo) {
				pai.setEsquerdo(null);
			} else if (pai.getDireito() == nodo) {
				pai.setDireito(null);
			}
			nodo.setPai(null);
		} else if (nodo.getEsquerdo() == null || nodo.getDireito() == null) {
			// Situação 2 dos slides (só tem um filho)
			NodoABB filho;
			if (nodo.getEsquerdo() != null) {
				filho = nodo.getEsquerdo();
			} else {
				filho = nodo.getDireito();
			}
			NodoABB pai = nodo.getPai();
			if (pai.getEsquerdo() == nodo) {
				pai.setEsquerdo(filho);
			} else if (pai.getDireito() == nodo) {
				pai.setDireito(filho);
			}
			filho.setPai(pai);
			nodo.setPai(null);
		} else {
			// Situação 3 dos slides (tem dois filhos):
			// Vamos escolher pegar o menor do lado direito
			NodoABB nodoEscolhido = pegaMenor(nodo.getDireito());
			remove(nodoEscolhido);
			troca(nodo, nodoEscolhido);
		}
	}

	private void troca(NodoABB velho, NodoABB novo) {
		novo.setPai(velho.getPai());
		novo.setEsquerdo(velho.getEsquerdo());
		novo.setDireito(velho.getDireito());
		
		NodoABB pai = velho.getPai();
		if (pai.getEsquerdo() == velho) {
			pai.setEsquerdo(novo);
		} else if (pai.getDireito() == velho) {
			pai.setDireito(novo);
		}
	}

	private NodoABB pegaMenor(NodoABB nodo) {
		while (nodo.getEsquerdo() != null) {
			nodo = nodo.getEsquerdo();
		}
		return nodo;
	}

	private NodoABB pegaMaior(NodoABB nodo) {
		while (nodo.getDireito() != null) {
			nodo = nodo.getDireito();
		}
		return nodo;
	}

	private boolean eFolha(NodoABB nodo) {
		return nodo.getEsquerdo() == null & nodo.getDireito() == null;
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













