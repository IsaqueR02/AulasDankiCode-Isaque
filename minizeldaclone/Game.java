package minizeldaclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{

	/**
	 * 
	 */
	public static int WIDTH = 640, HEIGHT = 480;
	public static int SCALE = 3;
	public Player jogador;
	public World Mundo;
	public List<Inimigo> inimigos = new ArrayList <Inimigo>();
	
	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		new Spritesheet();
		
		jogador = new Player(32,32);
		
		Mundo = new World();
		
		inimigos.add(new Inimigo(32,32));
	}
	
	public void tick() {
		jogador.tick();
		
		for(int i = 0;i < inimigos.size(); i++) {
			inimigos.get(i).tick();
		}
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(0,135,13));
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		
		jogador.render(g);
		for(int i = 0;i < inimigos.size(); i++) {
			inimigos.get(i).render(g);
		}
		
		Mundo.render(g);
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
