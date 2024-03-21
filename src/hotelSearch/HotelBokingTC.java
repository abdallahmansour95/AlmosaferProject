package hotelSearch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HotelBokingTC extends Parameters {
	
	
	
	
	
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
	
	
	
	public void SelectHotelRand() {
		
		
		WebElement HotelTap = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTap.click();
		
		WebElement SearchInput = driver.findElement(By.xpath("//input[@data-testid=\"AutoCompleteInput\"]"));
		
		if(driver.getCurrentUrl().contains("en")) {
			
			SearchInput.sendKeys(EnglishCities[randomEnglishCity]);
			
			WebElement ResultsList = driver.findElement(By.xpath("//ul[@data-testid='AutoCompleteResultsList']")); 
			ResultsList.findElements(By.tagName("li")).get(1).click();
			
			
			
		}
		
		else {
			
			
			SearchInput.sendKeys(ArabicCities[randomArbicCity]);
			
			WebElement ResultsList = driver.findElement(By.xpath("//ul[@data-testid='AutoCompleteResultsList']")); 
			ResultsList.findElements(By.tagName("li")).get(1).click();
			
		}
		
		
	}
	
	
	
	@Test(priority = 2)
	
	
	public void SelectVistorNumb() {
		
		
		WebElement SelectVistorNum = driver.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		
		Select selector = new Select(SelectVistorNum);
		
		selector.selectByIndex(vistorNumber );
		
		
		WebElement HotelSearchBtn =  driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		
		HotelSearchBtn.click();
		
		
		
	}
	
	
	@Test(priority = 3)
	
	public void PageFullyCompleted() throws InterruptedException {
		
		Thread.sleep(10000);
		
		WebElement ResultFound = driver.findElement(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']"));
		
		String ResultFoundText = ResultFound.getText();
		
		myAssert.assertEquals(ResultFoundText.contains("found "), true , "This is Search Result Check");
		
		
	}
	
	
	@Test(priority = 4)
	
	
	public void SortPriceLowtoHigh() throws InterruptedException {
		
		Thread.sleep(2000);
		
		WebElement LowestPricceBtn= driver.findElement(By.xpath(" //button[@data-testid='HotelSearchResult__sort__LOWEST_PRICE']"));
		
		LowestPricceBtn.click();
		
		Thread.sleep(2000);
		
		WebElement PriceContainer = driver.findElement(By.xpath("//div[@class='sc-htpNat KtFsv col-9']"));
		
		
		List <WebElement> Prices = PriceContainer.findElements(By.className("Price__Value"));
		
		
		int FirstPrice = Integer.parseInt(Prices.get(0).getText());
		
		int LastParice = Integer.parseInt(Prices.get(Prices.size()-1).getText());
		
		System.out.println(FirstPrice);
		System.out.println(LastParice);
		
		myAssert.assertEquals(FirstPrice<LastParice,true , "This is price Sorting Check");
	}
	
	
	
	

}
