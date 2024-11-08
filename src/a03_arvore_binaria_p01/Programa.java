package a03_arvore_binaria_p01;

public class Programa {

	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();

		Nodo raiz = arvore.criaRaiz("+");

		Nodo prod = arvore.adicionaEsquerdo(raiz, "*");
		Nodo divi = arvore.adicionaDireito(raiz, "/");
		Nodo a = arvore.adicionaEsquerdo(prod, "A");
		Nodo b = arvore.adicionaDireito(prod, "B");
		Nodo c = arvore.adicionaEsquerdo(divi, "C");
		Nodo d = arvore.adicionaDireito(divi, "D");
		

		System.out.println(arvore);
	}

}
