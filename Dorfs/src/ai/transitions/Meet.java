package ai.transitions;

import ai.states.State;
import ai.states.Talking;
import main.Dorf;
import main.Entity;
import main.Main;

public class Meet extends Transition{

	Dorf e;
	public Meet(Dorf d) {
		super(d);
	}
	public boolean isOpen(){
		for(int x = -1; x < 2;x++){
			for(int y = -1; y < 2;y++){
				if(x == 0 && y == 0){
					continue;
				}
				int col = d.x + x;
				int row = d.y + y;
				if(Main.game.isInBounds(col, row)){
					Entity e = Main.game.entityMap[col][row];
					if(e instanceof Dorf){
						this.e = (Dorf)e;
						return true;
					}
				}
			}
		}
		return false;
	}
	public State getState(){
		return new Talking(d,e);
	}
}
