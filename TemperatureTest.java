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
		
		temperature = new Temperature(-50, Temperature.Units.FAHRENHEIT);
		assertTrue(temperature.getValue() == -50);
		
		temperature = new Temperature(600.889, Temperature.Units.FAHRENHEIT);
		assertTrue(temperature.getValue() == 600.889);
	}
	
	@Test
	public void TestGetValueWithCelsius() {
		System.out.println("Testing getValue() with a Celsius input");
		Temperature temperature = new Temperature(25, Temperature.Units.CELSIUS);
		assertTrue(temperature.getValue() == 25);
		
		temperature = new Temperature(-50, Temperature.Units.CELSIUS);
		assertTrue(temperature.getValue() == -50);
		
		temperature = new Temperature(600.889, Temperature.Units.CELSIUS);
		assertTrue(temperature.getValue() == 600.889);
	}
	
	@Test
	public void TestGetValueWithKelvin() {
		System.out.println("Testing getValue() with a Kelvin input");
		Temperature temperature = new Temperature(25, Temperature.Units.KELVIN);
		assertTrue(temperature.getValue() == 25);
		

		Temperature temperature2 = new Temperature(-10, Temperature.Units.KELVIN);
		assertTrue(temperature2.getValue() == -10);
		
		temperature2 = new Temperature(600.9349, Temperature.Units.KELVIN);
		assertTrue(temperature2.getValue() == 600.9349);
	}

}
