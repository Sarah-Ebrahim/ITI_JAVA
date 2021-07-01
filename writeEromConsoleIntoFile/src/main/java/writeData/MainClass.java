/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writeData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MA
 */
public class MainClass {
    public static void main(String[] args){
        FileWriter writer = null;
        try {
            writer = new FileWriter("S:\\9. Java & UML programming\\Day3\\task.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            String data = " ";
            while(!data.equals("stop")){
                System.out.println("Enter data:");
                data = br.readLine();
                buffer.write(data + "\n");
                buffer.write("\n");
            }   
            br.close();
            r.close();
            buffer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }
}
