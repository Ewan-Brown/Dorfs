package ai.states;

import main.Dorf;
import main.Relationship;

public class Talking extends State{
	Dorf target;
	int updates = 0;
	Relationship r;
	public Talking(Dorf d,Dorf t) {
		super(d);
		target = t;
	}
	public void onEntry(){
		
	}
	public void update(){
		super.update();
		updates++;
		
	}
}
