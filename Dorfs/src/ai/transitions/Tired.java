package ai.transitions;

import ai.states.Idle;
import ai.states.State;
import main.Dorf;

public class Tired extends Transition{
	double fatigueThreshold = 10;
	public Tired(Dorf d){
		super(d);
	}
	public boolean isOpen(){
		if(d.fatigue > fatigueThreshold){
			return true;
		}else return false;
	}
	public State newState(){
		return new Idle(d);
	}
}
