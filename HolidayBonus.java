package assignments.holiday_bonus.solution;


/*
 * Class: CMSC203 
 * Instructor:Grigoriy A. Grinberg
 * Description: A class that calculates the holiday bonus for different shops based on their sales numbers.
 * Due: 07/22/2024
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Afor Njoh
*/
public class HolidayBonus {

    /**
     * Default constructor.
     */
    public HolidayBonus() {
    }

    /**
     * Calculates the holiday bonus for each store.
     * 
     * @param data the two dimensional array of store sales
     * @return an array of the bonus for each store
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        if (data == null || data.length == 0) {
            return new double[0];
        }

        double[] bonuses = new double[data.length];

        for (int col = 0; col < getMaxColumnLength(data); col++) {
            int highestStoreIndex = -1;
            int lowestStoreIndex = -1;
            double highestSale = Double.NEGATIVE_INFINITY;
            double lowestSale = Double.POSITIVE_INFINITY;

            // Determine highest and lowest sale in the current category
            for (int row = 0; row < data.length; row++) {
                if (data[row] != null && col < data[row].length && data[row][col] > 0) {
                    if (data[row][col] > highestSale) {
                        highestSale = data[row][col];
                        highestStoreIndex = row;
                    }
                    if (data[row][col] < lowestSale) {
                        lowestSale = data[row][col];
                        lowestStoreIndex = row;
                    }
                }
            }

            // Assign bonuses based on highest, lowest, and other sales
            for (int row = 0; row < data.length; row++) {
                if (data[row] != null && col < data[row].length && data[row][col] > 0) {
                    if (row == highestStoreIndex) {
                        bonuses[row] += 5000;
                    } else if (row == lowestStoreIndex) {
                        bonuses[row] += 1000;
                    } else {
                        bonuses[row] += 2000;
                    }
                }
            }

            // Special case: if only one store has sales in this category, they should get $5000
            if (highestStoreIndex != -1 && highestStoreIndex == lowestStoreIndex) {
                bonuses[highestStoreIndex] += 4000;  // Adjust since they already got 1000 or 2000
            }
        }

        return bonuses;
    }

    /**
     * Calculates the total holiday bonuses.
     * 
     * @param data the two dimensional array of store sales
     * @return the total of all holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double totalBonus = 0;
        double[] bonuses = calculateHolidayBonus(data);

        for (double bonus : bonuses) {
            totalBonus += bonus;
        }

        return totalBonus;
    }

    /**
     * Utility method to get the maximum length of any column in the 2D array.
     * 
     * @param data the two dimensional array of store sales
     * @return the maximum column length
     */
    private static int getMaxColumnLength(double[][] data) {
        int maxLength = 0;
        for (double[] row : data) {
            if (row != null && row.length > maxLength) {
                maxLength = row.length;
            }
        }
        return maxLength;
    }
}
