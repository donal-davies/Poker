/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;
import poker.resources.AI;
import poker.resources.Card;
import poker.resources.Player;

/**
 *
 * @author donal.davies
 */
public class Game {
    public ArrayList<Player> players = new ArrayList<>();
    
    public int curPool; //The cash pool to be given to the winner
    public Card[] dealerHand; //The cards at the centre of the table
    public int dealer; //The dealer for the round
    public int curPlayer; //The currently active player
    public int highestBet; //Stores the highest current bet (bets cannot be lower than this amount)
    
    public Game(int playerCount){
        curPool = 0;
        dealer = 0;
        curPlayer = 3;
        
        createPlayers(playerCount); //Fill the list of players
    }
    
    public void newGame(){ //Start a new game at the end of a round
        for(Player p:players){ //Reset the current values for each player
            p.hand = new Card[2];
            p.curBet=0;
        }
        
        Poker.deck.refresh(); //Set every card to unused
        dealerHand = new Card[5]; //Clear the dealer cards
        
        dealer=dealer<players.size()?dealer+1:0; //Move the dealer chip one player clockwise
        curPlayer=dealer<players.size()?dealer+1:0; //Set the current player to whoever is clockwise
                                                      //from the dealer
    }
    
    public void incrementPlayer(){
        curPlayer = curPlayer<players.size()?curPlayer+1:0;
    }
    
    public void runGame(){
        //The first two players to the left of the dealer put in blinds
        //(Small bets to start off the pool)
        doBet(players.get(curPlayer),Poker.CONST_CREDITS/100);
        incrementPlayer();
        doBet(players.get(curPlayer),Poker.CONST_CREDITS/50);
        incrementPlayer();
        
        if(players.get(curPlayer) instanceof AI){
            //DO AI TURN STUFF HERE
        }else{
            doUserTurn();
        }
    }
    
    public void doUserTurn(){
        //TODO
    }
    
    public void createPlayers(int pCount){
        players.add(new Player("You")); //Adds the user to the list
        for(int i=0;i<pCount;i++){
            players.add(new AI(Poker.nameGen.genName())); //Adds each AI with a generated name
        }
    }
    
    /**
     * Deals two cards to each player
     **/
    public void dealCards(){
        //TO DO: Add animation
        for(Player p:players){
            Card first = Poker.deck.dealCard();
            Card second = Poker.deck.dealCard(); //Deal two cards from the deck
            if(p.name.equals("You")){ //If they are being dealt to the player, output to log
                //DO CONSOLE OUTPUT
            }
            p.hand[0] = first; //Add the cards to the player's hand
            p.hand[1] = second;
        }
    }
    
    /**
     * Removes credits from the selected player and puts it into their pool
     */
    public void doBet(Player p,int bet){
        p.credits-=bet;
        p.curBet+=bet;
        if(bet>highestBet)highestBet=bet;
    }
}
