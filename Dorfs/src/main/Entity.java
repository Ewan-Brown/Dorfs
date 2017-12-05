package main;

import main.Stuff.Direction;

public class Entity extends GameObject{

	private Direction dir;
	public int moveTime = 0;
	public Entity(int x, int y){
		super(x,y);
	}
	public void changeDir(Direction dir){
		this.dir = dir;
		moveTime = 0;
	}
	public boolean ableToMove(){
		return true;
	}
	public boolean tryMove(){
		if(canMove()){
			Main.game.moveEntity(this, dir.x + x, dir.y + y);
			onMove(dir.x, dir.y);
			return true;
		}
		else{
			return false;
		}
	}
	public void onMove(int x, int y){
		moveTime += 1;
	}
	public boolean canMove(){
		return Main.game.isLegalMove(dir.x + x, dir.y + y) && ableToMove();
	}
}
