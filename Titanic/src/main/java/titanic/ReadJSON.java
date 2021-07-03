/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package titanic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MA
 */
public class ReadJSON {
    public List<TitanicPassenger> getPassengersFromJsonFile(){
        InputStream input = null;
        List<TitanicPassenger> allPassengers = new ArrayList<TitanicPassenger>();
        try {
            
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            input = new FileInputStream("C:\\Users\\MA\\Documents\\NetBeansProjects\\Titanic\\src\\main\\java\\titanic\\titanic.json");
            allPassengers = objectMapper.readValue(input, new TypeReference<List<TitanicPassenger>>(){});
            
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadJSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadJSON.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadJSON.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return allPassengers;
        
        
        
    }
}
