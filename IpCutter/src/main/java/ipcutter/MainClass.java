/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipcutter;

/**
 *
 * @author MA
 */
public class MainClass {
    
    public static void main(String[] args){
            String ip = "163.121.12.3";
            IpCutter c1 = new IpCutter(ip);
            int[] splittedIp =c1.splitIp();
            for(int i=0; i < splittedIp.length; i++){
                System.out.println(splittedIp[i]);
            }
    }
}
