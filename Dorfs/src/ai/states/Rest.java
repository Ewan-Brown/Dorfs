package ai.states;

import main.Dorf;

public class Rest extends State{
	public Rest(Dorf d){
		super(d);
	}
	public void update(){
		d.fatigue += 0.5;
	}
}
