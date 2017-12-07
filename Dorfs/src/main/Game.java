package main;

import java.util.ArrayList;

import ai.states.Find;
import ai.states.Idle;

public class Game {
	//Entities are anything that moves.
	//Tiles are static spots
	int w = 20;
	int h = 20;
	int idCounter = 0;
	public Entity[][] entityMap = new Entity[w][h];
	public ArrayList<Dorf> dorfs = new ArrayList<Dorf>();
	//Main array, each dwarf points to its own in this
	public ArrayList<Relationship> relationships = new ArrayList<Relationship>();
	public Game(){
		for(int x = 0; x < w;x++){
			for(int y = 0; y < h;y++){
				entityMap[x][y] = null;
			}
		}
		for(int i = 0; i < 10;i++){
			addDorf(Stuff.rand.nextInt(w),Stuff.rand.nextInt(h));
		}
	}
	public void addDorf(int x, int y){
		Dorf d = new Dorf(x,y,idCounter+"");
		d.ID = idCounter;
		idCounter++;
		entityMap[x][y] = d;
		dorfs.add(d);
	}
	public void update(){
		for(int i = 0; i < dorfs.size();i++){
			Dorf d = dorfs.get(i);
//			System.out.println(d.relationships.size());
			d.update();
			if(d.state instanceof Idle){
				if(Stuff.rand.nextDouble() < 0.01){
//					Dorf d2 = dorfs.get((i + 1) % dorfs.size());
//					d.state.switchState(new Find(d,d2));
				}
			}
		}
	}
	public void moveEntity(Entity e, int x, int y){
		int oldX = e.x;
		int oldY = e.y;
		e.x = x;
		e.y = y;
		entityMap[x][y] = e;
		entityMap[oldX][oldY] = null;
	}
	public boolean isOccupied(int x, int y){
		return entityMap[x][y] != null;
	}
	public boolean isInBounds(int x, int y){
		return (x >= 0 && y >= 0 && x < w && y < h);
	}
	public boolean isLegalMove(int x, int y){
		return(isInBounds(x,y) && !(isOccupied(x,y)));
	}
}
