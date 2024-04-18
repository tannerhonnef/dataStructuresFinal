import java.util.HashMap;
import java.util.Map;

public class arrivalPerformance {
    public static void countArrivals(Map<String, String[]> dataMap) {
        // Initialize counters for early, on time, and late flights for each airline
        Map<String, int[]> airlineCounts = new HashMap<>();

        // Iterate over the entries in the dataMap
        for (String[] values : dataMap.values()) {
            // Extract the airline and arrival delay from the values array
            String airline = values[2];
            String arrivalDelayStr = values[12]; // Assuming arrival delay is the last value

            // Skip processing if arrival delay is "NA"
            if (arrivalDelayStr.equals("NA")) {
                continue;
            }

            int arrivalDelay = Integer.parseInt(arrivalDelayStr);

            // Initialize counters if not already present for the airline
            if (!airlineCounts.containsKey(airline)) {
                airlineCounts.put(airline, new int[3]); // Index 0 for early, 1 for on time, 2 for late
            }

            // Determine whether the flight is early, on time, or late based on the arrival delay
            int[] counts = airlineCounts.get(airline);
            if (arrivalDelay < -5) {
                counts[0]++; // Increment early count
            } else if (arrivalDelay >= -5 && arrivalDelay <= 5) {
                counts[1]++; // Increment on time count
            } else {
                counts[2]++; // Increment late count
            }
        }

        // Print the percentages for each airline
        for (Map.Entry<String, int[]> entry : airlineCounts.entrySet()) {
            String airline = entry.getKey();
            int[] counts = entry.getValue();
            int totalFlights = counts[0] + counts[1] + counts[2];
            double earlyPercentage = Math.round(((double) counts[0] / totalFlights * 100) * 100.0) / 100.0;
            double onTimePercentage = Math.round(((double) counts[1] / totalFlights * 100) * 100.0) / 100.0;
            double latePercentage = Math.round(((double) counts[2] / totalFlights * 100) * 100.0) / 100.0;
            System.out.println(airline + " - Early: " + earlyPercentage + "%, On Time: " + onTimePercentage + "%, Late: " + latePercentage + "%");
        }
    }
}
