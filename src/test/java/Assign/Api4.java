package Assign;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Api4 {
	AndroidDriver driver;

	@Test
	public void apilaunch() throws MalformedURLException, Throwable
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"moto g(10) power");
		dc.setCapability(MobileCapabilityType.UDID,"ZF6526RP55");
		dc.setCapability("appPackage","io.appium.android.apis");
		dc.setCapability("appActivity",".ApiDemos");
		
		URL ur=new URL("http://localhost:4723/wd/hub");
		driver=new AndroidDriver(ur,dc);
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		
		
		WebElement views = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
		tapaction(1,views);
		WebElement controlsbtn = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Controls\"]"));
		tapaction(1, controlsbtn);
		WebElement lighttheme = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Light Theme\"]"));
		tapaction(1, lighttheme);
		WebElement text = driver.findElement(By.id("io.appium.android.apis:id/edit"));
		tapaction(1, text);
		text.sendKeys("Mohan");
		WebElement check1 = driver.findElement(By.id("io.appium.android.apis:id/check1"));
		tapaction(1, check1);
		WebElement check2 = driver.findElement(By.id("io.appium.android.apis:id/check2"));
		tapaction(1, check2);
		WebElement radio = driver.findElement(By.id("io.appium.android.apis:id/radio1"));
		tapaction(1, radio);
		WebElement starbtn = driver.findElement(By.id("io.appium.android.apis:id/star"));
		tapaction(1, starbtn);
		WebElement onbtn1 = driver.findElement(By.id("io.appium.android.apis:id/toggle1"));
		tapaction(1, onbtn1);
		WebElement onbtn2 = driver.findElement(By.id("io.appium.android.apis:id/toggle2"));
		tapaction(1, onbtn2);
		WebElement dropdown = driver.findElement(By.id("android:id/text1"));
		tapaction(1, dropdown);
		WebElement drop = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.CheckedTextView[5]"));
		tapaction(1, drop);
		WebElement savebtn = driver.findElement(By.id("io.appium.android.apis:id/button"));
		tapaction(1, savebtn);
	}
	public void tapaction(int fingers,WebElement elements)
	{
		driver.tap(fingers, elements,500);
	}

}
