package a06_abb_p01;

public class Programa {

	public static void main(String[] args) {
		ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
		
		arvore.adiciona(37);
		arvore.adiciona(37);
		arvore.adiciona(20);
		arvore.adiciona(10);
		arvore.adiciona(80);
		arvore.adiciona(100);
		arvore.adiciona(90);
		arvore.adiciona(30);
		arvore.adiciona(180);
		arvore.adiciona(5);
		
		povoar(arvore);
		
		System.out.println(arvore);
		
		NodoABB nodo = arvore.busca(80);
		System.out.println("Busca do 80: " + nodo);

		nodo = arvore.busca(120);
		System.out.println("Busca do 120: " + nodo);

		nodo = arvore.busca(5);
		System.out.println("Busca do 5: " + nodo);
		
		nodo = arvore.busca(52);
		System.out.println("Busca do 52: " + nodo);
	}
	
	private static void povoar(ArvoreBinariaBusca arvore) {
		for (int i = 0; i < 400; ++i) {
			int numero = (int) (Math.random() * 400);
			arvore.adiciona(numero);
		}
	}

}
