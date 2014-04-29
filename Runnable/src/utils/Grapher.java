package utils;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created on 29.04.14.
 *
 * @author mk
 */
public class Grapher {

    private static TimeTracker TT = TimeTracker.getInstance();

    public static IntervalCategoryDataset createData(){
        TaskSeries seriesWood = new TaskSeries("woodcutters");
        Iterator<SimpleTimePeriod> w = TT.woodTimes.iterator();
        int i = 1;
        while(w.hasNext()){
            seriesWood.add(new Task("Woodcutter #" + i, w.next()));
            i++;
        }

        TaskSeries seriesStone = new TaskSeries("quarrymen");
        Iterator<SimpleTimePeriod> q = TT.stoneTimes.iterator();
        i = 1;
        while(q.hasNext()){
            seriesStone.add(new Task("Quarryman #" + i, q.next()));
            i++;
        }

        TaskSeries seriesHouse = new TaskSeries("builders");
        Iterator<SimpleTimePeriod> h = TT.houseTimes.iterator();
        i = 1;
        while(h.hasNext()){
            seriesHouse.add(new Task("Builder #" + i, h.next()));
            i++;
        }

        TaskSeries seriesFish = new TaskSeries("fishermen");
        Iterator<SimpleTimePeriod> f = TT.fishTimes.iterator();
        i = 1;
        while(f.hasNext()){
            seriesFish.add(new Task("Fisherman #" + i, f.next()));
            i++;
        }

        TaskSeries seriesTrees = new TaskSeries("foresters");
        Iterator<SimpleTimePeriod> t = TT.treeTimes.iterator();
        i = 1;
        while(t.hasNext()){
            seriesTrees.add(new Task("Forester #" + i, t.next()));
            i++;
        }

        final TaskSeriesCollection collection = new TaskSeriesCollection();
        collection.add(seriesFish);
        collection.add(seriesHouse);
        collection.add(seriesStone);
        collection.add(seriesTrees);
        collection.add(seriesWood);

        return collection;
    }

    private static JFreeChart createChart(final IntervalCategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createGanttChart(
                "Village", // chart title
                "Thread", // domain axis label
                "Time", // range axis label
                dataset, // data
                false, // include legend
                false, // tooltips
                false // urls
        );
        return chart;
    }

    private static void saveChart(JFreeChart chart, String fileLocation) {
        String fileName = fileLocation;
        try {
            ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 800, 600);
        } catch (IOException e) {
            System.err.println("Problem occurred creating chart.");
        }
    }

    public static void makeGraph(){

        String filename = "./graph.jpg";

        JFreeChart chart = Grapher.createChart(createData());

        saveChart(chart, filename);

    }
}
