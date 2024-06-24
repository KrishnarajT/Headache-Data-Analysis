package org.krishnaraj;

import org.jfree.data.time.TimeSeriesCollection;
import org.krishnaraj.dataManagement.DataManager;
import org.krishnaraj.plotting.Plotter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! welcome to me trying to plot some data.");

        // calling the readData method from DataManager class
        TimeSeriesCollection headache_dataset = DataManager.readData("headache.csv");

        // plotting it.
        Plotter.plotData(headache_dataset, "Headache data", "Year", "Headache Duration (Hours)");
    }
}