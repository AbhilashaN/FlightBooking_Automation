import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automate4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:/Users/hp 1/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("https://www.easemytrip.com/");
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		Date date = new Date();
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
	    String s = formatter.format(new Date());
	    System.out.println(s);
//	    String[] dt = new String[3];
//	    dt = s.split("/", 3);
//	    for (String a : dt) 
//            System.out.println(a);
        
		//From
		act.moveToElement(driver.findElement(By.xpath("//input[@placeholder='From' and @onclick]"))).click().sendKeys("Bangalore").perform();
		//To
		act.moveToElement(driver.findElement(By.xpath("//input[@placeholder='From' and @onclick]/..//span[text()='Bangalore(BLR)']"))).click().perform();
		
		act.moveToElement(driver.findElement(By.xpath("//input[@placeholder='To' and @onclick]"))).click().sendKeys("Delhi").perform();
		act.moveToElement(driver.findElement(By.xpath("//input[@placeholder='To' and @onclick]/..//span[text()='Delhi(DEL)']"))).click().perform();
		act.moveToElement(driver.findElement(By.xpath("(//div[@id='searchMultiCity']//preceding-sibling::div)[5]/div/a/span"))).click().perform();
		
		//date picker
		act.moveToElement(driver.findElement(By.xpath("//input[@id='ddate']"))).click().perform();
		//date
		act.moveToElement(driver.findElement(By.xpath("(//span[@id='"+s+"']/../following-sibling::li)[1]"))).click().perform();
		
		act.moveToElement(driver.findElement(By.xpath("//input[@name='quantity' and @id='optAdult']/../following-sibling::div[@class='pl']/input"))).click().perform();
		act.moveToElement(driver.findElement(By.xpath("(//input[@id='optChild']/..//following-sibling::div)[1]/input"))).click().perform();
		act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),' Economy') and not(contains(@class,'Mul'))]"))).click().perform();
		act.moveToElement(driver.findElement(By.xpath("(//a[@id='tripType']/preceding-sibling::label)[3]/span"))).click().perform();
		act.moveToElement(driver.findElement(By.xpath("//a[@id='tripType']"))).click().perform();
		//Search Button
		act.moveToElement(driver.findElement(By.xpath("//input[@value='Search' and contains(@onclick,'Visit')]"))).click().perform();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[contains(text(),'Price Range')]/..//span)[1]"))));
		//price slider
		act.dragAndDropBy(driver.findElement(By.xpath("(//div[contains(text(),'Price Range')]/..//span)[1]")), 75, 0).perform();
		System.out.println(driver.findElement(By.xpath("(//span[text()='858'])[2]/../..")).getText());
		System.out.println(driver.findElement(By.xpath("(//div[text()='221,199'])[1]")).getText());
		String price = driver.findElement(By.xpath("(//div[text()='221,199'])[1]")).getText();
		//Book Now button
		act.moveToElement(driver.findElement(By.xpath("(//div[text()='221,199'])[1]/../../following-sibling::div/button"))).click().perform();
		String total = driver.findElement(By.xpath("//div[contains(text(),'Grand Total')]/..//span")).getText();
		System.out.println(price.equalsIgnoreCase(total));
	}

}
