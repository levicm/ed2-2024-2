package a09_arvore_avl_p01;

public class ArvoreAVL {

	private NodoAVL raiz;
	
	
	public void adiciona(Comparable info) {
		this.raiz = adiciona(info, this.raiz);		
	}

	private NodoAVL adiciona(Comparable info, NodoAVL nodo) {
		if (nodo == null) {
			nodo = new NodoAVL(info);
		} else {
			int comp = info.compareTo(nodo.getInfo());
			if (comp > 0) {
				NodoAVL filho = adiciona(info, nodo.getDireito());
				nodo.setDireito(filho);
				filho.setPai(nodo);
			} else if (comp < 0) {
				NodoAVL filho = adiciona(info, nodo.getEsquerdo());
				nodo.setEsquerdo(filho);
				filho.setPai(nodo);
			}
		}
		nodo.atualizaAltura();
//		nodo = balancear(nodo);
		return nodo;
	}
	
	private NodoAVL balancear(NodoAVL nodo) {
		System.out.print("Balancear " + nodo + "");
		NodoAVL resultado = nodo;
		int fator = nodo.getFatorBal();
		if (fator > 1) { // desbalanceado para a direita
			// Balancear, rotacionando para a esquerda
			if (nodo.getDireito().getFatorBal() > 0) {
				resultado = rotacaoSimplesEsquerda(nodo);
			} else {
				resultado = rotacaoDuplaEsquerda(nodo);
			}
		} else if (fator < -1) { // desbalanceado para a esquerda
			// Balancear, rotacionando para a direita
			if (nodo.getEsquerdo().getFatorBal() < 0) {
				resultado = rotacaoSimplesDireita(nodo);
			} else {
				resultado = rotacaoDuplaDireita(nodo);
			}
		}
		System.out.println(" -> " + resultado);
		return resultado;
	}

	private NodoAVL rotacaoSimplesDireita(NodoAVL nodo) {
		// troca de filho:
		NodoAVL ne = nodo.getEsquerdo();
		nodo.setEsquerdo(ne.getDireito());
		ne.setDireito(nodo);
		// troca de pais:
		ne.setPai(nodo.getPai());
		nodo.setPai(ne);
		// atualiza alturas:
		nodo.atualizaAltura();
		ne.atualizaAltura();
		return ne;
	}

	private NodoAVL rotacaoSimplesEsquerda(NodoAVL nodo) {
		// troca de filho:
		NodoAVL nd = nodo.getDireito();
		nodo.setDireito(nd.getEsquerdo());
		nd.setEsquerdo(nodo);
		// troca de pais:
		nd.setPai(nodo.getPai());
		nodo.setPai(nd);
		// atualiza alturas:
		nodo.atualizaAltura();
		nd.atualizaAltura();
		return nd;
	}

	private NodoAVL rotacaoDuplaDireita(NodoAVL nodo) {
		NodoAVL novoEsquerdo = rotacaoSimplesEsquerda(nodo.getEsquerdo());
		nodo.setEsquerdo(novoEsquerdo);
		return rotacaoSimplesDireita(nodo);
	}

	private NodoAVL rotacaoDuplaEsquerda(NodoAVL nodo) {
		NodoAVL novoDireito = rotacaoSimplesDireita(nodo.getDireito());
		nodo.setDireito(novoDireito);
		return rotacaoSimplesEsquerda(nodo);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		montaStringEmPreOrdemDireita(raiz, sb, 0);
		return sb.toString();
	}

	private void montaStringEmPreOrdemEsquerda(NodoAVL nodo, StringBuilder sb, int nivel) {
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

	private void montaStringEmPreOrdemDireita(NodoAVL nodo, StringBuilder sb, int nivel) {
		// Travessia em profundidade, pré-ordem (processamento da raiz antes dos filhos)
		sb.append(String.valueOf(nodo.toString()));
		sb.append("\n");

		if (nodo.getDireito() != null) {
			for (int i = 0; i <= nivel; ++i) {
				sb.append("  ");
			}
			sb.append("D: ");
			montaStringEmPreOrdemDireita(nodo.getDireito(), sb, nivel + 1);
		}

		if (nodo.getEsquerdo() != null) {
			for (int i = 0; i <= nivel; ++i) {
				sb.append("  ");
			}
			sb.append("E: ");
			montaStringEmPreOrdemDireita(nodo.getEsquerdo(), sb, nivel + 1);
		} 
	}
}










