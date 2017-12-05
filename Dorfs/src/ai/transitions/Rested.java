package ai.transitions;

import ai.states.Idle;
import ai.states.State;
import main.Dorf;

public class Rested extends Transition{
	
	int fatigueThreshold = 1;
	
	public Rested(Dorf d) {
		super(d);
	}
	
	public boolean isOpen(){
		return d.fatigue < fatigueThreshold;
	}
	public State getState() {
		return new Idle(d);
	}
}
