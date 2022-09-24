package week2.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InputComponents {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://www.leafground.com/input.xhtml;jsessionid=node0tmb2389go0xlxjvuy66xu9p668024.node0");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//input[@placeholder='Babu Manickam']")).clear();
		//Type your name
		driver.findElement(By.xpath("//input[@placeholder='Babu Manickam']")).sendKeys("Srinivasan");
		
		//Append Country to this City.
		driver.findElement(By.xpath("//input[@value='Chennai']")).sendKeys(", India.");
		
		//Verify if text box is disabled
		boolean enabled = driver.findElement(By.xpath("//input[@placeholder='Disabled']")).isEnabled();
		if(enabled==false)
			System.out.println("Button is Disabled");
		else
			System.out.println("Button is Enabled");
		
		//Clear the typed text.
		driver.findElement(By.xpath("//input[@value='Can you clear me, please?']")).clear();
	
		//Retrieve the typed text.
		System.out.println(driver.findElement(By.xpath("//input[@value='My learning is superb so far.']")).getAttribute("value"));
		
		//Type email and Tab. Confirm control moved to next element.
		driver.findElement(By.xpath("//input[contains(@placeholder , 'email')]")).sendKeys("selenium@gmail.com",Keys.TAB);
		WebElement activeElement = driver.switchTo().activeElement();
		String text1= activeElement.getAttribute("placeholder");
		if(text1.equals("About yourself"))
			System.out.println("Focus Moved To Next Tab Sucessfully!!!");
		else
			System.out.println("Still Focus in Same Tab");
				
		//Type about yourself
		driver.findElement(By.xpath("//textarea[@placeholder='About yourself']")).sendKeys("I'm Srinivasan");
		
		//Text Editor
		driver.findElement(By.xpath("//span[@class='ql-picker-label']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@data-value='monospace']")).click();
		driver.findElement(By.xpath("//button[@class='ql-bold']")).click();
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("Ena Koduma Saravana");
		
		//Just Press Enter and confirm error message*
		driver.findElement(By.xpath("(//input[@role='textbox'])[7]")).sendKeys(Keys.ENTER);
		String error = driver.findElement(By.xpath("//span[contains(text(),'mandatory')]")).getText();
		System.out.println("Error Message is : "+error);
		
		//Click and Confirm Label Position Changes
		Point initial_loc = driver.findElement(By.xpath("(//input[@role='textbox'])[8]")).getLocation();
		driver.findElement(By.xpath("(//input[@role='textbox'])[8]")).click();
		Point final_loc = driver.findElement(By.xpath("(//input[@role='textbox'])[8]")).getLocation();
		if(initial_loc==final_loc)
			System.out.println("Position Have Not Changed");
		else
			System.out.println("Position Have Changed");
		
		//Type your name and choose the third option
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role='application']/ul/li/input")).sendKeys("Srinivasan");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@data-item-label='Srinivasan2']")).click();
		
		//Type your DOB (mm/dd/yyyy) and confirm date chosen
		driver.findElement(By.xpath("(//input[@role='textbox'])[9]")).sendKeys("07/02/1998");
		String month = driver.findElement(By.xpath("//span[contains(@class,'month')]")).getText();
		String year = driver.findElement(By.xpath("//span[contains(@class,'year')]")).getText();
		String day = driver.findElement(By.xpath("//a[text()='2']")).getText();
		System.out.println("DOB : "+month+"-"+day+"-"+year);
		
		//Type number and spin to confirm value changed
		driver.findElement(By.xpath("(//input[@role='textbox'])[10]")).sendKeys("7");
		driver.findElement(By.xpath("(//span[@class='ui-button-text']/span)[1]")).click();
		String num = driver.findElement(By.xpath("(//input[@role='textbox'])[10]")).getAttribute("aria-valuenow");
		System.out.println("Spinned Value Changed to : "+num);
		
		//Type random number (1-100) and confirm slider moves correctly
		Point slider1 = driver.findElement(By.xpath("(//h5[contains(text(),'slider')]/following::span)[1]")).getLocation();
		driver.findElement(By.xpath("(//input[@role='textbox'])[11]")).sendKeys("27");
		Point slider2 = driver.findElement(By.xpath("(//h5[contains(text(),'slider')]/following::span)[1]")).getLocation();
		if(slider1==slider2)
			System.out.println("Slider have Not Moved");
		else
			System.out.println("Slider Moved Sucessfully");
		
		//Click and Confirm Keyboard appears
		driver.findElement(By.xpath("(//input[@role='textbox'])[12]")).click();
		Thread.sleep(1000);
		String key = driver.findElement(By.xpath("//div[contains(@class,'keypad-popup')]/div/button[text()='@']")).getText();
		if(key.equals("@"))
			System.out.println("Keyboard Apperance Confirmed");
		else
			System.out.println("Keyboard Not Appered");
		driver.findElement(By.xpath("//div[contains(@class,'keypad-popup')]/div/button[@title='Close the keypad']")).click();
		
		//Custom Toolbar
		driver.findElement(By.xpath("(//button[@class='ql-italic'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[2]")).sendKeys("Thank You!!!");
		
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("All Condition Satisfied & Test passed");
		System.out.println("-----------------------------------------------");
	}

}
