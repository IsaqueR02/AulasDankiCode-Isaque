package oo;

public class Main{
	/*
	Tipo de Classe:
	Private, só pode ser usado na mesma classe
	Public, pode instacia-la em outra classe
	Protected, combina a classe privada com a publica, para fazer isso precisa extender as classes
	e depois instacia-lá com o 'this'
	*/
	
	/*Variavel de retorno:
	Void, Não retorna
	int, retorna em valor int
	char, retorna em valor char
	double, retorna em valor double
	String, retorna em valor String
	*/
	private static/*A classe se tornou estatica*/ double exemplo() {
		return 10/*valor de retorno*/;
		
	}
	private static String exemplo2() {
		return "Guilherme";
	}
	
	public void outroMetodo(int[] n1, String[] nome) {
		System.out.println(n1[0]);
		System.out.println(nome[0]);
	}
	
	public static void main(String[] args) {
		
		/*
		new Player2().nascer();
		Player2 jogador2 = new Player2();
		jogador2.nascer();
		
		Main main = new Main();
		main.exemplo();
		// Com a classe estatica posso chama-la sem instancia-lá
		exemplo();
		*/
		int[] n1 = new int[10];
		n1[0] = 10;
		String[] nomes = new String[2];
		nomes[0] = "Joao";
		new Main().outroMetodo(n1, nomes);
	}
	public void teste() {
		
	}
	
}
