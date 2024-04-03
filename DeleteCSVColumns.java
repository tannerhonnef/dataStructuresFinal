import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteCSVColumns {
    public static void main(String[] args) {
        String inputFilePath = "/Users/tannerh/Library/CloudStorage/OneDrive-ClarkUniversity/classArchive/CSCI121/finalProject/flights.csv";
        String outputFilePath = "/Users/tannerh/Library/CloudStorage/OneDrive-ClarkUniversity/classArchive/CSCI121/finalProject/flightsFilter.csv";
        int[] columnsToDelete = {0, 2, 5, 6, 9, 13, 14, 17, 18, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30}; // Indexes of columns to delete (0-based)

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                List<String> modifiedParts = new ArrayList<>();
                for (int i = 0; i < parts.length; i++) {
                    if (!contains(columnsToDelete, i)) {
                        modifiedParts.add(parts[i]);
                    }
                }

                writer.write(String.join(",", modifiedParts));
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("Columns deleted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean contains(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }
}