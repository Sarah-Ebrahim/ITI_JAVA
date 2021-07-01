/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaEx;

/**
 *
 * @author MA
 */
public class MainClass {
    
    public static void main(String[] args){

        String longer = StringUtils.betterString("sarah", "sarah Ibrahim", (s1,s2) -> s1.length()>s2.length());
        System.out.println(longer);
        
        String first = StringUtils.betterString("sarah", "sarah Ibrahim", (s1,s2) -> true);
        System.out.println(first);
        
       
        
    }
}
