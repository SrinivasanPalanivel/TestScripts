package week2.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.leafground.com/checkbox.xhtml");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//Maximize Window
		driver.manage().window().maximize();
		
		//Selecting basic ChechBox
		driver.findElement(By.xpath("(//span[@class='ui-chkbox-icon ui-icon ui-icon-blank ui-c'])[1]/parent::div")).click();
		
		//Selecting Notification CheckBox
		driver.findElement(By.xpath("(//div[contains(@class,'ui-chkbox-box')])[2]")).click();
		
		//Choosing languages
		driver.findElement(By.xpath("(//div[contains(@class,'ui-chkbox-box')])[3]")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'ui-chkbox-box')])[4]")).click();
		
		//TriState CheckBox
		for(int i=1; i<=3; i++)
		{
			Thread.sleep(500);
			driver.findElement(By.xpath("(//div[contains(@class,'ui-chkbox-box')])[8]")).click();
			Thread.sleep(500);
			String state = driver.findElement(By.xpath("//p[contains(text(),'State')]")).getText();
			System.out.println("Button States Changing To : "+state);
		}
		
		//Toggle
		driver.findElement(By.xpath("//div[contains(@class,'toggleswitch-slider')]")).click();
		
		//Verify if check box is disabled
		boolean enabled = driver.findElement(By.xpath("(//div[@class='grid formgrid']//input)[9]")).isEnabled();
		if(enabled==false)
			System.out.println("Button is Disabled");
		else
			System.out.println("Button is Enabled");
		
		//Select Multiple
		driver.findElement(By.xpath("//span[contains(@class,'ui-icon-triangle')]")).click();
		
		driver.findElement(By.xpath("//li[@data-item-value='London']//div[2]")).click();
		driver.findElement(By.xpath("//li[@data-item-value='Paris']//div[2]")).click();
		
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-close']")).click();
	

	}

}
