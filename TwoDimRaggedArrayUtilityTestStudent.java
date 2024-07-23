import assignments.holiday_bonus.solution.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/*
 * Class: CMSC203 
 * Instructor:Grigoriy A. Grinberg
 * Description: A class that tests all the methods inside the TwoDimRaggedArrayUtility class.
 * Due: 07/22/2024
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Afor Njoh
*/
public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] array1 = {{1.0, 2.0, 3.0}, {4.0, 5.0}, {6.0, 7.0, 8.0}};
    private double[][] array2 = {{-1.0, -2.0}, {0.0, 2.0, 4.0}};
    private double[][] array3 = {{5.0}, {10.0, 20.0}};
    private double[][] nullArray = {null, {1.0, 2.0}, null};

    private File file;
    
    @Before
    public void setUp() throws Exception {
        file = new File("testfile.txt");
    }

    @After
    public void tearDown() throws Exception {
        file = null;
    }

    @Test
    public void testGetTotal() {
        assertEquals(36.0, TwoDimRaggedArrayUtility.getTotal(array1), 0.001);
        assertEquals(3.0, TwoDimRaggedArrayUtility.getTotal(array2), 0.001);
    }

    @Test
    public void testGetAverage() {
        assertEquals(4.0, TwoDimRaggedArrayUtility.getAverage(array1), 0.001);
        assertEquals(0.6, TwoDimRaggedArrayUtility.getAverage(array2), 0.001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(array1, 0), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(array2, 1), 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(array1, 0), 0.001);
        assertEquals(7.0, TwoDimRaggedArrayUtility.getColumnTotal(array2, 1), 0.001);
    }

    @Test
    public void testGetHighestInArray() {
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInArray(array1), 0.001);
        assertEquals(4.0, TwoDimRaggedArrayUtility.getHighestInArray(array2), 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(array1), 0.001);
        assertEquals(-2.0, TwoDimRaggedArrayUtility.getLowestInArray(array2), 0.001);
    }

    @Test
    public void testReadFile() throws FileNotFoundException {
        // Assuming the file content matches array1
        double[][] result = TwoDimRaggedArrayUtility.readFile(file);
        assertArrayEquals(array1, result);
    }

    @Test
    public void testWriteToFile() throws IOException {
        TwoDimRaggedArrayUtility.writeToFile(array1, file);
        double[][] result = TwoDimRaggedArrayUtility.readFile(file);
        assertArrayEquals(array1, result);
    }
    
    @Test
    public void testNullValues() {
        assertEquals(3.0, TwoDimRaggedArrayUtility.getRowTotal(nullArray, 1), 0.001);
        assertEquals(0.0, TwoDimRaggedArrayUtility.getTotal(nullArray), 0.001);
        assertEquals(1.5, TwoDimRaggedArrayUtility.getAverage(nullArray), 0.001);
    }
}
