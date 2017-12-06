package ai.transitions;

import main.Dorf;
import main.Entity;
import main.Main;

public class Meet extends Transition{

	Entity e;
	public Meet(Dorf d) {
		super(d);
	}
	
	public boolean isOpen(){
		for(int x = -1; x < 2;x++){
			for(int y = -1; y < 2;y++){
				int col = d.x + x;
				int row = d.y + y;
				Entity e = Main.game.entityMap[col][row];
				if(e instanceof Dorf){
					this.e = e;
					return true;
				}
			}
		}
		return false;
	}
}
