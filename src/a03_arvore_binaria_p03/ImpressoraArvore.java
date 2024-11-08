package a03_arvore_binaria_p03;

public class ImpressoraArvore implements Visitante {

	@Override
	public void visita(Nodo nodo) {
		System.out.println(nodo.getInfo());
	}

}
