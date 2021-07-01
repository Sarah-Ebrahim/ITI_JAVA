/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import static java.lang.Thread.sleep;

/**
 *
 * @author MA
 */
public class SimpleThread extends Thread{
    private String name;

    public SimpleThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 1; i<11; i++){
            System.out.println(i + " " + name);
            try {
                sleep((int) (Math.random()*1000));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    
    
}

