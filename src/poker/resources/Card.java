/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.resources;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import poker.Poker;

/**
 *
 * @author donal.davies
 */
public class Card implements Comparable<Card>{
    public String suit; //The card's suit (Diamonds, clubs, etc.)
    public int value; //The number value of the card (Ace = 0, 2 = 1, etc.)
    public String name; //The displayed name of the card (Ace, 2, King, etc.)
    public ImageIcon icon; //The icon for the card (Stored in poker.resources.assets)
    public BufferedImage bufferedIcon; //BufferedImage for scaling purposes
    
    public Card(String s,int v,String n){
        suit = s;
        value = v;
        name = n;
        icon = loadImage();
        bufferedIcon = scaleImage(icon,Poker.CONST_CARDWIDTH,
                Poker.CONST_CARDHEIGHT); //Creates a scaled image     
    }
    
    @Override
    public int compareTo(Card c){ //Compares the value of cards for array sorting
        if(this.value==0)return -1;
        if(c.value==0)return 1;
        return c.value-this.value;
    }
    
    public ImageIcon loadImage(){
        try{ //Tries to get the associated icon from poker.resources.assets
            return new ImageIcon(getClass().getResource(
                    "/poker/resources/assets/"+this.name.toLowerCase()+"_of_"+this.suit.toLowerCase()+".png"));
        }catch(Exception e){ //If it isn't found, return a blank ImageIcon
            return new ImageIcon();
        }
    }
    
    public static BufferedImage scaleImage(ImageIcon ii,int WIDTH,int HEIGHT){
        BufferedImage bi = null;
        try{
            //Create a bufferedImage with the specified height and width
            bi = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB); 
            //Creates a graphics object from the image
            Graphics2D g2d = (Graphics2D) bi.getGraphics();
            //Apply the required rendering hints to the graphics object
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY));
            //Creates a scaled version of the card icon
            g2d.drawImage(ii.getImage(),0,0,bi.getWidth(),bi.getHeight(),null);
        }catch (Exception e){
            return null;
        }
        return bi;
    }
}
