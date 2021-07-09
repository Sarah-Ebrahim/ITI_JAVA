/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtube;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 *
 * @author MA
 */
public class MainClass {
    public static void main(String args[]){
        Logger.getLogger ("org").setLevel (Level.ERROR);
        // CREATE SPARK CONTEXT
        SparkConf conf = new SparkConf ().setAppName ("wordCounts").setMaster ("local[3]");
        JavaSparkContext sparkContext = new JavaSparkContext (conf);
        // LOAD DATASETS
        JavaRDD<String> videos = sparkContext.textFile ("src/main/resources/data/USvideos.csv");
        YoutubeTagsCount youtube = new YoutubeTagsCount();
        List<Map.Entry> tags_list = youtube.tagsCounter(videos);
        for (Map.Entry<String, Long> entry : tags_list) {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        }
    }    
}
