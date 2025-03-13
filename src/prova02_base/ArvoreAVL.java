package prova02_base;

public class ArvoreAVL {

	private class NodoAVL {

		private Comparable chave;
		private Object valor;

		private NodoAVL pai;
		private NodoAVL esquerdo;
		private NodoAVL direito;
		private int altura;

		public NodoAVL(Comparable chave) {
			this.chave = chave;
		}

		public NodoAVL(Comparable chave, Object valor) {
			this.chave = chave;
			this.valor = valor;
		}

		public NodoAVL getPai() {
			return pai;
		}

		public void setPai(NodoAVL pai) {
			this.pai = pai;
		}

		public NodoAVL getEsquerdo() {
			return esquerdo;
		}

		public void setEsquerdo(NodoAVL esquerdo) {
			this.esquerdo = esquerdo;
		}

		public NodoAVL getDireito() {
			return direito;
		}

		public void setDireito(NodoAVL direito) {
			this.direito = direito;
		}

		public Comparable getChave() {
			return chave;
		}
		
		public Object getValor() {
			return valor;
		}

		public int getAltura() {
			return altura;
		}

		public void atualizaAltura() {
			this.altura = Math.max(getAltura(direito), getAltura(esquerdo)) + 1;
		}

		private int getAltura(NodoAVL nodo) {
			if (nodo != null) {
				return nodo.getAltura();
			} else {
				return 0;
			}
		}

		public int getFatorBal() {
			return getAltura(direito) - getAltura(esquerdo);
		}
		
		@Override
		public String toString() {
			return "(" + chave.toString() + " |h:" + getAltura() + ",fb:" + getFatorBal() + ")";
		}
	}

	private NodoAVL raiz;
	
	public void adiciona(Comparable chave) {
		adiciona(chave, chave);
	}

	public void adiciona(Comparable chave, Object valor) {
		this.raiz = adiciona(chave, valor, this.raiz);		
	}

	private NodoAVL adiciona(Comparable chave, Object valor, NodoAVL nodo) {
		if (nodo == null) {
			nodo = new NodoAVL(chave, valor);
		} else {
			int comp = chave.compareTo(nodo.getChave());
			if (comp > 0) {
				NodoAVL filho = adiciona(chave, valor, nodo.getDireito());
				nodo.setDireito(filho);
				filho.setPai(nodo);
			} else if (comp < 0) {
				NodoAVL filho = adiciona(chave, valor, nodo.getEsquerdo());
				nodo.setEsquerdo(filho);
				filho.setPai(nodo);
			}
		}
		nodo.atualizaAltura();
		nodo = balancear(nodo);
		return nodo;
	}
	
	private NodoAVL balancear(NodoAVL nodo) {
//		System.out.print("Balancear " + nodo + "");
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
//		System.out.println(" -> " + resultado);
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
	
	public Object busca(Comparable chave) {
		NodoAVL nodo = buscaNodo(chave);
		if (nodo != null) {
			return nodo.getValor();
		}
		return null;
	}
	
	private NodoAVL buscaNodo(Comparable chave) {
		NodoAVL nodo = raiz;
		while (nodo != null) {
			int comp = chave.compareTo(nodo.getChave());
			if (comp > 0) {
				nodo = nodo.getDireito();
			} else if (comp < 0) {
				nodo = nodo.getEsquerdo();
			} else {
				return nodo;
			}
		}
		return null;		
	}
	
	public void remove(Comparable chave) {
		NodoAVL nodo = buscaNodo(chave);
		if (nodo != null) {
			NodoAVL pai = nodo.getPai(); 
			removeNodo(nodo);
			balancearPais(pai);
		}
	}

	private void balancearPais(NodoAVL nodo) {
		if (nodo != null) {
			nodo.atualizaAltura();
			boolean ehRaiz = nodo == raiz;
			nodo = balancear(nodo);
			if (ehRaiz) {
				raiz = nodo;
			}
			balancearPais(nodo.getPai());
		}
	}

	private void removeNodo(NodoAVL nodo) {
		if (nodo.getEsquerdo() == null && nodo.getDireito() == null) {
			NodoAVL pai = nodo.getPai();
			if (nodo == pai.getEsquerdo()) {
				pai.setEsquerdo(null);
			} else {
				pai.setDireito(null);
			}
		} else if (nodo.getEsquerdo() == null || nodo.getDireito() == null) {
			NodoAVL filho;
			if (nodo.getEsquerdo() != null) {
				filho = nodo.getEsquerdo();
			} else {
				filho = nodo.getDireito();
			}
			NodoAVL pai = nodo.getPai();
			if (nodo == pai.getEsquerdo()) {
				pai.setEsquerdo(filho);
			} else {
				pai.setDireito(filho);
			}
			filho.setPai(pai);
		} else {
			// Quando tem os dois filhos, precisa escolher um lado e trocar com o nodo
			NodoAVL escolhido = nodo.getEsquerdo();
			removeNodo(escolhido);
			troca(nodo, escolhido);
		}
	}

	private void troca(NodoAVL velho, NodoAVL novo) {
		novo.setPai(velho.getPai());
		novo.setEsquerdo(velho.getEsquerdo());
		novo.setDireito(velho.getDireito());

		if (velho.getPai() != null) {
			if (velho.getPai().getEsquerdo() == velho) {
				velho.getPai().setEsquerdo(novo);
			} else {
				velho.getPai().setDireito(novo);
			}
		}
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

		sb.append(String.valueOf(nodo.getChave()));
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
	
	public void limpa() {
	    // Implementar
	}

	public ArvoreAVL clone() {
	    // Implementar
	    return null;
	}
}










