/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import poker.resources.Card;

/**
 *
 * @author donal.davies
 */
public class CardLogic {
    
    /**Compares two players hands and determines which is worth more
     * 
     * @param player1 the result of calcHand for the first player
     * @param player2 the result of calcHand for the second player
     * @return Either 1 or 2, depending on the superior hand
     */
    public int compareHands(ArrayList<Object> player1, ArrayList<Object> player2){
        if(((int)player1.get(1))>((int)player2.get(1))){
            return 1; //Return 1 if the first player's hand is a higher score than the second
        }else if(((int)player1.get(1))<((int)player2.get(1))){
            return 2; //Return 2 if the second player's hand is a higher score than the first
        }else{ //If the hands are both the same tier
            ArrayList<Card> p1 = (ArrayList)player1.get(0);
            ArrayList<Card> p2 = (ArrayList)player2.get(1);
            for(int i=0;i<5;i++){ //Compare each card of the hands to find a higher value
                if(p1.get(i).value>p2.get(i).value){
                    return 1; //If player 1 has a higher value card, he wins
                }else if(p1.get(i).value>p2.get(i).value){
                    return 2; //If player 2 has a higher value card, he wins
                }
            }
        }
        return 3; //Hands are equal. This doesn't happen often; congratulations?
    }
    
    /**
     * Sorts through a given set of cards and outputs the highest rank hand held
     * in that set; The lower the integer value, the higher the hand rank
     * 
     * @param hand the two cards held by the player
     * @param dealer the five dealt cards
     * @return an ArrayList containing a list of the cards used for the hand and
     *         an integer indicating the hand rank
     **/
    public ArrayList<Object> calcHand(Card[] hand, Card[] dealer){
        ArrayList<Card> combined = new ArrayList<>();
        //Add the player and dealer hands to the combined list
        Collections.addAll(combined,hand);
        Collections.addAll(combined,dealer);
        //Sorts by card value
        Collections.sort(combined);
        //Copies aces to end of list for finding straights (Aces are high and low in poker)
        doubleAces(combined);
        
        //Counts the occurrences of each suit
        HashMap<String,Integer> suitCount = suitCount(combined);
        //Indicates whether or not any suit can have a flush
        String possibleFlush = possibleSuits(suitCount);
        
        ArrayList<Card> outputHand;
        ArrayList<Object> output = new ArrayList<>();
        
        //Goes through each possible hand tier in descending order
        if(possibleFlush!=null){
            //ROYAL FLUSH: RANK 0
            if((outputHand=checkRoyal(combined,possibleFlush))!=null){
                output.add(outputHand);
                output.add(0);
                return output;
            }
            //STRAIGHT FLUSH: RANK 1
            if((outputHand=checkSFlush(combined,possibleFlush))!=null){
                output.add(outputHand);
                output.add(1);
                return output;
            }
        }
        //FOUR OF A KIND: RANK 2
        if((outputHand=checkFKind(combined))!=null){
            output.add(outputHand);
            output.add(2);
            return output;
        }
        ArrayList<Card> tk = check3Kind(combined);
        //FULL HOUSE: RANK 3
        if(tk!=null){
            if((outputHand=checkFH(tk,combined))!=null){
                output.add(outputHand);
                output.add(3);
                return output;
            }
        }
        //FLUSH: RANK 4
        if(possibleFlush!=null){
            if((outputHand=checkFlush(combined,possibleFlush))!=null){
                output.add(outputHand);
                output.add(4);
                return output;
            }
        }
        //STRAIGHT: RANK 5
        if((outputHand=checkStraight(combined))!=null){
            output.add(outputHand);
            output.add(5);
            return output;
        }
        //THREE OF A KIND: RANK 6
        if(tk!=null){
            output.add(tk);
            output.add(6);
            return output;
        }
        tk = checkPair(combined,-1);
        if(tk!=null){
            //TWO PAIR: RANK 7
            if((outputHand=checkTPair(tk,combined))!=null){
                output.add(outputHand);
                output.add(7);
                return output;
            //PAIR: RANK 8
            }else{
                output.add(tk);
                output.add(8);
                return output;
            }
        }
        //NO PAIR / HIGH CARD: RANK 9
        outputHand = getHCard(combined);
        output.add(outputHand);
        output.add(9);
        return output;
    }
    
    /**
     * Copies aces to the end of the combined hand
     * @param hand The player's and dealer's hands combined
     */
    public void doubleAces(ArrayList<Card> hand){
        ArrayList<Card> temp = new ArrayList<>(hand);
        for(Card c:temp){
            if(c.value==0)hand.add(c);
            else break;
        }
    }
    
    /**
     * Determines whether or not any suits can have a flush
     * @param suitCount The results of suitCount
     * @return A suit with 5 or more occurrences
     */
    public String possibleSuits(HashMap<String,Integer> suitCount){
        String out = null;
        for(String s:suitCount.keySet()){
            if(suitCount.get(s)>=5){
                out = s;
                break;
            }
        }
        return out;
    }
    
    //Counts each suit
    public HashMap<String,Integer> suitCount(ArrayList<Card> hand){
        Map<String,Integer> output = new HashMap<>();
        output.put("Diamonds",0);
        output.put("Spades",0);
        output.put("Hearts",0);
        output.put("Clubs",0);
        for(Card c:hand){
            output.put(c.suit,output.get(c.suit)+1);
        }
        return (HashMap)output;
    }
    
    //Checks if the hand is a royal flush
    public ArrayList<Card> checkRoyal(ArrayList<Card> hand,String suit){
        Card[] sift = new Card[5];
        int count = 0;
        for(Card c:hand){
            if(count==0){
                if(c.value!=0||!c.suit.equals(suit)){
                    continue;
                }else{
                    sift[0]=c;
                }
            }else{
                if(c.value==(sift[count-1].value==0?12:sift[count-1].value-1)
                        &&c.suit.equals(sift[count-1].suit)){
                    sift[count]=c;
                }else{
                    continue;
                }
            }
            if(count==4)break;
            count++;
        }
        if(sift[4]!=null){
            ArrayList<Card> out = new ArrayList<>();
            Collections.addAll(out,sift);
            return out;
        }else{
            return null;
        }
    }
    
    //Checks if the hand is a straight flush
    public ArrayList<Card> checkSFlush(ArrayList<Card> hand,String suit){
        Card[] set = new Card[5];
        int count = 0;
        for(Card c:hand){
            if(!c.suit.equals(suit))continue;
            if(count==0)set[0]=c;
            else if(c.value==set[count-1].value-1)set[count]=c;
            else{
                count=0;
                set[0]=c;
            }
            
            if(count==4)break;
            count++;
        }
        
        if(set[4]!=null){
            ArrayList<Card> out = new ArrayList<>();
            Collections.addAll(out,set);
            return out;
        }else{
            return null;
        }
    }
    
    //Checks if the hand is a flush
    public ArrayList<Card> checkFlush(ArrayList<Card> hand, String suit){
        Card[] set = new Card[5];
        int count = 0;
        for(Card c:hand){
            if(!c.suit.equals(suit)){
                continue;
            }
            set[count] = c;
            
            if(count==4)break;
            count++;
        }
        
        if(set[4]!=null){
            ArrayList<Card> output = new ArrayList<>();
            Collections.addAll(output,set);
            return output;
        }else{
            return null;
        }
    }
    
    //Checks if the hand is a four of a kind
    public ArrayList<Card> checkFKind(ArrayList<Card> hand){
        Card[] set = new Card[5];
        int count = 0;
        for(Card c:hand){
            if(count == 0)set[0]=c;
            else{
                if(c.value==set[count-1].value){
                    set[count]=c;
                }else{
                    set = new Card[5];
                    count = 0;
                    set[0] = c;
                }
            }
            if(count==3)break;
            count++;
        }
        if(set[3]!=null){
            for(Card c:hand){
                if(c.value!=set[0].value){
                    set[4]=c;
                    break;
                }
            }
            ArrayList<Card> out = new ArrayList<>();
            Collections.addAll(out,set);
            return out;
        }else{
            return null;
        }
    }
  
    //Takes output from check3Kind and checkPair to see if they form a full house
    public ArrayList<Card> checkFH(ArrayList<Card> thr,ArrayList<Card> hand){
        ArrayList<Card> tw = checkPair(hand,thr.get(0).value);
        ArrayList<Card> output = new ArrayList<>();
        if(tw!=null){
            for(int i=0;i<3;i++)output.add(thr.get(i));
            for(int i=0;i<2;i++)output.add(tw.get(i));
            return output;
        }else{
            return null;
        }
    }  
    
    //Checks if the hand is a three of a kind
    public ArrayList<Card> check3Kind(ArrayList<Card> hand){
        Card[] set = new Card[5];
        int count = 0;
        for(Card c:hand){
            if(count==0)set[0]=c;
            else if(c.value==set[count-1].value)set[count]=c;
            else{
                set = new Card[5];
                count = 0;
                set[0]=c;
            }
            if(count==2)break;
            count++;
        }
        
        if(set[2]!=null){
            count = 3;
            for(Card c:hand){
                if(c.value!=set[0].value){
                    set[count]=c;
                }
            }
            ArrayList<Card> out = new ArrayList<>();
            Collections.addAll(out,set);
            return out;
        }else{
            return null;
        }
    }
    
    /**
     * Checks to see if the hand is a pair
     * @param ignore a card value that the method will skip (for checking full house)
     */
    public ArrayList<Card> checkPair(ArrayList<Card> hand,int ignore){
        Card[] set = new Card[5];
        int count = 0;
        for(Card c:hand){
            if(count==0)set[0]=c;
            else if(c.value==set[count-1].value&&c.value!=ignore)set[count]=c;
            else{
                set = new Card[5];
                count = 0;
                set[0]=c;
            }
            
            if(count==1)break;
            count++;
        }
        
        if(set[1]!=null){
            ArrayList<Card> out = new ArrayList<>();
            Collections.addAll(out,set);
            count = 2;
            for(Card c:hand){
                if(c.value!=set[0].value)out.add(c);
                if(count==4)break;
                count++;
            }
            return out;
        }else{
            return null;
        }
    }
    
    //Checks to see if the hand is a straight
    public ArrayList<Card> checkStraight(ArrayList<Card> hand){
        Card[] set = new Card[5];
        int count = 0;
        for(Card c:hand){
            if(count==0)set[count]=c;
            else if(c.value==set[count-1].value-1)set[count]=c;
            else{
                set = new Card[5];
                count = 0;
                set[0]=c;
            }
            if(count==4)break;
            count++;
        }
        
        if(set[4]!=null){
            ArrayList<Card> out = new ArrayList<>();
            Collections.addAll(out,set);
            return out;
        }else{
            return null;
        }
    }
    
    //Checks to see if the hand is a two pair
    public ArrayList<Card> checkTPair(ArrayList<Card> p1, ArrayList<Card> hand){
        ArrayList<Card> p2 = checkPair(hand,p1.get(0).value);
        if(p2!=null){
            ArrayList<Card> out = new ArrayList<>();
            for(int i=0;i<2;i++)out.add(p1.get(i));
            for(int i=0;i<2;i++)out.add(p2.get(i));
            return out;
        }else{
            return null;
        }
    }
    
    //Sorts the hand by card value in descending order if it isn't any of the other tiers
    // -it is a no pair
    public ArrayList<Card> getHCard(ArrayList<Card> hand){
        ArrayList<Card> out = new ArrayList<>();
        for(int i=0;i<5;i++)out.add(hand.get(i));
        return out;
    }
}
