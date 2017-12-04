package main;

import java.util.ArrayList;

public class Game {
	//ENtities are anything that moves.
	//TIles are static spots
	int w = 100;
	int h = 100;
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
	}
	public void moveEntity(Entity e, int x, int y){
		e.x = x;
		e.y = y;
		entityMap[x][y] = e;
	}
	public boolean isEmpty(int x, int y){
		return entityMap[x][y] == null;
	}
}
