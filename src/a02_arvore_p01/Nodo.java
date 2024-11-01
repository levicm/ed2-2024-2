package a02_arvore_p01;

import java.util.ArrayList;
import java.util.List;

public class Nodo {

	private Object dado;
	private List<Nodo> filhos = new ArrayList<Nodo>();
	
	public Nodo(Object dado) {
		this.dado = dado;
	}
	
	public Object getDado() {
		return this.dado;
	}
	
	public List<Nodo> getFilhos() {
		return this.filhos;
	}
	
	public void adiciona(Nodo nodo) {
		this.filhos.add(nodo);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		montaStringEmPreOrdem(this, sb, 0);
		return sb.toString();
	}

	private void montaStringEmPreOrdem(Nodo nodo, StringBuilder sb, int nivel) {
		// Travessia em profundidade, pré-ordem (processamento da raiz antes dos filhos)
		for (int i = 0; i < nivel; ++i) {
			sb.append("  ");
		}
		sb.append(String.valueOf(nodo.getDado()));
		sb.append("\n");
		for (Nodo filho : nodo.getFilhos()) {
			montaStringEmPreOrdem(filho, sb, nivel + 1);
		}
	}
}






