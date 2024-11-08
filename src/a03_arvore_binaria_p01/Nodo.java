package a03_arvore_binaria_p01;

public class Nodo {
	private Object info;
	private Nodo pai;
	private Nodo esquerdo;
	private Nodo direito;

	public Nodo(Object info) {
		this.info = info;
	}

	public Object getInfo() {
		return info;
	}

	public Nodo getPai() {
		return pai;
	}

	public void setPai(Nodo pai) {
		this.pai = pai;
	}

	public Nodo getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(Nodo esquerdo) {
		this.esquerdo = esquerdo;
	}

	public Nodo getDireito() {
		return direito;
	}

	public void setDireito(Nodo direito) {
		this.direito = direito;
	}

	public String toString() {
		return String.valueOf(info);
	}

}
