package hotelSearch;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class Parameters {

	WebDriver driver = new ChromeDriver();
	
	String URL ="https://www.almosafer.com/en";
	
	String [] ArabicCities = {"  جدة ","دبي"};
	
	String [] EnglishCities = {"Dubai","Jeddah","Riyadh"};
	
	
	Random rand = new Random();
	
	int randomArbicCity = rand.nextInt(ArabicCities.length);
	
	int randomEnglishCity = rand.nextInt(EnglishCities.length);
	
	int vistorNumber  = rand.nextInt(2);
	
	Assertion myAssert = new Assertion();
	
	
}
