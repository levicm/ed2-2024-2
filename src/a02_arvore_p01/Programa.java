package a02_arvore_p01;

public class Programa {

	public static void main(String[] args) {
		Nodo veiculo = new Nodo("Veiculo");

		Nodo aereo = new Nodo("Aereo");
		Nodo terrestre = new Nodo("Terrestre");
		Nodo aquatico = new Nodo("Aquatico");
		
		veiculo.adiciona(aereo);
		veiculo.adiciona(terrestre);
		veiculo.adiciona(aquatico);
		
		Nodo aeAviao = new Nodo("Avião");
		Nodo aeHeli = new Nodo("Helicóptero");
		aereo.adiciona(aeAviao);
		aereo.adiciona(aeHeli);
		
		Nodo aqMotor = new Nodo("A Motor"); 
		Nodo aqVela = new Nodo("A Vela"); 
		Nodo aqRemo = new Nodo("A Remo");
		
		aquatico.adiciona(aqMotor);
		aquatico.adiciona(aqVela);
		aquatico.adiciona(aqRemo);
		
		
		System.out.println(veiculo);
	}

}
