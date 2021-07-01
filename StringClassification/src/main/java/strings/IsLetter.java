/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

import javax.xml.stream.events.Characters;

/**
 *
 * @author MA
 */
public class IsLetter {
   public boolean classify(String s){
       return((!s.equals(" ") && s != null)&& (s.chars().allMatch(b->Character.isLetter(b))));
   } 
}
