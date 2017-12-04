package main;

import static main.Stuff.*;

public class Relationship {

	int[] things = new int[OPINIONS_NUM];
	int historicalLiking = 0;
	int inherentLiking = 0;
	Dorf[] d = new Dorf[2];
	public Relationship(Dorf d1, Dorf d2){
		d[0] = d1;
		d[1] = d2;
		d1.relationships.put(d2.ID, this);
		d2.relationships.put(d1.ID, this);

		calculateInherent();
	}
	
	public void calculateInherent(){
		for(int i = 0 ;i < OPINIONS_NUM; i++){
			things[i] = d[0].opinions[i] * d[1].opinions[i]; 
			inherentLiking += things[i];
		}
	}
}