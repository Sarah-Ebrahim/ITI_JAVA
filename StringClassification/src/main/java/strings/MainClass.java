/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

/**
 *
 * @author MA
 */
public class MainClass {
    public static void main(String[] args){
        IsLetter obj = new IsLetter();
        System.out.println(obj.classify("s$3ra"));
        System.out.println(obj.classify("saffa"));
    }
}
