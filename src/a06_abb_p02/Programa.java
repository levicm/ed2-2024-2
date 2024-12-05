package a06_abb_p02;

public class Programa {

	public static void main(String[] args) {
		ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
		
		arvore.adiciona(37);
		arvore.adiciona(20);
		arvore.adiciona(10);
		arvore.adiciona(80);
		arvore.adiciona(100);
		arvore.adiciona(90);
		arvore.adiciona(30);
		arvore.adiciona(180);
		arvore.adiciona(5);
		
		System.out.println(arvore);
		
		arvore.remove(10);
		System.out.println(arvore);
		
		arvore.remove(5);
		System.out.println(arvore);

		arvore.remove(100);
		System.out.println(arvore);

		arvore.remove(37);
		System.out.println(arvore);
	}
	
}
