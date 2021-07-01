/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptionPyramid;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MA
 */
public class PyramidCSVDAO {

    public PyramidCSVDAO() {
    }
    
    public List<Pyramid> readPyramidFromCSV(String fileName){
        List<Pyramid> pyramids =  new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            if(line != null){
                line = br.readLine();
            }
            while(line != null){
                String[] attributes = line.split(",");
                Pyramid pyramid = createPyramid(attributes);
                pyramids.add(pyramid);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PyramidCSVDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PyramidCSVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return pyramids; 
    }
    
    public Pyramid createPyramid(String[] metadata){
        String pharaoh = metadata[0];
        String modern_name = metadata[2];
        String site = metadata[4];
        double height = 0;
        if(metadata[7] != null && metadata[7].length()>0){
            height = Double.parseDouble(metadata[7]);
        }
        Pyramid pyramid = new Pyramid(pharaoh, modern_name, site, height);
        return pyramid;
    }

   public List<Pyramid> sortPyramids(List<Pyramid> pyramids){
       pyramids.sort(Comparator.comparingDouble(Pyramid::getHeight));
       return pyramids;
   }
   
   public Map<String,Integer> siteMap(List<Pyramid> pyramids){
       Map<String, Integer> sites = new HashMap<>();
       for(Pyramid pyramid: pyramids){
           String site = pyramid.getSite();
           Integer num = sites.get(site);
           if (num == null){
               num = 1;
           }else{
               num++;
           }
           sites.put(site, num);
       }
       return sites;
   }
}
