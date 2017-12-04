package main;

import java.util.ArrayList;

public class Game {
	//ENtities are anything that moves.
	//TIles are static spots
	int w = 100;
	int h = 100;
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
		entityMap[x][y] = d;
		dorfs.add(d);
	}
	public void update(){
		for(Dorf d : dorfs){
			d.update();
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
