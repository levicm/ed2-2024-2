package a08_arvore_trie_p01;

public class Programa {

	public static void main(String[] args) {
		ArvoreTrie arvore = new ArvoreTrie();
		
		arvore.adiciona("rato", 12);
		arvore.adiciona("roupa", 7);
		arvore.adiciona("roi", 5);
		arvore.adiciona("roma", 20);
		arvore.adiciona("romano", 30);
		arvore.adiciona("sapato", 90);
		
		System.out.println(arvore);
		
		System.out.println(arvore.busca("roi"));
		System.out.println(arvore.busca("roma"));

		System.out.println(arvore.busca("roeu"));
		System.out.println(arvore.busca("ro"));
		System.out.println(arvore.busca("maca"));
		
		System.out.println("-------");
		arvore.remove("roma");
		System.out.println(arvore.busca("roma"));
		
		System.out.println("-------");
		System.out.println(arvore);

		arvore.remove("roi");
		System.out.println("-------");
		System.out.println(arvore);
		arvore.remove("romano");
		System.out.println("-------");
		System.out.println(arvore);
	}

}
