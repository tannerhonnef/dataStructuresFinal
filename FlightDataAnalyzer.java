import java.util.Map;

public class FlightDataAnalyzer {
    public static void countFlightsPerDayOfWeek(Map<String, String[]> dataMap) {
        // Initialize counters for each day of the week
        int[] dayOfWeekCounts = new int[7]; // Index 0 represents Sunday, Index 1 represents Monday, and so on...

        // Iterate over the entries in the dataMap
        for (String[] values : dataMap.values()) {
            // Extract the day of the week from the second value in the array
            String dayOfWeek = values[1];

            // Increment the corresponding counter based on the day of the week
            switch (dayOfWeek) {
                case "Monday":
                    dayOfWeekCounts[0]++;
                    break;
                case "Tuesday":
                    dayOfWeekCounts[1]++;
                    break;
                case "Wednesday":
                    dayOfWeekCounts[2]++;
                    break;
                case "Thursday":
                    dayOfWeekCounts[3]++;
                    break;
                case "Friday":
                    dayOfWeekCounts[4]++;
                    break;
                case "Saturday":
                    dayOfWeekCounts[5]++;
                    break;
                case "Sunday":
                    dayOfWeekCounts[6]++;
                    break;
                default:
                    System.out.println("Invalid day of week: " + dayOfWeek);
            }
        }

        // Print the counts for each day of the week
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (int i = 0; i < dayOfWeekCounts.length; i++) {
            System.out.println(daysOfWeek[i] + ": " + dayOfWeekCounts[i]);
        }
    }
}
