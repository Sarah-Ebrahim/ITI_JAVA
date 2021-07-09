/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtube;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.apache.spark.api.java.JavaRDD;

/**
 *
 * @author MA
 */
public class YoutubeTagsCount {
    public static String extractTag(String videoLine) {
        try {
            return videoLine.split (",")[6];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
    }
    public List<Map.Entry> tagsCounter(JavaRDD<String> data){
        JavaRDD<String> tags = data
                .map (YoutubeTagsCount::extractTag)
                .filter (StringUtils::isNotBlank);
       // JavaRDD<String>
        JavaRDD<String> words = tags.flatMap (title -> Arrays.asList (title
                .toLowerCase ()
                .trim ()
               .split ("\\|")).iterator ());
        
        // COUNTING
        Map<String, Long> tagCounts = words.countByValue ();
        List<Map.Entry> sorted = tagCounts.entrySet ().stream ()
                .sorted (Map.Entry.comparingByValue ()).collect (Collectors.toList ());
        return sorted;
    }
}
