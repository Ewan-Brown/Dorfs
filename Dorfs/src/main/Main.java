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
		Dorf d1 = new Dorf(0,0,"A");
		Dorf d2 = new Dorf(10,10,"B");
		game.dorfs.add(d1);
		game.dorfs.add(d2);
		game.entityMap[0][0] = d1;
		game.entityMap[10][10] = d1;
		Relationship r = new Relationship(d1,d2);
		Conversation c = new Conversation(d1,d2);
		int a = c.getAgreeability();
		while(true){
			m.repaint();
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
