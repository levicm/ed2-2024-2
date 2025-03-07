package a11_p01_avl;

public class Programa {

	public static void main(String[] args) {
		ArvoreAVL arvore = new ArvoreAVL();

		arvore.adiciona(5);
		arvore.adiciona(2);
		arvore.adiciona(8);
//		arvore.adiciona(1);
		arvore.adiciona(3);
		arvore.adiciona(7);

		arvore.adiciona(10);
		arvore.adiciona(6);
		arvore.adiciona(9);
		arvore.adiciona(11);
		System.out.println(arvore);
			
		System.out.println(arvore.busca(8));
		System.out.println(arvore.busca(7));
		System.out.println(arvore.busca(5));
		System.out.println(arvore.busca(20));

		System.out.println("=== remoções:");
		System.out.println(arvore);
		arvore.remove(6);
		System.out.println(arvore);
		arvore.remove(2);
		System.out.println(arvore);
		arvore.remove(5);
		System.out.println(arvore);
	}

}
