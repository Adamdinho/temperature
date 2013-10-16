/** 
 * Assignment 3 Temperature Unit Test
 *
 * @author Adam Pickersgill <adam.pickersgill@mail.mcgill.ca>
 * ID: 260396674
 * @version 2013.10.15
 * Unit Testing Temperature class
 */

import org.junit.* ;
import static org.junit.Assert.* ;

public class TemperatureTest {

	/**
	 * Testing the getUnits() method is quite straightforward. All test cases
	 * pass and this method works well except if a null argument is given in the
	 * constructor, the code does not robustly handle that. Should handle it in 
	 * some way, possibly by defaulting to Kelvin?
	 */
	@Test
	public void TestGetUnitsWithNull() {
		Temperature temperature = new Temperature(25, null);
		assertTrue(temperature.getUnits() == null);
	}
	
	@Test
	public void TestGetUnitsWithKelvin() {
		Temperature temperature = new Temperature(25, Temperature.Units.KELVIN);
		assertTrue(temperature.getUnits() == Temperature.Units.KELVIN);
	}
   
	@Test
	public void TestGetUnitsWithCelsius() {
		Temperature temperature = new Temperature(25, Temperature.Units.CELSIUS);
		assertTrue(temperature.getUnits() == Temperature.Units.CELSIUS);
	}
	
	@Test
	public void TestGetUnitsWithFahrenheit() {
		Temperature temperature = new Temperature(25, Temperature.Units.FAHRENHEIT);
		assertTrue(temperature.getUnits() == Temperature.Units.FAHRENHEIT);
	}
	
	
	/**
	 * Many Of the Fahrenheit test cases fail, this should be reviewed and fixed before
	 * development continues, further information is included below.
	 * 
	 * In total 4 Fail and 3 Pass
	 */
	
	// Basic Good Data Value, Test Case Fails
	@Test
	public void TestGetValueWithFahrenheit() {
		Temperature temperature = new Temperature(25, Temperature.Units.FAHRENHEIT);
		assertTrue(temperature.getValue() == 25);
	
	}
	
	// Test for a large temperature value, Test Case Passes
	@Test
	public void TestLargeValueFahrenheit() {
		Temperature temperature2 = new Temperature(60000, Temperature.Units.FAHRENHEIT);
		assertTrue(temperature2.getValue() == 60000);
	}
	
	// Test for negative Fahrenheit values, Test Case FAILS
	@Test
	public void TestNegativeValueFahrenheit() {
		Temperature temperature2 = new Temperature(-10, Temperature.Units.FAHRENHEIT);
		assertTrue(temperature2.getValue() == -10);
	}
	
	// Test for minimal value of Fahrenheit (Absolute Zero), Test Case PASSES
	@Test
	public void TestMinimalValueFahrenheit() {
		Temperature temperature2 = new Temperature(-459.67, Temperature.Units.FAHRENHEIT);
		assertTrue(temperature2.getValue() == -459.67);
	}
	
	// Test for zero values of Fahrenheit, Test Case FAILS
	@Test
	public void TestZeroValueFahrenheit() {
		Temperature temperature2 = new Temperature(0, Temperature.Units.FAHRENHEIT);
		assertTrue(temperature2.getValue() == 0);
	}
	
	// Test for more precise temperature values, Test Case FAILS
	@Test
	public void TestPreciseValueFahrenheit() {
		Temperature temperature2 = new Temperature(25.659874, Temperature.Units.FAHRENHEIT);
		assertTrue(temperature2.getValue() == 25.659874);
	}
	
	// Test for values below absolute zero, Test Case PASSES
	@Test
	public void TestOutOfBoundsValueFahrenheit() {
		Temperature temperature2 = new Temperature(-460, Temperature.Units.FAHRENHEIT);
		assertTrue(temperature2.getValue() == -460);
	}
	
	

	/**
	 * All tests pass with Kelvin, however the converter accepts impossible values,
	 * such as values below absolute zero (0 Kelvin) which may be against specifications
	 * Would recommend improvement in this area.
	 */
	
	// Default Test Value, Good Data
	@Test
	public void TestGetValueWithKelvin() {
		Temperature temperature = new Temperature(300, Temperature.Units.KELVIN);
		assertTrue(temperature.getValue() == 300);

	}

	// An arbitrary value that is larger than most relevant values (Maximal Good Data)
	@Test
	public void TestLargeValueKelvin() {
		Temperature temperature2 = new Temperature(60000, Temperature.Units.KELVIN);
		assertTrue(temperature2.getValue() == 60000);
	}
	
	//The lowest theoretical value (Minimal Good Data)
	@Test
	public void TestMinimalValueKelvin() {
		Temperature temperature2 = new Temperature(0, Temperature.Units.KELVIN);
		assertTrue(temperature2.getValue() == 0);
	}
	
	//Invalid Input, Test Case still passes, so problem as mentioned above
	@Test
	public void TestOutofBoundsValueKelvin() {
		Temperature temperature2 = new Temperature(-10, Temperature.Units.KELVIN);
		assertTrue(temperature2.getValue() == -10);
	}
	
	//More Good Data but with higher level of precision to see if the calculations stay consistent
	@Test
	public void TestPreciseValueKelvin() {
		Temperature temperature2 = new Temperature(25.659874, Temperature.Units.KELVIN);
		assertTrue(temperature2.getValue() == 25.659874);
	}
	
	
	/**
	 * Most Test Cases pass which is good except for the test case which covers
	 * invalid input in the form of a Temperature below Absolute Zero, this may
	 * be against specifications. The Test Case for precise temperatures (10^-6)
	 * Also failed, if the specifications suggest that the temperatures must be
	 * this precise then there should be some debugging done to ensure this.
	 */
	
	// Basic Median Good Data
	@Test
	public void TestGetValueWithCelsius() {
		Temperature temperature = new Temperature(25, Temperature.Units.CELSIUS);
		assertTrue(temperature.getValue() == 25);
		
	}
	
	// Large value (Maximal Good Data)
	@Test
	public void TestLargeValueCelsius() {
		Temperature temperature2 = new Temperature(60000, Temperature.Units.CELSIUS);
		assertTrue(temperature2.getValue() == 60000);
	}
	
	
	// Negative Value Test
	@Test
	public void TestNegativeValueCelsius() {
		Temperature temperature2 = new Temperature(-10, Temperature.Units.CELSIUS);
		assertTrue(temperature2.getValue() == -10);
	}
	
	//Minimal Value Test (Absolute Zero)
	@Test
	public void TestMinimalValueCelsius() {
		Temperature temperature2 = new Temperature(-273.15, Temperature.Units.CELSIUS);
		assertTrue(temperature2.getValue() == -273.15);
	}
	
	// Test For Handling Zeroes (special Case)
	@Test
	public void TestZeroValueCelsius() {
		Temperature temperature2 = new Temperature(0, Temperature.Units.CELSIUS);
		assertTrue(temperature2.getValue() == 0);
	}
	
	//Test for temperature below Absolute Zero, should probably not pass.
	@Test
	public void TestOutOfBoundsValueCelsius() {
		Temperature temperature2 = new Temperature(-300, Temperature.Units.CELSIUS);
		assertTrue(temperature2.getValue() == -300);
	}
	
	// Test for Temperature with additional precision
	@Test
	public void TestPreciseValueCelsius() {
		Temperature temperature2 = new Temperature(25.659874, Temperature.Units.CELSIUS);
		assertTrue(temperature2.getValue() == 25.659874);
	}
	
	
	/**
	 * As all six conversions are tested, some passed and others failed,
	 * it appears most of the failures happen when converting to or from 
	 * fahrenheit. Further details are included below, All conversions were
	 * from 25 degrees of the unit of measure converted from.
	 */
	
	// Test PASSES
	@Test
	public void TestChangeUnitsFromKtoC() {
		Temperature temperature = new Temperature(25, Temperature.Units.KELVIN);
		temperature.changeUnits(Temperature.Units.CELSIUS);
		assertTrue(temperature.getValue() == 25-273.15);
	}
	
	// Test PASSES 
	@Test
	public void TestChangeUnitsFromKtoF() {
		Temperature temperature = new Temperature(25, Temperature.Units.KELVIN);
		temperature.changeUnits(Temperature.Units.FAHRENHEIT);
		assertTrue(temperature.getValue() == -414.67);
	}
	
	// Test PASSES
	@Test
	public void TestChangeUnitsFromCtoK() {
		Temperature temperature = new Temperature(25, Temperature.Units.CELSIUS);
		temperature.changeUnits(Temperature.Units.KELVIN);
		assertTrue(temperature.getValue() == 298.15);
	}
	
	// Test FAILS
	@Test
	public void TestChangeUnitsFromCtoF() {
		Temperature temperature = new Temperature(25, Temperature.Units.CELSIUS);
		temperature.changeUnits(Temperature.Units.FAHRENHEIT);
		assertTrue(temperature.getValue() == 77);
	}
	
	// Test FAILS
	@Test
	public void TestChangeUnitsFromFtoK() {
		Temperature temperature = new Temperature(25, Temperature.Units.FAHRENHEIT);
		temperature.changeUnits(Temperature.Units.KELVIN);
		assertTrue(temperature.getValue() == 277.038889);
	}
	
	// Test FAILS
	@Test
	public void TestChangeUnitsFromFtoC() {
		Temperature temperature = new Temperature(25, Temperature.Units.FAHRENHEIT);
		temperature.changeUnits(Temperature.Units.CELSIUS);
		assertTrue(temperature.getValue() == -3.888889);
	}

}
