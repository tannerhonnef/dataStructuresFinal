import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FlightDataFilter {
    public static void main(String[] args) {

        // change to where the file is on your computer
        String csvFile = "/Users/tannerh/Library/CloudStorage/OneDrive-ClarkUniversity/classArchive/CSCI121/finalProject/flightsFilterIndex_sampled.csv";
        String line;
        String csvSplitBy = ",";

        Map<String, String[]> dataMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read the headers and store them in an array
            String[] headers = br.readLine().split(csvSplitBy);

            // Read the rest of the file and store data in the map
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);
                // Assuming the first column is the key
                String key = values[0];
                for (int i = 1; i < values.length; i++) {
                    values[i] = values[i].replaceAll("^\"|\"$", ""); // Remove leading and trailing quotation marks
                }
                String[] rowValues = new String[values.length - 1];
                System.arraycopy(values, 1, rowValues, 0, values.length - 1);
                dataMap.put(key, rowValues);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // User input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter airlines separated by comma (or leave blank to ignore): ");
        String airlineInput = scanner.nextLine().trim();
        System.out.print("Enter months separated by comma (or leave blank to ignore): ");
        String monthInput = scanner.nextLine().trim();
        System.out.print("Enter days of week separated by comma (or leave blank to ignore): ");
        String dayOfWeekInput = scanner.nextLine().trim();

        // Convert input strings to sets
        Set<String> airlines = new HashSet<>(Arrays.asList(airlineInput.split("\\s*,\\s*")));
        Set<String> months = new HashSet<>(Arrays.asList(monthInput.split("\\s*,\\s*")));
        Set<String> daysOfWeek = new HashSet<>(Arrays.asList(dayOfWeekInput.split("\\s*,\\s*")));

        // Filter data based on user input
        Map<String, String[]> filteredData = new HashMap<>();
        for (Map.Entry<String, String[]> entry : dataMap.entrySet()) {
            String[] values = entry.getValue();
            boolean match = true;

            // Check if the airline matches (if specified)
            if (!airlineInput.isEmpty() && !airlines.contains(values[2])) {
                match = false;
            }

            // Check if the month matches (if specified)
            if (!monthInput.isEmpty() && !months.contains(values[0])) {
                match = false;
            }

            // Check if the day of week matches (if specified)
            if (!dayOfWeekInput.isEmpty() && !daysOfWeek.contains(values[1])) {
                match = false;
            }

            // If all criteria match, add the entry to filteredData
            if (match) {
                filteredData.put(entry.getKey(), entry.getValue());
            }
        }

        // Print the filtered hashmap
        System.out.println("Filtered Data:");
        for (Map.Entry<String, String[]> entry : filteredData.entrySet()) {
            System.out.print("Key: " + entry.getKey() + ", Values: ");
            for (String value : entry.getValue()) {
                System.out.print(value + ", ");
            }
            System.out.println();
        }

        scanner.close();
        FlightDataAnalyzer.countFlightsPerDayOfWeek(filteredData);
        flightsPerMonth.countFlightsPerMonth(filteredData);
        arrivalPerformance.countArrivals(filteredData);
    }
}
