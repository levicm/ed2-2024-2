package a04_arvore_binaria_p01;

import java.util.Stack;

public class ExpressaoVisitante implements Visitante {

	private Stack pilha = new Stack();

	@Override
	public void visita(Nodo nodo) {
		Object info = nodo.getInfo();
		System.out.println("Visitando " + info);
		Integer valor = null;
		if (info instanceof Number) {
			System.out.println("É um valor, empilhando...");
			pilha.push(info);
		} else if (info instanceof String) {
			System.out.println("É uma string!");
			Integer direita = (Integer) pilha.pop();
			System.out.println("Desempilhando "+ direita);
			Integer esquerda = (Integer) pilha.pop();
			System.out.println("Desempilhando "+ esquerda);
			System.out.println("Operando...");
			if ("-".equals(info)) {
				valor = esquerda - direita;
			} else if ("+".equals(info)) {
				valor = esquerda + direita;
			} else if ("/".equals(info)) {
				valor = esquerda / direita;
			} else if ("x".equals(info)) {
				valor = esquerda * direita;
			}
			System.out.println("Empilhando "+ valor);
			pilha.push(valor);
		}
	}
	
	public Integer getResultado() {
		return (Integer) pilha.peek();
	}

}








