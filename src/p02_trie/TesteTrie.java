package p02_trie;

public class TesteTrie {

	public static void main(String[] args) {
		ArvoreTrie arvore = new ArvoreTrie();

		arvore.adiciona("rato", 12);
		arvore.adiciona("roupa", 7);
		arvore.adiciona("roi", 5);
		arvore.adiciona("roma", 20);
		arvore.adiciona("romano", 30);
		arvore.adiciona("sapato", 90);

		// Testa adiciona e busca
		System.out.println(arvore.busca("rato").equals(12));
		System.out.println(arvore.busca("roupa").equals(7));
		System.out.println(arvore.busca("casca") == null);
		System.out.println(arvore.busca("saia") == null);

		// Testa remove e busca
		arvore.remove("roi");
		System.out.println(arvore.busca("roi") == null);

		// Testa contemValor
		System.out.println(!arvore.contemValor(6));
		System.out.println(arvore.contemValor(12));
		
		// Testa adicionaTodos
		ArvoreTrie nova = new ArvoreTrie();
		nova.adiciona("aracaju", 12);
		nova.adiciona("itabaiana", 7);
		nova.adiciona("frei paulo", 5);
		arvore.adicionaTodos(nova);
		System.out.println(arvore.busca("aracaju").equals(12));
		System.out.println(arvore.busca("itabaiana").equals(7));
		System.out.println(arvore.busca("frei paulo").equals(5));
	}

}
