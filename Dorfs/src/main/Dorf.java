
package main;

import static main.Stuff.*;

import java.util.HashMap;
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
	HashMap<Integer,Relationship> relationships = new HashMap<Integer,Relationship>();
	int[] opinions = new int[OPINIONS_NUM];
	int ID;
	String name;
	State state;
	public Dorf(int x, int y, String n){
		
		
		super(x,y);
		name = n;
		for(int i = 0 ; i < opinions.length;i++){
			opinions[i] = rand.nextInt(LIKE_RANGE * 2 + 1) - LIKE_RANGE;
		}
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
