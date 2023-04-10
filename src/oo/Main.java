package oo;

public class Main extends TestAbstract{

	public static void main(String[] args) {
		/*Player jogador = new Player();
		jogador.iniciarJogador();
		
		Enemy inimigo = new Enemy();
		inimigo.iniciarInimigo();
		
		Player jogador2 = new Player();
		jogador2.iniciarJogador();
		new Player().iniciarJogador();
		*/

		//new Main().instanceMain2();
		new Main().instanceMain2();
		new Main().chamarMetodoAbstract();
	}
	
	public void chamarMetodoAbstract() {
		//como o próprio nome da classe diz chamar método abstrato
		iniciarJogo();
		iniciarJogador();
		inimigo();
	}
	public void instanceMain2() {
	new Main2().print1();	
	}
	
	private class Main2{
		public void print1() {
			System.out.println("Chamando metodo");
		}
	}
	
	
}
	}
	
}
