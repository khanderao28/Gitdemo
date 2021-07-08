package mavenproject.mavenextend;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DemoTest {

	WebDriver d;
	ExtentReports extent;
		
	
		
	
		@BeforeTest
		public   void config() {
			
		String path=	System.getProperty("user.dir")+"\\reports\\index.html";
			
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		
		reporter.config().setReportName("results of tests");
		reporter.config().setDocumentTitle("Test results");
		
		 extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester", "Khanderao Thorat");
		}
	
		
		
		
	@BeforeClass
	public void initiate() {
		
		extent.createTest("initial");
		System.setProperty("webdriver.chrome.driver", "C:\\abcd\\chromedriver.exe");
		d = new ChromeDriver();
		// d.manage().window().maximize();

		// Action a = new Action(d);

		/// d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		d.get("https://www.google.com/");
		

	}

	@Test(priority = 2)

	public void demo() throws IOException {
		
		extent.createTest("Demo");
		// System.out.println("hello");
		System.out.println("takiig  srcs");
		File src = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("E://facebook.png"));

	}

	@SuppressWarnings("null")
	@Test(priority = 1)

	public void login() {
		extent.createTest("login");
		System.out.println("hello2");
		System.out.println("hello4");
		System.out.println("hello5");
		System.out.println("jhello6");
		
	}

	
	@Test()
	public void add1()
	{
		System.out.println("hello21");
		System.out.println("hello12");
	}
	
	@AfterTest

	public void closeb() {
		System.out.println("closig");
		extent.flush();
		d.quit();
		
	}

}
