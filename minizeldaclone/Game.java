package minizeldaclone;
//Importando Bibliotecas Java
/* Para puxar cores para a tela do jogo
*/import java.awt.Canvas;
/* Para armazenar cores
*/import java.awt.Color;
/* Definir a Tela de Jogo
*/import java.awt.Dimension;
/* Definição da Tela
*/import java.awt.Graphics;
/* Definir as teclas do teclado
*/import java.awt.event.KeyEvent;
/* Armazenar as as teclas do teclado
*/import java.awt.event.KeyListener;
/* Importar imagens jpg, png e jpeg
*/import java.awt.image.BufferStrategy;
/* Biblioteca de armazenamento de dados
*/import java.util.ArrayList;
/* Biblioteca de listamento de dados
*/import java.util.List;
/* Biblioteca de Animação
*/import javax.swing.JFrame;

//Base do programa
public class Game extends Canvas implements Runnable, KeyListener{

	/**
	 * 
	 */
	
	//Tamanho da tela
	public static int WIDTH = 640, HEIGHT = 480;
	public static int SCALE = 3;
	//Classe do jogador
	public static Player jogador;
	//O Mundo virtual que criei
	public World Mundo;
	//Criando um armazenamento de dados para a spawnar inimigo
	public List<Inimigo> inimigos = new ArrayList <Inimigo>();
	
	// Classe Jogador
	public Game() {
		//Leitura de dados
		this.addKeyListener(this);
		//Definindo dimensões
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		//Importando imagens
		new Spritesheet();
		//Criando jogador
		jogador = new Player(32,32);
		//Criando um Mundo
		Mundo = new World();
		//Criando Inimigos
		inimigos.add(new Inimigo(32,32));
		
		inimigos.add(new Inimigo(32,200));
	}
	//Definir os movimentos
	public void tick() {
		//Definir os movimentos do jogador
		jogador.tick();
		//Definir os movimentos do inimigos
		for(int i = 0;i < inimigos.size(); i++) {
			inimigos.get(i).tick();
		}
	}
	//Classe de Renderização
	public void render() {
		//Renderiza imagens importadas
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			//Cria as imagens
			this.createBufferStrategy(3);
			return;
		}
		//Renderizar graficos
		Graphics g = bs.getDrawGraphics();
		//Renderizar cores
		g.setColor(new Color(0,135,13));
		//Renderizar escala
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		//Renderizar jogador
		jogador.render(g);
		//Definir tamanho e Renderizar inimigos
		for(int i = 0;i < inimigos.size(); i++) {
			inimigos.get(i).render(g);
		}
		//Renderizar Mundo
		Mundo.render(g);
		//Renderizar Tela
		bs.show();
	}
	
	public static void main(String[] args) {
		Game jogo = new Game();
		JFrame frame = new JFrame();
		
		frame.add(jogo);
		frame.setTitle("Mini Zelda");
		
		frame.pack();
		
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		new Thread(jogo).start();
	}
	@Override
	public void run() {
		
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			jogador.right = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			jogador.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			jogador.shoot = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			jogador.up = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			jogador.down = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			jogador.right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			jogador.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			jogador.up = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			jogador.down = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
