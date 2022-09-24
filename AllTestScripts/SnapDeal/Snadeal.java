package week4.day8;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snadeal {


	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		
		// Switching to Main Window
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.snapdeal.com/");
		
		driver.manage().window().maximize();
		
		//Go to Mens Fashion
		WebElement men = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(men).perform();
		
		//Go to Sports Shoes
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		
		//Get the count of the sports shoes
		WebElement count = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]"));
		System.out.println("Total Number of Sports Shoes : "+count.getText());
		
		//Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(2000);
		
		//Sort by Low to High
		driver.findElement(By.xpath("//div[contains(text(),'Popularity')]")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		Thread.sleep(2000);
		
		//Check if the items displayed are sorted correctly
		List<WebElement> shoes = driver.findElements(By.xpath("(//div[@class='lfloat marR10']/span[2])"));
		for(WebElement shoe : shoes)
		{
			System.out.println(shoe.getText());
		}
		Thread.sleep(2000);
		
		//Select the price range (900-1200)
		WebElement from = driver.findElement(By.name("fromVal"));
		from.clear();
		from.sendKeys("500");
		
		WebElement to = driver.findElement(By.name("toVal"));
		to.clear();
		to.sendKeys("1200");
		
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(2000);
		
		//Filter with color Navy
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		Thread.sleep(2000);
		
		//verify the all applied filters 
		String val1 = driver.findElement(By.className("from-price-text")).getText();
		String val2 = driver.findElement(By.className("to-price-text")).getText();
		
		if(val1.contains("500") && val2.contains("1200"))
			System.out.println("Filter Applied Correctly!!");
		else
			System.out.println("Filter Not Applied!!");
		
		//Mouse Hover on first resulting Training shoes
		WebElement mouse = driver.findElement(By.xpath("//p[contains(text(),'Columbus')]"));
		action.moveToElement(mouse).perform();
		
		//click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick')]")).click();
		Thread.sleep(3000);
		/*	Set<String> windowHandles2 = driver.getWindowHandles();
		ArrayList<String> list2= new ArrayList<String>(windowHandles2);
		driver.switchTo().window(list2.get(2)); */
		
		//Print the cost and the discount percentage
		String price = driver.findElement(By.className("payBlkBig")).getText();
		System.out.println("Cost of the Shoe : "+price);
		String discount = driver.findElement(By.className("percent-desc")).getText();
		System.out.println("Discounted Percentage : "+discount);
		
		//Take the snapshot of the shoes.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File ("./Snaps/SnapDeal.jpg");
		FileUtils.copyFile(source, destination);
		
		//Close the current window
		driver.findElement(By.xpath("//div[contains(@class,'marR10')]/i")).click();
		
		//Close the main window
		System.out.println("--------------------------------");
		System.out.println("All Test Passed Sucessfully!!!");
		System.out.println("---------------------------------");
		driver.close();
		
		
		

	}

}
