package main;

import java.util.Random;
public class Stuff {
	
	
	public static Random rand = new Random();
	static final int OPINIONS_NUM = 15;
	static final int LIKE_RANGE = 5;
	static final int MIN_CONVO_TOPICS = 2;
	static final int MAX_CONVO_TOPICS = 4;
	public enum MovingDirection{
		UP(0,1),DOWN(0,-1),LEFT(-1,0),RIGHT(1,0),STAND(0,0);
		int x = 0;
		int y = 0;
		MovingDirection(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	}
	public static MovingDirection getDirection(int x, int y){
		if(x == 0){
			if(y == -1){
				return MovingDirection.DOWN;
			}
			if(y == 0){
				return MovingDirection.STAND;
			}
			if(y == 1){
				return MovingDirection.UP;
			}
		}
		else if(y == 0){
			if(x == -1){
				return MovingDirection.LEFT;
			}
			if(x == 0){
				return MovingDirection.STAND;
			}
			if(x == 1){
				return MovingDirection.RIGHT;
			}
		}
		return null;
	}
	public static MovingDirection getRandomDirection(){
		return MovingDirection.values()[rand.nextInt(MovingDirection.values().length)];
	}
	public static double getDistance(GameObject o1, GameObject o2){
		return getDistance(o1.x, o1.y, o2.x, o2.y);
	}
	public static double getDistance( double x1,  double y1,  double x2,  double y2) {
		return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
	}
}
