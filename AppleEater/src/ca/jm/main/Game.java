
package ca.jm.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 *
 * @author Jack Jack Attack
 */
public class Game extends Canvas implements Runnable{

    
    private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	public static final int SCALE = 2;
	public static final String TITLE = "Apple Eater - Better Graphics";
	
	public static int FPS;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        private int pixels[] = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
        private Screen screen;
	
	private boolean running = false;
	private Thread thread;
        
	
	public Game() {
		new GameWindow(WIDTH, HEIGHT, SCALE, TITLE, this);
	}
	
	public void init() {
	}
	
	public synchronized void start() {
		if (running)
			return;
                screen = new Screen(WIDTH, HEIGHT);
		thread = new Thread(this);
		running = true;
		thread.start();
			
	}
	
	public synchronized void stop() {
		running = false;
		if (thread != null) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		
		init();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				FPS = frames;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	public void tick() {
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
                screen.render();
                for (int i = 0; i < screen.pixels.length; i ++) {
                    pixels[i] = screen.pixels[i];
                }
		// ///////////////////////////////
		// DRAW HERE
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		// ///////////////////////////////
		g.dispose();
		bs.show();
	}
	public static void clamp(int value, int min, int max) {
		if (value < min) {
			value = min;
		}
		
		if (value > max) {
			value = max;
		}
	}
	
	public static void main(String args[]) {
		Game game = new Game();
		System.out.println("WIDTH: " + game.getWidth() + " HEIGHT: " + game.getHeight());
		game.start();
		game.requestFocus();
	}
    
}
