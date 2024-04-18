import java.util.Map;

public class flightsPerMonth {
    public static void countFlightsPerMonth(Map<String, String[]> dataMap) {
        // Initialize counters for each day of the week
        int[] monthCounts = new int[12]; // Index 0 represents Sunday, Index 1 represents Monday, and so on...

        // Iterate over the entries in the dataMap
        for (String[] values : dataMap.values()) {
            // Extract the day of the week from the second value in the array
            String month = values[0];

            // Increment the corresponding counter based on the day of the week
            switch (month) {
                case "January":
                    monthCounts[0]++;
                    break;
                case "February":
                    monthCounts[1]++;
                    break;
                case "March":
                    monthCounts[2]++;
                    break;
                case "April":
                    monthCounts[3]++;
                    break;
                case "May":
                    monthCounts[4]++;
                    break;
                case "June":
                    monthCounts[5]++;
                    break;
                case "July":
                    monthCounts[6]++;
                    break;
                case "August":
                    monthCounts[7]++;
                    break;
                case "September":
                    monthCounts[8]++;
                    break;
                case "October":
                    monthCounts[9]++;
                    break;
                case "November":
                    monthCounts[10]++;
                    break;
                case "December":
                    monthCounts[11]++;
                    break;
                default:
                    System.out.println("Invalid month: " + month);
            }
        }

        // Print the counts for each day of the week
        String[] monthsOfYear = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < monthCounts.length; i++) {
            System.out.println(monthsOfYear[i] + ": " + monthCounts[i]);
        }
    }
}
