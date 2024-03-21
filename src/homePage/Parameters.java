package homePage;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class Parameters {
	
	WebDriver driver = new ChromeDriver();
	
	String URL ="https://www.almosafer.com/en";
	
	String ExpectedEnLang = "en";
	
	String ExpectedARLang ="ar";
	
	String ExpectedCurrancy ="SAR";
	
	String ExpectedNumber ="+966554400000";
	
	Assertion myAssert = new Assertion();
	
	Random rand = new Random();
	
	String[] websites = {"https://www.almosafer.com/en","https://www.almosafer.com/ar"};
	
	int randomWebsites = rand.nextInt(websites.length);
	
	
	
	

}


