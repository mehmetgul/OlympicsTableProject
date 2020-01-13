package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.nullness.compatqual.NonNullType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;

public class Base {
	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
	}

	@AfterMethod
	public void tearOut() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
