package ai.transitions;

import ai.states.State;
import main.Dorf;

public class Transition {

	//Conditional Method
	//Extra method to be done on transition?
	State s; //pointer next state
	Dorf d; //Parent dorf
	int priority = 0; //figure me out? for example sleep and starvation is max priority
	public boolean isOpen(){
		return false;
	}
	public Transition(Dorf d){
		this.d = d;
	}
}
