package a11_p03_hash_par;

public class Celula {
	private Object chave;
	private Object valor;

	public Celula(Object chave) {
		super();
		this.chave = chave;
	}

	public Celula(Object chave, Object valor) {
		super();
		this.chave = chave;
		this.valor = valor;
	}

	public Object getChave() {
		return chave;
	}

	public void setChave(Object chave) {
		this.chave = chave;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Celula) {
			Celula outra = (Celula) obj;
			return chave.equals(outra.chave);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return chave.hashCode();
	}

	@Override
	public String toString() {
		return String.valueOf(chave) + ": " + String.valueOf(valor);
	}
}
