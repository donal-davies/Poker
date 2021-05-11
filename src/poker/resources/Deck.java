/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.resources;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author donal.davies
 */
public class Deck {
    public ArrayList<Card> cards; //List of available cards
    public ArrayList<Card> used; //List of dealt cards
    
    public Deck(){
        cards = new ArrayList<>();
        used = new ArrayList<>();
        this.initDeck();
    }
    
    public void initDeck(){ //Creates the deck
        String[] suits = {"Diamonds","Clubs","Hearts","Spades"};
        int count = 0;
        //Loops through each suit and 13 values for each suit to generate 52 cards
        for(String s:suits){
            for(int i=0;i<13;i++){
                String name = i==0?"Ace":i==10?"Jack":i==11?"Queen":i==12?"King":""+i;
                cards.add(new Card(s,i+1,name));
                count++;
            }
        }
    }
    
    /**
     * Move all cards from the used list to the main pile at the 
     * start of a new game
     */
    public void refresh(){
        ArrayList<Card> temp = new ArrayList<>(used);
        for(Card c:temp){
            cards.add(c);
            used.remove(c);
        }
    }
    
    /**
     * Draw a random card and move it to the used pile
     * @return The drawn card
     */
    public Card dealCard(){
        Random r = new Random();
        Card c = cards.get(r.nextInt(52));
        
        used.add(c);
        cards.remove(c);
        
        return c;
    }
}
