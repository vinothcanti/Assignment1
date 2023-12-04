package com.base;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {
	
	public static  WebDriver driver; 
	public static Properties prop;
	ExtentReports ExtentReports;
	ExtentTest extentTest;

	public Base() {
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"/src/main/java/com/qnode/qa/testdata/Testdata.properties");
		try {
			FileInputStream fis =new FileInputStream(propFile);
			prop.load(fis);
		}catch(Throwable e) {			
			e.printStackTrace();
		}
	}
	@BeforeTest
	public void launchchrome() {
		driver = new ChromeDriver();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		System.out.println("Chrome launched successfully");
	}
	@AfterTest
	public void browserclose()
	{
		driver.close(); 
		System.out.println("Browser closed successfully");
	}

	//method for extent reporting
	@BeforeTest
	public void getnameMethod(ITestContext context) {

		extentTest = ExtentReports.createTest(context.getName());
	}

	@BeforeSuite
	public void InitExtentReport() {

		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("testreport_extent.html");
		ExtentReports = new ExtentReports();
		ExtentReports.attachReporter(sparkreporter);
	}

	//to generate extent report
	@AfterSuite
	public void generateReports() throws IOException {
		ExtentReports.flush();
		Desktop.getDesktop().browse(new File("testreport_extent.html").toURI());
	}

	@AfterMethod
	public void generateStatus(Method m, ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("capture the screenchot on failure");
			extentTest.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(m.getName() + "is passed");
		}
	}
}
