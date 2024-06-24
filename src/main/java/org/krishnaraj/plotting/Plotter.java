package org.krishnaraj.plotting;
/// this is the class that will deal with plotting the data.

// importing some basic bar chart plotting functionality from jfreechart library

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class Plotter {
    public static void plotData(TimeSeriesCollection dataset, String title, String xLabel, String yLabel) {
        // creating a chart object
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                title,
                xLabel,
                yLabel,
                dataset,
                true,
                true,
                false
        );

        // creating a panel object
        ChartPanel panel = new ChartPanel(chart);

        // creating a frame object
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
