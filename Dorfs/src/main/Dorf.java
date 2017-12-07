
package main;

import static main.Stuff.LIKE_RANGE;
import static main.Stuff.OPINIONS_NUM;
import static main.Stuff.rand;

import java.awt.Color;
import java.util.HashMap;

import ai.states.Idle;
import ai.states.State;
public class Dorf extends Entity{
	//TODO Better name than 'things' please
	/*Array of 10 integers, each cell being a different concept, each value being his feelings.
	*  -1 = Doesn't like
	*   0 = Doesn't care
	*   1 = Likes
	*   multiply to get 'overall' bonus - Dorfs like similar dorfs and hate opposite dorfs
	*   A * B
	*   0    0  =  0  
	*   1   -1  = -1  -
	*   1    0  =  0
	*   1    1  =  1  +
	*   
	*  -1   -1  =  1  +
	*  -1    0  =  0
	*  -1    1  = -1  -
	*/	
	public double fatigue = 0;
	public HashMap<Integer,Relationship> relationships = new HashMap<Integer,Relationship>();
	public int[] opinions = new int[OPINIONS_NUM];
	public int ID;
	public String name;
	public State state;
	public Dorf(int x, int y, String n){
		super(x,y);
		state = new Idle(this);
		changeDir(Stuff.getRandomDirection());
		name = n;
		for(int i = 0 ; i < opinions.length;i++){
			opinions[i] = rand.nextInt(LIKE_RANGE * 2 + 1) - LIKE_RANGE;
		}
	}
	public boolean hasRelationshipWith(Dorf target){
		if(relationships.containsKey(target.ID)){
			return true;
		}
		else{
			relationships.put(target.ID, new Relationship(this,target));
		}
		return false;
	}
	public void update(){
		state.update();
	}
	public Color getColor(){
		return state.getColor();
	}
	public void onMove(int x, int y){
		super.onMove(x,y);
		fatigue += Math.sqrt(x*x + y*y);
	}
	public boolean ableTomove(){
		return state.canMove();
	}
	public void printThings(){
		if(opinions[0] > 0) System.out.print(" "); // Aesthetic spacer for negatives
		for(int i = 0; i < OPINIONS_NUM;i++){
			int f = opinions[i];
			String s = "  ";
			if(i < OPINIONS_NUM - 1 && opinions[i + 1] < 0) s = " "; // Aesthetic spacer for negatives
			System.out.print(f + s);
		}
		System.out.println();
	}
	
}
