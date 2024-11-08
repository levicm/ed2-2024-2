package a03_arvore_binaria_p02;

public class ArvoreBinaria {
	
	private Nodo raiz;

	public ArvoreBinaria() {
	}
	
	public Nodo criaRaiz(Object info) {
		raiz = new Nodo(info);
		return raiz;
	}
	
	public Nodo getRaiz() {
		return raiz;
	}
	
	public Nodo adicionaEsquerdo(Nodo pai, Object info) {
		Nodo nodo = new Nodo(info);
		pai.setEsquerdo(nodo);
		nodo.setPai(pai);
		return nodo;
	}
	
	public Nodo adicionaDireito(Nodo pai, Object info) {
		Nodo nodo = new Nodo(info);
		pai.setDireito(nodo);
		nodo.setPai(pai);
		return nodo;
	}
	
	public void deletaNodo(Nodo nodo) {
		Nodo pai = nodo.getPai();
		if (pai.getDireito() == nodo) {
			pai.setDireito(null);
		}
		if (pai.getEsquerdo() == nodo) {
			pai.setEsquerdo(null);
		}
		nodo.setPai(null);
	}
	
	public Nodo busca(Object info) {
		// Processa uma busca recursiva iniciando pela raiz
		return buscaInfoEmPreOrdem(raiz, info);
	}
	
	private Nodo buscaInfoEmPreOrdem(Nodo nodo, Object info) {
		Nodo resultado = null;
		// processa o nó primeiro
		if (info.equals(nodo.getInfo())) {
			resultado = nodo;
		}

		// Depois processa os filhos
		if (resultado == null && nodo.getEsquerdo() != null) {
			resultado = buscaInfoEmPreOrdem(nodo.getEsquerdo(), info);
		}
		 
		if (resultado == null && nodo.getDireito() != null) {
			resultado = buscaInfoEmPreOrdem(nodo.getDireito(), info);
		}
		return resultado;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		montaStringEmCentralEsquerda(raiz, sb, 0);
		return sb.toString();
	}

	private void montaStringEmCentralEsquerda(Nodo nodo, StringBuilder sb, int nivel) {		
		if (nodo.getEsquerdo() != null) {
			sb.append("( ");
			montaStringEmCentralEsquerda(nodo.getEsquerdo(), sb, nivel + 1);
		}

		sb.append(String.valueOf(nodo.getInfo()));
		 
		if (nodo.getDireito() != null) {
			montaStringEmCentralEsquerda(nodo.getDireito(), sb, nivel + 1);
			sb.append(" )");
		}
	}

	private void montaStringEmPreOrdemEsquerda(Nodo nodo, StringBuilder sb, int nivel) {
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
