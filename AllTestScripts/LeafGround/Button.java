package week2.day4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://www.leafground.com/button.xhtml");
		
		driver.manage().window().maximize();
		
		//Click and Confirm title.
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		String page_title = driver.getTitle();
		String title = "Dashboard";
		
		if(page_title.equals(title))
		{
			System.out.println("Title Confirmed");
		}
		else
		{
			System.out.println("Title Not Confirmed");
		}
		
		driver.navigate().back();
		
		//Confirm if the button is disabled.
		boolean enabled = driver.findElement(By.xpath("(//button[@type='button'])[2]")).isEnabled();
		if(enabled==false)
			System.out.println("Button is Disabled");
		else
			System.out.println("Button is Enabled");
				
		//Find the position of the Submit button
		System.out.println("Position Of the Button : "+driver.findElement(By.xpath("(//button[@type='button'])[3]")).getLocation());
		
		//Find the Button Color
		System.out.println("RGBA Value Of the Button : "+driver.findElement(By.xpath("(//button[@type='button'])[4]")).getCssValue("background-color"));
		
		//Find the height and width of this button
		System.out.println("Height and Width of the Button : "+driver.findElement(By.xpath("(//button[@type='button'])[5]")).getSize());
		
		//Verifying the Color Change
		String int_color = driver.findElement(By.xpath("(//button[@type='button'])[6]")).getCssValue("background-color");
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.xpath("(//button[@type='button'])[6]"))).perform();
		String final_color = driver.findElement(By.xpath("(//button[@type='button'])[6]")).getCssValue("background-color");
		
		if(int_color.equals(final_color))
		{
			System.out.println("Clolor Change Not Confirmed!!!");
		}
		else
		{
			System.out.println("Clolor Change Confirmed");
		}
		
		//Click Image Button and Click on any hidden button
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		
		//How many rounded buttons are there?
		List<WebElement> buttons = driver.findElements(By.xpath("(//div[@class='card'])[7]/button"));
		Thread.sleep(1000);
		System.out.println("No.Of Buttons : "+buttons.size());

	}

}
