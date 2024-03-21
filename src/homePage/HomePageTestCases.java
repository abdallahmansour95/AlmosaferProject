package homePage;
import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTestCases extends Parameters {
	
	
	
	
	@BeforeTest
	
	
	public void mySetup() {
		
		
	driver.get(URL);
		
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	WebElement popMsg = driver.findElement(By.cssSelector(".sc-iBmynh.izXFRL"));
	
	
	if (popMsg.isDisplayed()) {
		
		WebElement SarButton = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		SarButton.click();
		
		

	}

		
	}
	
	
	@Test(priority = 1)
	
	
	public void CheckTheDefultLanguageEN() {
		
		
		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		
		myAssert.assertEquals(ActualLanguage, ExpectedEnLang ,"This is Language Check ");
		
	}
	
	
	
	@Test(priority = 2)
	
	public void CheckTheDefultCurrancy() {
		
		String ActualCurrancy = driver.findElement(By.xpath("//button[normalize-space()='SAR']")).getText();
		
		myAssert.assertEquals(ActualCurrancy, ExpectedCurrancy,"This is Currancy Check");
		
	}
	
	
	
	@Test(priority=3)
	
	
	public void CheckTheDefultNumber() {
		
		
		String ActualNumber = driver.findElement(By.tagName("strong")).getText();
		
		myAssert.assertEquals(ActualNumber, ExpectedNumber,"This is Number Check");
		
		
		
	}
	
	
	 
	
	@Test(priority=4)
	
	public void CheckQitafLogo() {
		
		
		 WebElement QitafLogo = driver.findElement(By.xpath("//div[@class='sc-fihHvN eYrDjb']"));
		
	     Boolean Actualresult = QitafLogo.isDisplayed();
	     
	     myAssert.assertEquals(Actualresult, true ,"This is Qitaf Logo Check");
	 
	
	}
	
	
	@Test(priority = 5)
	
	public void CheckHotels() {
		
		WebElement HotelTap = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		
		String ActualResult = HotelTap.getAttribute("aria-selected");
		
		myAssert.assertEquals(ActualResult,  "false" , "This is Hotels Check" );
		
		
	}
	
	
	
	@Test(priority = 6)
	
	
	public void CheckFlightDate() {
		
		LocalDate today = LocalDate.now(); // we create an object called today of the class of local date 
		
		int Tomorrow = today.plusDays(1).getDayOfMonth();
		int DayAfterTomorrow = today.plusDays(2).getDayOfMonth();
		
		System.out.println(Tomorrow);
		System.out.println(DayAfterTomorrow);
		
		
		String ActualDepature = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE gmaGJq'] span[class='sc-cPuPxo dVqOVe']"))
				.getText();
		
		String ActualReturn = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP bkqiMc'] span[class='sc-cPuPxo dVqOVe']"))
				.getText();		
		
		int ActualDepDate = Integer.parseInt(ActualDepature);
		
		int ActualRetDate = Integer.parseInt(ActualReturn);
		
		
		myAssert.assertEquals(ActualDepDate,Tomorrow ,"This is Depature Check" );
		myAssert.assertEquals(ActualRetDate, DayAfterTomorrow ,"This is Return Check" );
		
		
		
	}
	
	@Test(priority = 7)
	
	public void ChangeLangRandomly() {
		
		driver.get(websites[randomWebsites]);
		
		if(driver.getCurrentUrl().contains("en")) {
			
			String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			
			myAssert.assertEquals(ActualLanguage, ExpectedEnLang ,"This is Language Check ");
			
		}
		
	
		else {
			
			String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			
			myAssert.assertEquals(ActualLanguage, ExpectedARLang );
			
			
			
			
			
		}
	
	}

}
