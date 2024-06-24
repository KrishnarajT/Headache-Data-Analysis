package org.krishnaraj.dataManagement;
// this is the class that will resolve and read csv files from resources folder.


// importing the required classes from apache commons csv library

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DataManager {


    public static TimeSeriesCollection readData(String fileName) {
        TimeSeries series = new TimeSeries("Headache data");
        TimeSeriesCollection dataset = new TimeSeriesCollection(series);

        // output data in the DefaultCategoryDataset format
        try {
            // creating a reader object to read the file
            Reader reader = new FileReader("src/main/resources/" + fileName);
            // creating a parser object to parse the csv file
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            // iterating through the records in the csv file
            for (CSVRecord csvRecord : csvParser) {
                // printing the records
                System.out.println(csvRecord.get(1) + " " + csvRecord.get(2));
                // add data into the dataset object, 1 is date, and 2 is duration
                String date = csvRecord.get(1);
                String duration = csvRecord.get(2);
                // we gotta parse this date 2021-01-09  21:09 using java.time
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm");
                LocalDate parsedDate = LocalDate.parse(date, formatter);

                DateTimeFormatter durationFormatter = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime parsedDuration = LocalTime.parse(duration, durationFormatter);
                System.out.println(parsedDate);
                series.addOrUpdate(new org.jfree.data.time.Day(parsedDate.getDayOfMonth(), parsedDate.getMonthValue(), parsedDate.getYear()), parsedDuration.getHour());
            }
            // print the dataset
            System.out.println(dataset);

            // closing the reader
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        // return the dataset
        return dataset;
    }
}
