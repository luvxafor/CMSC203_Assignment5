
package assignments.holiday_bonus.solution;

import java.io.*;
import java.util.ArrayList;


/*
 * Class: CMSC203 
 * Instructor:Grigoriy A. Grinberg
 * Description: A class that imports a file and covert it to a ragged two dimensional array.
 * Due: 07/22/2024
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Afor Njoh
*/

public final class TwoDimRaggedArrayUtility {

    // Constructor
    public TwoDimRaggedArrayUtility() {
    }

    // Reads from a file and returns a ragged array of doubles
    public static double[][] readFile(File file) throws FileNotFoundException {
        double[][] result = new double[10][];
        ArrayList<double[]> tempList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] strValues = line.split(" ");
                double[] doubleValues = new double[strValues.length];
                for (int i = 0; i < strValues.length; i++) {
                    doubleValues[i] = Double.parseDouble(strValues[i]);
                }
                tempList.add(doubleValues);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < tempList.size(); i++) {
            result[i] = tempList.get(i);
        }

        return result;
    }

    // Writes the ragged array of doubles into the file
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            for (double[] row : data) {
                for (int i = 0; i < row.length; i++) {
                    writer.print(row[i]);
                    if (i < row.length - 1) {
                        writer.print(" ");
                    }
                }
                writer.println();
            }
        }
    }

    // Returns the total of all the elements of the two dimensional array
    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    // Returns the average of the elements in the two dimensional array
    public static double getAverage(double[][] data) {
        double total = getTotal(data);
        int count = 0;
        for (double[] row : data) {
            count += row.length;
        }
        return total / count;
    }

    // Returns the total of the selected row
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (double value : data[row]) {
            total += value;
        }
        return total;
    }

    // Returns the total of the selected column
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data) {
            if (row.length > col) {
                total += row[col];
            }
        }
        return total;
    }

    // Returns the largest element in the two dimensional array
    public static double getHighestInArray(double[][] data) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            for (double value : row) {
                if (value > highest) {
                    highest = value;
                }
            }
        }
        return highest;
    }

    // Returns the smallest element in the two dimensional array
    public static double getLowestInArray(double[][] data) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            for (double value : row) {
                if (value < lowest) {
                    lowest = value;
                }
            }
        }
        return lowest;
    }

    // Returns the largest element of the selected row
    public static double getHighestInRow(double[][] data, int row) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double value : data[row]) {
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }

    // Returns the index of the largest element of the selected row
    public static int getHighestInRowIndex(double[][] data, int row) {
        double highest = Double.NEGATIVE_INFINITY;
        int index = -1;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > highest) {
                highest = data[row][i];
                index = i;
            }
        }
        return index;
    }

    // Returns the smallest element of the selected row
    public static double getLowestInRow(double[][] data, int row) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double value : data[row]) {
            if (value < lowest) {
                lowest = value;
            }
        }
        return lowest;
    }

    // Returns the index of the smallest element of the selected row
    public static int getLowestInRowIndex(double[][] data, int row) {
        double lowest = Double.POSITIVE_INFINITY;
        int index = -1;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < lowest) {
                lowest = data[row][i];
                index = i;
            }
        }
        return index;
    }

    // Returns the largest element of the selected column
    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            if (row.length > col && row[col] > highest) {
                highest = row[col];
            }
        }
        return highest;
    }

    // Returns the index of the largest element of the selected column
    public static int getHighestInColumnIndex(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > col && data[i][col] > highest) {
                highest = data[i][col];
                index = i;
            }
        }
        return index;
    }

    // Returns the smallest element of the selected column
    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            if (row.length > col && row[col] < lowest) {
                lowest = row[col];
            }
        }
        return lowest;
    }

    // Returns the index of the smallest element of the selected column
    public static int getLowestInColumnIndex(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > col && data[i][col] < lowest) {
                lowest = data[i][col];
                index = i;
            }
        }
        return index;
    }
}
