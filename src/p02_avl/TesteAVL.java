package p02_avl;

public class TesteAVL {

	public static void main(String[] args) {
		ArvoreAVL arvore = new ArvoreAVL();

		arvore.adiciona(5, 5);
		arvore.adiciona(2, 2);
		arvore.adiciona(8, 8);
		arvore.adiciona(3, 3);
		arvore.adiciona(6, 6);
		arvore.adiciona(7, 7);

		// Testa adiciona e busca
		System.out.println(arvore.busca(8).equals(8));
		System.out.println(arvore.busca(7).equals(7));
		System.out.println(arvore.busca(9) == null);
		System.out.println(arvore.busca(20) == null);

		// Testa remove e busca
		arvore.remove(6);
		System.out.println(arvore.busca(6) == null);

	
		// Testa clone
		ArvoreAVL nova = arvore.clone();
		System.out.println(nova.busca(8).equals(8));
		System.out.println(nova.busca(6) == null);
		System.out.println(nova.busca(5) != null);
		
		
		// Testa limpa
		arvore.limpa();
		System.out.println(arvore.busca(8) == null);
		System.out.println(arvore.busca(7) == null);
		System.out.println(arvore.busca(9) == null);
		System.out.println(arvore.busca(20) == null);
	}

}
