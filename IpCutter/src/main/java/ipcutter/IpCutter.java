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
public class IpCutter {
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public IpCutter() {
    }

    public IpCutter(String ip) {
        this.ip = ip;
    }
    
    public int[] splitIp(){
        String[] parts = ip.split("\\.");
        int[] answer =new int[4];
        for (int i =0; i<4;i++){
            answer[i] = Integer.parseInt(parts[i]);
        }
        return answer;
    }
    
}
