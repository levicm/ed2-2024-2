package a04_arvore_binaria_p01;

public class Programa {

	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();

		Nodo raiz = arvore.criaRaiz("-");

		Nodo div1 = arvore.adicionaEsquerdo(raiz, "/");

		Nodo prod1 = arvore.adicionaEsquerdo(div1, "x");
		Nodo mais2 = arvore.adicionaDireito(div1, "+");

		Nodo mais3 = arvore.adicionaEsquerdo(prod1, "+");
		arvore.adicionaDireito(prod1, 3);

		arvore.adicionaEsquerdo(mais3, 3);
		arvore.adicionaDireito(mais3, 1);

		Nodo menos2 = arvore.adicionaEsquerdo(mais2, "-");
		arvore.adicionaDireito(mais2, 2);

		arvore.adicionaEsquerdo(menos2, 9);
		arvore.adicionaDireito(menos2, 5);

		Nodo mais1 = arvore.adicionaDireito(raiz, "+");
		Nodo prod2 = arvore.adicionaEsquerdo(mais1, "x");
		arvore.adicionaDireito(mais1, 6);

		arvore.adicionaEsquerdo(prod2, 3);
		Nodo menos3 = arvore.adicionaDireito(prod2, "-");

		arvore.adicionaEsquerdo(menos3, 7);
		arvore.adicionaDireito(menos3, 4);

		System.out.println(arvore);
		
		ExpressaoVisitante expressao = new ExpressaoVisitante();
		arvore.travessiaPosOrdem(expressao);
		System.out.println(expressao.getResultado());
	}

}








