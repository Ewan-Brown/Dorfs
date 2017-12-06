package ai.states;

import java.awt.Color;

import ai.transitions.Found;
import main.Dorf;
import main.Stuff;
import main.Stuff.MovingDirection;

public class Find extends State {
	Dorf target;
	public Find(Dorf d,Dorf t) {
		super(d);
		target = t;
		transitions.add(new Found(d,t));
	}
	public Color getColor(){
		return Color.ORANGE;
	}
	public void update(){
		super.update();
		int xOff = target.x - d.x;
		int yOff = target.y - d.y;
		if(xOff != 0 && yOff != 0){
			if(xOff > yOff){
				yOff = 0;
			}
			else{
				xOff = 0;
			}
		}
		MovingDirection dir = 
				Stuff.getDirection((int)Math.signum(xOff), (int)Math.signum(yOff));
		d.dir = dir;
		if(xOff == 0 && yOff == 0){
			return;
		}
		d.tryMove();
	}
}
