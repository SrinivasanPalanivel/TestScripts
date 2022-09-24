package week4.day8;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		
		// Switching to Main Window
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.nykaa.com/");
		
		driver.manage().window().maximize();
		
		//Using Action Class
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(brands).perform();
		
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		
		//Confirming Title
		String title = driver.getTitle();
		
		if(title.contains("L'Oreal Paris"))
			System.out.println("Title Verified Sucessfully!!");
		else
			System.out.println("Title Not Verified Sucessfully!!");
		
		//Selecting Product
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//span[contains(text(),'Sort By')]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'rated')]")).click();
		
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		//js.executeScript("arguments[0].scrollIntoView()", Category);
		
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[contains(text(),'Colour Protect')]")).click();
		Thread.sleep(1000);
		
		//Handling window
		Set<String> windowHandles2 = driver.getWindowHandles();
		ArrayList<String> list1 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(list1.get(2));
		
		WebElement ml = driver.findElement(By.className("css-2t5nwu"));
		Select dd = new Select(ml);
		dd.selectByVisibleText("175ml");
		
		String mrp = driver.findElement(By.xpath("(//span[text()='MRP:'])[1]/following-sibling::span")).getText();
		System.out.println("Total Cost of the Product : "+mrp);
		
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
		
		driver.findElement(By.className("css-g4vs13")).click();
		Thread.sleep(3000);
		
		//Swithching Frame
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(frame);
		System.out.println("Sucesssfully Swithched Frame");
		Thread.sleep(2500);
		String total = driver.findElement(By.xpath("(//div[contains(@class,'value')])[4]")).getText();
		System.out.println("Grand Total : "+total);
		
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		String total1 = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		
		if(total.equals(total1))
			System.out.println("Same Grand Total Only!!");
		else
			System.out.println("Grand Total Changed!!");
		
		System.out.println("---------------------------");
		System.out.println("All Test Passed...");
		System.out.println("---------------------------");
		
		driver.quit();
	}

}
