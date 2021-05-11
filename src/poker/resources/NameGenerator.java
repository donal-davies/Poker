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
public class NameGenerator {
    public ArrayList<String> names;
    public ArrayList<String> usedNames;

    public NameGenerator(){
        names = new ArrayList<>();
        usedNames = new ArrayList<>();
        //Adding each name one by one, fun times
        names.add("John");
        names.add("Steve");
        names.add("Michael");
        names.add("Tim");
        names.add("JERAXUS");
    }
    
    public void refresh(){
        ArrayList<String> temp = new ArrayList<>(usedNames);
        for(String s:temp){
            names.add(s);
            usedNames.remove(s);
        }
    }
    
    public String genName(){
        Random r = new Random();
        String s = names.get(r.nextInt(names.size()));
        usedNames.add(s);
        names.remove(s);
        return s;
    }
}
