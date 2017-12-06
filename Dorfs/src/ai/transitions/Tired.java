package ai.transitions;

import ai.states.Rest;
import ai.states.State;
import main.Dorf;

public class Tired extends Transition{
	double fatigueThreshold = 20;
	public Tired(Dorf d){
		super(d);
	}
	public boolean isOpen(){
		if(d.fatigue > fatigueThreshold){
			return true;
		}else return false;
	}
	public State getState(){
		return new Rest(d);
	}
}
