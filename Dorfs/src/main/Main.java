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
	static Game game;
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
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.BLACK);
		for(int c = 0; c < game.w;c++){
			for(int r = 0; r < game.h;r++){
				if(game.entityMap[c][r] != null){
					g.fillRect(c * 10, r * 10, 10, 10);
				}
				else{
					g.drawRect(c * 10, r * 10, 10, 10);
				}
			}
		}
	}
}
