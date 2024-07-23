import assignments.holiday_bonus.solution.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/*
 * Class: CMSC203 
 * Instructor:Grigoriy A. Grinberg
 * Description: A class that tests all the methods inside the HolidayBonus class.
 * Due: 07/22/2024
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Afor Njoh
*/
public class HolidayBonusTestStudent {

    private double[][] salesData1 = {{1000, 2000, 3000}, {4000, 5000}, {6000, 7000, 8000}};
    private double[][] salesData2 = {{500, -1000, 1500}, {0, 2000}, {3000, 1000}};
    private double[][] salesData3 = {{10000}, {2000, 3000}};
    private double[][] nullData = {null, {1000, 2000}, null};

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculateHolidayBonus() {
        double[] bonuses = HolidayBonus.calculateHolidayBonus(salesData1);
        assertEquals(5000.0, bonuses[0], 0.001);
        assertEquals(1000.0, bonuses[1], 0.001);
        assertEquals(2000.0, bonuses[2], 0.001);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(salesData1);
        assertEquals(30000.0, totalBonus, 0.001);
    }
    
    @Test
    public void testCalculateHolidayBonusWithNegativeAndZero() {
        double[] bonuses = HolidayBonus.calculateHolidayBonus(salesData2);
        assertEquals(5000.0, bonuses[0], 0.001);
        assertEquals(2000.0, bonuses[1], 0.001);
        assertEquals(2000.0, bonuses[2], 0.001);
    }
    
    @Test
    public void testCalculateTotalHolidayBonusWithNegativeAndZero() {
        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(salesData2);
        assertEquals(30000.0, totalBonus, 0.001);
    }
    
    @Test
    public void testCalculateHolidayBonusWithSingleStorePerCategory() {
        double[] bonuses = HolidayBonus.calculateHolidayBonus(salesData3);
        assertEquals(5000.0, bonuses[0], 0.001);
        assertEquals(2000.0, bonuses[1], 0.001);
    }
    
    @Test
    public void testCalculateTotalHolidayBonusWithSingleStorePerCategory() {
        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(salesData3);
        assertEquals(7000.0, totalBonus, 0.001);
    }
    
    @Test
    public void testCalculateHolidayBonusWithNullValues() {
        double[] bonuses = HolidayBonus.calculateHolidayBonus(nullData);
        assertEquals(2000.0, bonuses[1], 0.001);
    }
    
    @Test
    public void testCalculateTotalHolidayBonusWithNullValues() {
        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(nullData);
        assertEquals(2000.0, totalBonus, 0.001);
    }
}
