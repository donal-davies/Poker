/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import poker.gameUI.CoreUI;
import poker.logic.CardLogic;
import poker.resources.Card;
import poker.resources.Deck;
import poker.resources.NameGenerator;

/**
 *
 * @author donal.davies
 */
public class Poker {

    public static final int CONST_CARDWIDTH = 111; //Width of card icons
    public static final int CONST_CARDHEIGHT = 161; //Height of card icons
    
    public static final Deck deck = new Deck(); //Initialize the deck
    public static final int CONST_CREDITS = 10000; //Const value for the starting credits
    public static final CardLogic cardLogic = new CardLogic(); //Initialize CardLogic
    public static final NameGenerator nameGen = new NameGenerator(); //Initialize name generator
    
    private static final ImageIcon backIcon = //Load image for card backs
            new ImageIcon("/power/resources/assets/back.png");
    public static final BufferedImage backIconBI = //Create scaled version of card back
            Card.scaleImage(backIcon, CONST_CARDWIDTH, CONST_CARDHEIGHT);
    
    public static void main(String[] args) {
        CoreUI ui = new CoreUI();
        Card c = new Card("Diamonds",0,"ace");
       //FIGURE THIS OUT LATER 
        JLabel j = new JLabel(new ImageIcon((Image)c.bufferedIcon));
        ui.add(j);
        ui.setVisible(true);
        
        
        /*
        CardLogic cl = new CardLogic();
        
        JFrame jp = new JFrame();
        Dimension dim = new Dimension(200,400);
        jp.setMaximumSize(dim);
        jp.setMinimumSize(dim);   
        */
    }
}
