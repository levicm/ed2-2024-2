package a11_p03_hash_par;

public class Programa {

	public static void main(String[] args) {
		TabelaEspalhamento tabela = new TabelaEspalhamento();

		String palavra1 = "Casca";
		String palavra2 = "Banana";
		String palavra3 = "Laranja";
		tabela.adiciona(palavra1);
		tabela.adiciona(palavra2);

		for (int i = 0; i < 26; ++i) {			
			tabela.adiciona(geraPalavra());
		}

		System.out.println(tabela);

		System.out.println(tabela.busca(palavra1));
		System.out.println(tabela.busca(palavra2));
		System.out.println(tabela.busca(palavra3));
		
		tabela.remove(palavra2);
		System.out.println(tabela.busca(palavra2));
	}

	private static String geraPalavra() {
		StringBuilder sb = new StringBuilder();
		int tamanhoMaximo = 10;
		int qtdLetras = (int) (Math.random() * tamanhoMaximo) + 1;
		for (int i = 0; i < qtdLetras; ++i) {
			char caracter = (char) ((Math.random() * 26) + 65);
			sb.append(caracter);
		}
		return sb.toString();
	}

}
