package genericUtils;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {
	AppiumDriverLocalService service;
	AndroidDriver driver;
	@BeforeSuite
	public void database() {
		System.out.println("connected to database");
		
	}
	
	@BeforeTest
	public void parallel() {
		System.out.println("parallel execution");
	}
	@BeforeClass
	public void openserver() {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
	
	@BeforeMethod
	public void launchapp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "moto g(10) power");
		dc.setCapability(MobileCapabilityType.UDID, "ZF6526RP55");
		dc.setCapability(MobileCapabilityType.NO_RESET, "false");
		
		dc.setCapability("appPackage","com.android.calculator2");
		dc.setCapability("appActivity",".Calculator");
		
		URL ur=new URL("http://localhost:4723/wd/hub");
		driver=new AndroidDriver(ur,dc);
		driver.launchApp();
	}
	
	@AfterMethod
	public void closeapp() {
		driver.closeApp();
	}
	@AfterClass
	public void closeserver() {
		
		service.stop();
	}
	
	@AfterTest
	public void parallel1() {
		System.out.println("parallel execution");
	}
	
	@AfterSuite
	public void closedatabase() {
		System.out.println("disconnect from the database");
	}
}
