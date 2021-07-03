/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package titanic;
//import tech.tablesaw;

//import com.ibm.icu.impl.UResource.Table;



import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;


/**
 *
 * @author MA
 */
public class MainClass {
    public static void main(String[] args){
        try {
            Table titanicData;
            String dataPath ="C:\\Users\\MA\\Documents\\NetBeansProjects\\Titanic\\src\\main\\java\\titanic\\titanic.csv";
            titanicData = Table.read().csv(dataPath);
            List<Column<?>> dataStructure = titanicData.columns();
            System.out.println(dataStructure);
            System.out.println(titanicData.summary());
            ReadJSON rj = new ReadJSON();
            XChart xchart = new XChart();
            xchart.graphPassengerAges(rj.getPassengersFromJsonFile());
            xchart.passengerAgesPieChart(rj.getPassengersFromJsonFile());
            xchart.passengerSurvivedPieChart(rj.getPassengersFromJsonFile());
            xchart.passengerSurvivedGenderPieChart(rj.getPassengersFromJsonFile());
            
        } catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
