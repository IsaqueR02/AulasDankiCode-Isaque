package oo;


//Metodo construtor
// É quando eu peço para executar uma ação
public class Main{
/*Atributos
 * São varíaveis que pertecem a classe
 * */
	private String nome = "Guilherme";
	private int[] numeros;
	//Declarar constantes
	public static final int VIDA_MAXIMA = 100;

	public Main() {
		/*adicionei atributos ao metodo*/numeros = new int[100];
	}
	//Como adicionei um metodo publico, consigo usar um atributo privado
	public String getNome() {
		return nome;
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		System.out.println(Main.VIDA_MAXIMA);
	}
	
}

