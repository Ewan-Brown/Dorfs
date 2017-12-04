package ai.transitions;

import main.Dorf;

public class Rested extends Transition{
	
	int fatigueThreshold = 1;
	
	public Rested(Dorf d) {
		super(d);
	}
	
	public boolean isOpen(){
		return d.fatigue < fatigueThreshold;
	}
	
}
