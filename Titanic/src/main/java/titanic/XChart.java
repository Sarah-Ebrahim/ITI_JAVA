/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package titanic;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.summingInt;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

/**
 *
 * @author MA
 */
public class XChart {
    public void graphPassengerAges(List<TitanicPassenger> passengerList){
        List<Float> pAges = passengerList.stream().map(TitanicPassenger::getAge).limit(8).collect(Collectors.toList());
        List<String> pNames = passengerList.stream().map(TitanicPassenger::getName).limit(8).collect(Collectors.toList());
        CategoryChart chart = new CategoryChartBuilder().width(1024).height(768).title("Age Histogram").xAxisTitle("Names").yAxisTitle("Age").build();
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        chart.addSeries("Passenger's Ages", pNames, pAges);
        new SwingWrapper(chart).displayChart();
    }
    
    public void passengerAgesPieChart(List<TitanicPassenger> passengerList){
        Map<String, Long> result = passengerList.stream().collect(Collectors.groupingBy(TitanicPassenger::getPclass,Collectors.counting()));
        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();
        Color[] sliceColors = new Color[]{new Color(180, 68,50), new Color(130, 105, 120), new Color(80, 143, 160)};
        chart.getStyler().setSeriesColors(sliceColors);
        chart.addSeries("First Class", result.get("1"));
        chart.addSeries("Second Class", result.get("2"));
        chart.addSeries("Third Class", result.get("3"));
        new SwingWrapper(chart).displayChart();
    }
    
    public void passengerSurvivedPieChart(List<TitanicPassenger> passengerList){
        Map<String, Long> result = passengerList.stream().collect(Collectors.groupingBy(TitanicPassenger::getSurvived,Collectors.counting()));
        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();
        Color[] sliceColors = new Color[]{new Color(180, 68,50), new Color(130, 105, 120)};
        chart.getStyler().setSeriesColors(sliceColors);
        chart.addSeries("Not Survived", result.get("0"));
        chart.addSeries("Survived", result.get("1"));
        new SwingWrapper(chart).displayChart();
    }
    
    public void passengerSurvivedGenderPieChart(List<TitanicPassenger> passengerList){
        Long male = passengerList.stream().filter(b->b.getSex().equals("male") && b.getSurvived().equals("1")).count();
        Long female = passengerList.stream().filter(b->b.getSex().equals("female") && b.getSurvived().equals("1")).count();
        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();
        Color[] sliceColors = new Color[]{new Color(180, 68,50), new Color(130, 105, 120)};
        chart.getStyler().setSeriesColors(sliceColors);
        chart.addSeries("Female Survived", female);
        chart.addSeries("Male Survived", male);
        new SwingWrapper(chart).displayChart();
    }
}
