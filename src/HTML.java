import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML {
	
	public WebDriver driver;
	
	
	@BeforeTest()
	
	public void log() {
		
		
		WebDriverManager.edgedriver().setup();
		
		driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		}
	
	
		@Test()
		
		public void sort_item_low_to_high() throws InterruptedException
		
		{
			driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();			
			List<WebElement> thePricesList = driver.findElements(By.className("inventory_item_price"));
			
			List <Double> newEditedList = new ArrayList<>();
			
			for(int i =0 ; i<thePricesList.size();i++)
			{
			//System.out.println(thePricesList.get(i).getText());	
			
			String price = thePricesList.get(i).getText();
			//price.trim();
			//price.split("$");
			//System.out.println(price);
			String editedPrice = price.replace("$", "");
				
				//System.out.println(editedPrice);
				 
      double val = Double.parseDouble(editedPrice.trim());
       
               newEditedList.add(val);
      
      //System.out.println(val);
				
				
			}
		      

			
         //   System.out.println(newEditedList);
			
			for(int k =0 ; k<newEditedList.size();k++) {
				
				
				boolean checkProcess = newEditedList.get(0) <newEditedList.get(newEditedList.size()-1);
				
				//System.out.println(checkProcess);
				
				Assert.assertEquals(checkProcess, true);
				
				
				
			}
			
			
		}
	

}
