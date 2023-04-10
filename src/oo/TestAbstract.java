package oo;

abstract/* classe abstrata, é uma classe que não aparece se não for chamada*/ class TestAbstract extends Enemy{

	
	public void iniciarJogo() {
		System.out.println("Iniciando Jogo....");
	}
	public void inimigo() {
		this.iniciarInimigo();
	}
}

