/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author MA
 */
public class MainClass {
    
    public static void main(String [] args){
        new SimpleThread ("Thread 1").start();
        new Thread(new SimpleRunThread("runnable 1")).run();
        System.out.println("Hello from main:)");
        new SimpleThread ("Thread 2").start();
        new Thread(new SimpleRunThread("runnable 2")).run();
    }
}
