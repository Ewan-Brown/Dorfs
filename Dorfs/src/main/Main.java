package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Game game;
	public static void main(String[] args){
		game = new Game();
		JFrame f = new JFrame();
		Main m = new Main();
		f.add(m);
		f.setSize(500, 500);
		f.setVisible(true);
		f.setFocusable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Automate this
//		Relationship r = new Relationship(d1,d2);
//		Conversation c = new Conversation(d1,d2);
		while(true){
			m.repaint();
			game.update();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	int size = 7;
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.BLACK);
		for(int c = 0; c < game.w;c++){
			for(int r = 0; r < game.h;r++){
				Entity e = game.entityMap[c][r];
				if(e != null){
					g.setColor(e.getColor());
					g.fillRect(c * size, r * size, size, size);
				}
				else{
					g.setColor(Color.WHITE);
					g.drawRect(c * size, r * size, size, size);
				}
			}
		}
	}
}
