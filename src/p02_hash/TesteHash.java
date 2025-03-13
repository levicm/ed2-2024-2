package p02_hash;

import java.util.List;

public class TesteHash {

	public static void main(String[] args) {
		TabelaEspalhamento tabela = new TabelaEspalhamento();
		
		// Testa isVazia
		System.out.println(tabela.isVazia());

		tabela.adiciona("rato", 12);
		tabela.adiciona("roupa", 7);
		tabela.adiciona("roi", 5);
		tabela.adiciona("roma", 20);
		tabela.adiciona("romano", 30);
		tabela.adiciona("sapato", 90);

		// Testa adiciona e busca
		System.out.println(tabela.busca("rato").equals(12));
		System.out.println(tabela.busca("roupa").equals(7));
		System.out.println(tabela.busca("casca") == null);
		System.out.println(tabela.busca("saia") == null);

		// Testa isVazia
		System.out.println(!tabela.isVazia());

		// Testa remove e busca
		tabela.remove("roi");
		System.out.println(tabela.busca("roi") == null);
		
		// Testa chaves
		List chaves = tabela.chaves();
		System.out.println(chaves.size() > 0);
		System.out.println(chaves.contains("rato"));
		System.out.println(chaves.contains("roupa"));
		System.out.println(!chaves.contains("roi"));

	}

}
