package a05_abb_p01;

public class NodoABB {

	private Comparable info;
	private NodoABB pai;
	private NodoABB esquerdo;
	private NodoABB direito;

	public NodoABB(Comparable info) {
		this.info = info;
	}

	public Comparable getInfo() {
		return info;
	}

	public NodoABB getPai() {
		return pai;
	}

	public void setPai(NodoABB pai) {
		this.pai = pai;
	}

	public NodoABB getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(NodoABB esquerdo) {
		this.esquerdo = esquerdo;
	}

	public NodoABB getDireito() {
		return direito;
	}

	public void setDireito(NodoABB direito) {
		this.direito = direito;
	}

	public String toString() {
		return String.valueOf(info);
	}

}
