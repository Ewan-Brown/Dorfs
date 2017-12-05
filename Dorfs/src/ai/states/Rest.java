package ai.states;

import java.awt.Color;

import ai.transitions.Rested;
import main.Dorf;

public class Rest extends State{
	public Rest(Dorf d){
		super(d);
		transitions.add(new Rested(d));
	}
	public void update(){
		super.update();
		d.fatigue -= 0.5;
	}
	public boolean canMove(){
		return false;
	}
	public Color getColor(){
		return Color.BLACK;
	}
}
