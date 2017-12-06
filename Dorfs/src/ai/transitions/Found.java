package ai.transitions;

import ai.states.Idle;
import ai.states.State;
import main.Dorf;
import main.Stuff;

public class Found extends Transition{
	Dorf target = null;
	public Found(Dorf d, Dorf t) {
		super(d);
		target = t;
		
	}
	public boolean isOpen(){
		return Stuff.getDistance(d, target) < 2;
	}
	public State getState() {
		return new Idle(d);
	}
}
