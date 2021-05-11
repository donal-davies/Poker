/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.resources;

import java.util.ArrayList;
import poker.Poker;

/**
 *
 * @author donal.davies
 */
public class Player{
    public Card[] hand; //The two cards held by the player
    public int credits; //The credits currently held by the player
    public int curBet; //The bet waiting to move to the pool
    public String name; //The player's name ("You" for the user, a randomly generated name for AI)
    
    public Player(String n){
        hand = new Card[2];
        credits = Poker.CONST_CREDITS;
        curBet = 0;
        name = n;
    }
}
