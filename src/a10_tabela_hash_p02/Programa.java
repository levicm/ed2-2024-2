package a10_tabela_hash_p02;

public class Programa {

	public static void main(String[] args) {
		TabelaEspalhamento tabela = new TabelaEspalhamento();

		for (int i = 0; i < 26; ++i) {
			tabela.adiciona(geraPalavra());
		}

		System.out.println(tabela);
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
