package com.corejava.basic;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class CSVColumnWriter {
    public static void main(String[] args) {
        String csvFilePath = "path/to/your/file.csv";
        String newColumnHeader = "NewColumn";
        List<String> newColumnData = generateNewColumnData();

        try {
            // Step 1: Read the existing CSV file and store the data in memory
            Reader reader = new FileReader(csvFilePath);
            CSVParser csvParser = CSVFormat.DEFAULT.withHeader().parse(reader);
            List<CSVRecord> records = csvParser.getRecords();

            // Step 2: Modify the data by adding the new column
            List<String> headers = new ArrayList<>(csvParser.getHeaderMap().keySet());
            headers.add(newColumnHeader);

            // Step 3: Write the modified data back to the CSV file
            Writer writer = new FileWriter(csvFilePath);
            CSVPrinter csvPrinter = CSVFormat.DEFAULT.withHeader(headers.toArray(new String[0])).print(writer);

            for (int i = 0; i < records.size(); i++) {
                CSVRecord record = records.get(i);
                List<String> rowData = new ArrayList<>(record.size());

                // Copy existing column data
                for (String header : headers) {
                    if (record.isMapped(header)) {
                        rowData.add(record.get(header));
                    } else {
                        // Add new column data
                        if (header.equals(newColumnHeader)) {
                            rowData.add(newColumnData.get(i));
                        } else {
                            // Handle any other columns
                            rowData.add("");
                        }
                    }
                }

                csvPrinter.printRecord(rowData);
            }

            csvPrinter.flush();
            csvPrinter.close();
            writer.close();

            System.out.println("Data written successfully to the CSV file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> generateNewColumnData() {
        // Generate new column data based on your requirements
        // This is just an example
        List<String> newColumnData = new ArrayList<>();
        newColumnData.add("Value 1");
        newColumnData.add("Value 2");
        newColumnData.add("Value 3");

        return newColumnData;
    }
}
