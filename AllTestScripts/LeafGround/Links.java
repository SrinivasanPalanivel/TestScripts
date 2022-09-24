package week2.day4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.leafground.com/link.xhtml");
		
		driver.manage().window().maximize();
		
		// Take me to dashboard
		driver.findElement(By.linkText("Go to Dashboard")).click();
		if(driver.getTitle().equals("Dashboard"))
		{
			System.out.println("Title Verified!");
		}
		else
		{
			System.out.println("Title Not Verified!");
		}
		driver.navigate().back();
		
		//Find my destination
		String destination = driver.findElement(By.partialLinkText("without clicking")).getAttribute("href");
		System.out.println("Destination Link is : "+destination);
		
		//Am I broken link?
		driver.findElement(By.linkText("Broken?")).click();
		if(driver.getTitle().contains("Error 404"))
		{
			System.out.println("Yes! I'm a Broken Link");
		}
		else
		{
			System.out.println("No! I'm Not a Broken Link");
		}
		driver.navigate().back();
		
		//Duplicate Link
		List<WebElement> duplicate = driver.findElements(By.linkText("Go to Dashboard"));
		if(duplicate.size()>=2)
		{
			System.out.println("It is Duplicate Link");
		}
		else
		{
			System.out.println("It is Not a Duplicate Link");
		}
		
		//Count Links
		driver.findElement(By.linkText("How many links in this page?")).click();
		List<WebElement> total_links = driver.findElements(By.xpath("//a"));
		System.out.println("Total Links in Page : "+total_links.size());
		driver.navigate().back();
		
		//Count Layout Links
		driver.findElement(By.partialLinkText("layout?")).click();
		List<WebElement> total_layout = driver.findElements(By.xpath("//div"));
		System.out.println("Total Layouts in Page : "+total_layout.size());
		driver.navigate().back();

	}

}
