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
		//new Main().intanceMain2();
		new Main().intanceMain2();
	}
	
	public void iniciarJogo() {
		
	}
	
	public void chamarMetodoAbstract() {
		this.iniciarJogo();
	}
	
	public void intanceMain2() {
		new Main2().print1();
	}
	private class Main2{
		public void print1() {
			System.out.println("Chamando meu método");
			
		}
		
	}
	
}
