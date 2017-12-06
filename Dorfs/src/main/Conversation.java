package main;

import static main.Stuff.LIKE_RANGE;
import static main.Stuff.MAX_CONVO_TOPICS;
import static main.Stuff.MIN_CONVO_TOPICS;
import static main.Stuff.OPINIONS_NUM;
import static main.Stuff.rand;

import java.util.ArrayList;

public class Conversation {

	ArrayList<Integer> topics = new ArrayList<Integer>();
	/*Array of numbers pointing to different 'things' that the convo is about.
	* Idea:
	* Topics chosen by random, if both dwarves like it then they have happy convo, if they disagree on the thing then they 
	* may get upset and have a fight. 
	* Also if one dwarf has a high 'persuasion' skill he can convince the other to side with him and change his inherent view on that thing.
	*
	*/
	int happiness = 0; //Each update this increases or decreases depending on agreeability and chance.
	Relationship relationship; //Just a pointer;
	Dorf[] d = new Dorf[2]; //Pointers to dwarves
	public Conversation(Dorf d1, Dorf d2){
		d[0] = d1;
		d[1] = d2;
		relationship = d1.relationships.get(d2.ID);
	    setTopics();
		happiness = getAgreeability() + relationship.historicalLiking;
	}
	public void setTopics(){
		int n = rand.nextInt(MAX_CONVO_TOPICS + 1 - MIN_CONVO_TOPICS) + MIN_CONVO_TOPICS;
		for(int i = 0; i < n;){
			int f = rand.nextInt(OPINIONS_NUM);
			if(!topics.contains(f)){
				topics.add(f);
				i++;
			}
			
		}
	}
	//Return if convo is over
	public boolean update(){
		int a = getAgreeability();
		happiness += Math.signum(a);
		return false;
	}
	public void endConversation(){
		relationship.historicalLiking += happiness;
	}
	public int getAgreeability(){
		int a = 0;
		for(int i = 0; i < topics.size();i++){
			a += relationship.things[topics.get(i)];
		}
		return a;
	}
	public int getMax(){
		return topics.size() * LIKE_RANGE * LIKE_RANGE;
	}
	
}
