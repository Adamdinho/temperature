/** 
 * Assignment 3 Temperature Unit Test
 *
 * @author Adam Pickersgill <adam.pickersgill@mail.mcgill.ca>
 * ID: 260396674
 * @version 2013.10.14
 * Unit Testing Temperature class
 */

import org.junit.* ;
import static org.junit.Assert.* ;

public class TemperatureTest {

	@Test
	public void TestGetUnitsWithKelvin() {
		System.out.println("Testing getUnits() with a Kelvin input");
		Temperature temperature = new Temperature(25, Temperature.Units.KELVIN);
		assertTrue(temperature.getUnits() == Temperature.Units.KELVIN);
	}
   
	@Test
	public void TestGetUnitsWithCelsius() {
		System.out.println("Testing getUnits() with a Celsius input");
		Temperature temperature = new Temperature(25, Temperature.Units.CELSIUS);
		assertTrue(temperature.getUnits() == Temperature.Units.CELSIUS);
	}
	
	@Test
	public void TestGetUnitsWithFahrenheit() {
		System.out.println("Testing getUnits() with a Fahrenheit input");
		Temperature temperature = new Temperature(25, Temperature.Units.FAHRENHEIT);
		assertTrue(temperature.getUnits() == Temperature.Units.FAHRENHEIT);
	}
	
	@Test
	public void TestGetValueWithFahrenheit() {
		System.out.println("Testing getValue() with a Fahrenheit input");
		Temperature temperature = new Temperature(25, Temperature.Units.FAHRENHEIT);
		assertTrue(temperature.getValue() == 25);
	
	}
	
	
	@Test
	public void TestGetValueWithCelsius() {
		System.out.println("Testing getValue() with a Celsius input");
		Temperature temperature = new Temperature(25, Temperature.Units.CELSIUS);
		assertTrue(temperature.getValue() == 25);
		
	}
	
	@Test
	public void TestGetValueWithKelvin() {
		System.out.println("Testing getValue() with a Kelvin input");
		Temperature temperature = new Temperature(25, Temperature.Units.KELVIN);
		assertTrue(temperature.getValue() == 25);

	}

	@Test
	public void TestLargeValueFahrenheit() {
		Temperature temperature2 = new Temperature(600.9349, Temperature.Units.FAHRENHEIT);
		assertTrue(temperature2.getValue() == 600.9349);
	}
	
	@Test
	public void TestNegativeValueFahrenheit() {
		Temperature temperature2 = new Temperature(-10, Temperature.Units.FAHRENHEIT);
		assertTrue(temperature2.getValue() == -10);
	}
	
	@Test
	public void TestLargeValueKelvin() {
		Temperature temperature2 = new Temperature(600.9349, Temperature.Units.KELVIN);
		assertTrue(temperature2.getValue() == 600.9349);
	}
	
	@Test
	public void TestNegativeValueKelvin() {
		Temperature temperature2 = new Temperature(-10, Temperature.Units.KELVIN);
		assertTrue(temperature2.getValue() == -10);
	}
	
	@Test
	public void TestLargeValueCelsius() {
		Temperature temperature2 = new Temperature(600.9349, Temperature.Units.CELSIUS);
		assertTrue(temperature2.getValue() == 600.9349);
	}
	
	@Test
	public void TestNegativeValueCelsius() {
		Temperature temperature2 = new Temperature(-10, Temperature.Units.CELSIUS);
		assertTrue(temperature2.getValue() == -10);
	}
	
	@Test
	public void TestChangeUnitsFromKtoC() {
		Temperature temperature = new Temperature(25, Temperature.Units.KELVIN);
		temperature.changeUnits(Temperature.Units.CELSIUS);
		assertTrue(temperature.getValue() == 25-273.15);
	}
	
	@Test
	public void TestChangeUnitsFromKtoF() {
		Temperature temperature = new Temperature(25, Temperature.Units.KELVIN);
		temperature.changeUnits(Temperature.Units.FAHRENHEIT);
		assertTrue(temperature.getValue() == -414.67);
	}
	
	@Test
	public void TestChangeUnitsFromCtoK() {
		Temperature temperature = new Temperature(25, Temperature.Units.CELSIUS);
		temperature.changeUnits(Temperature.Units.KELVIN);
		assertTrue(temperature.getValue() == 298.15);
	}
	
	@Test
	public void TestChangeUnitsFromCtoF() {
		Temperature temperature = new Temperature(25, Temperature.Units.CELSIUS);
		temperature.changeUnits(Temperature.Units.FAHRENHEIT);
		assertTrue(temperature.getValue() == 77);
	}
	
	@Test
	public void TestChangeUnitsFromFtoK() {
		Temperature temperature = new Temperature(25, Temperature.Units.FAHRENHEIT);
		temperature.changeUnits(Temperature.Units.KELVIN);
		assertTrue(temperature.getValue() == 277.038889);
	}
	
	@Test
	public void TestChangeUnitsFromFtoC() {
		Temperature temperature = new Temperature(25, Temperature.Units.FAHRENHEIT);
		temperature.changeUnits(Temperature.Units.CELSIUS);
		assertTrue(temperature.getValue() == -3.888889);
	}

}
