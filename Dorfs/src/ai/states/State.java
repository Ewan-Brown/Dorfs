package ai.states;

import java.awt.Color;
import java.util.ArrayList;

import ai.transitions.Transition;
import main.Dorf;


public abstract class State {	
	//Entry point
	//Exit points (cancellations/finishes)
	//List of transitions
	//DRAW ME OUT BOIO
	//Substates - figure that one out boy?
	ArrayList<State> substates; //Substates, if none then this is empty (duh) SHould this be a separate class? 
	ArrayList<Transition> transitions = new ArrayList<Transition>(); //Exits!
	Dorf d; //Parent pointer
	public Color getColor(){
		return Color.BLACK;
	}
	public void update(){
		checkExits();
		//main loop!
	}
	public void checkExits(){ //Check transition exits and exit with the one that has priority
		for(Transition t : transitions){
			if(t.isOpen()){ //TODO Implement priority system
				t.onTransition();
				switchState(t.getState());
			}
		}
	}
	public boolean canMove(){
		return true;
	}
	public void onExit(){ //General exit

	}
	public void onEntry(){ //General entry

	}
	public State (Dorf d){
		this.d = d;
	}
	public void switchState(State s){
		d.state.onExit();
		d.state = s;
		s.onEntry();
	}
}
