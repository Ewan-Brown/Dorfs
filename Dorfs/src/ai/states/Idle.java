package ai.states;

import java.awt.Color;

import ai.transitions.Meet;
import ai.transitions.Tired;
import main.Dorf;
import main.Stuff;

public class Idle extends State {

	int minMoves = 2;
	int maxMoves = 5;
	public Idle(Dorf d){
		super(d);
		transitions.add(new Tired(d));
		transitions.add(new Meet(d));
	}
	public Color getColor(){
		return Color.BLUE;
	}
	public void update(){
		super.update();
		boolean b = d.tryMove();
		boolean forceChange = (d.moveTime > 5) ? true : 
			(d.moveTime < 2) ? (Stuff.rand.nextBoolean()) : false;
		if (!b || forceChange){
			d.changeDir(Stuff.getRandomDirection());
		}
	}
	
	
	
}
