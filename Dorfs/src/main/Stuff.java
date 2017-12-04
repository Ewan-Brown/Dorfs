package main;

import java.util.Random;

public class Stuff {
	
	
	static Random rand = new Random();
	static final int OPINIONS_NUM = 15;
	static final int LIKE_RANGE = 5;
	static final int MIN_CONVO_TOPICS = 2;
	static final int MAX_CONVO_TOPICS = 4;
	
	public enum Direction{
		UP(0,1),DOWN(0,-1),LEFT(-1,0),RIGHT(1,0),STAND(0,0);
		int x = 0;
		int y = 0;
		Direction(int x, int y){
			this.x = x;
			this.y = y;
		}

	}

}
