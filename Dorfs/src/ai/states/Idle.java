package ai.states;

import ai.transitions.Tired;
import ai.transitions.Transition;
import main.Dorf;
import main.Stuff;

public class Idle extends State {

	int minMoves = 2;
	int maxMoves = 5;
	public Idle(Dorf d){
		super(d);
		transitions.add(new Tired(d));
	}
	public void update(){
		boolean b = d.tryMove();
		boolean forceChange = (d.moveTime > 5) ? true : 
			(d.moveTime < 2) ? (Stuff.rand.nextBoolean()) : false;
		if (!b || forceChange){
			d.changeDir(Stuff.getRandomDirection());
		}
	}
	public void checkTransitions(){
		for(Transition t : transitions){
			
		}
	}
	
	
}
