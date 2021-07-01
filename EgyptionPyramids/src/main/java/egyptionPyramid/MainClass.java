/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptionPyramid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MA
 */
public class MainClass {
    public static void main(String[] args){
        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        List<Pyramid> pyramids = pDAO.readPyramidFromCSV("C:\\Users\\MA\\Documents\\NetBeansProjects\\EgyptionPyramids\\src\\main\\java\\egyptionPyramid\\pyramids.csv");
        int i = 0;
        for (Pyramid p:pyramids){
            System.out.println("#"+(i++)+p);
        }
        
        System.out.println("\nsorted list according to the height:");
        i = 0;
        pDAO.sortPyramids(pyramids);
        for (Pyramid p:pyramids){
            System.out.println("#"+(i++)+p);
        }
        
        System.out.println("\nNumber of pyramids in each site:");
        Map<String, Integer> sites = pDAO.siteMap(pyramids); 
        for(String name: sites.keySet()){
            Integer value = sites.get(name);
            System.out.println(name + " = " + value);
        }
    }
}
