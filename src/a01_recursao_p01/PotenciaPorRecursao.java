package a01_recursao_p01;

public class PotenciaPorRecursao {

	public static void main(String[] args) {
		System.out.println(potencia(2, 4));
		System.out.println(potencia(3, 3));
	}

	private static long potencia(int x, int n) {
		if (n == 1) {
			// Condição de parada
			return x;
		} else {
			// Regra geral
			return x * potencia(x, n - 1);
		}
	}
	
	
}
