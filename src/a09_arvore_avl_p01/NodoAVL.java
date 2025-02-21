package a09_arvore_avl_p01;

public class NodoAVL {

	private Comparable info;

	private NodoAVL pai;
	private NodoAVL esquerdo;
	private NodoAVL direito;
	private int altura;

	public NodoAVL(Comparable info) {
		this.info = info;
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

	public Comparable getInfo() {
		return info;
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
		return "(" + info.toString() + " |h:" + getAltura() + ",fb:" + getFatorBal() + ")";
	}
}




















