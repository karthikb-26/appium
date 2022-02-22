package com.drivermethods;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Notification {
	AndroidDriver driver;
	@Test
	public void install() throws Throwable {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "moto g(10) power");
		dc.setCapability(MobileCapabilityType.UDID, "ZF6526RP55");
		dc.setCapability(MobileCapabilityType.NO_RESET, "false");
		
		dc.setCapability("appPackage","io.appium.android.apis");
		dc.setCapability("appActivity",".ApiDemos");
		
		URL ur=new URL("http://localhost:4723/wd/hub");
		driver=new AndroidDriver(ur,dc);
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement continuebtn = driver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
		tapaction(1, continuebtn);
		WebElement ok = driver.findElement(By.id("android:id/button1"));
		tapaction(1, ok);
		WebElement app = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"App\"]"));
		tapaction(1, app);
		WebElement notification = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Notification\"]"));
		tapaction(1, notification);
		WebElement incoming = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"IncomingMessage\"]"));
		tapaction(1, incoming);
		WebElement show = driver.findElement(By.id("io.appium.android.apis:id/notify_app"));
		tapaction(1, show);
		
		driver.openNotifications();
		
		//driver.findElementByAccessibilityId("API Demos").click();
	 driver.findElement(By.xpath("//android.widget.TextView[@text='Joe']")).click();;
		//tapaction(1, notify);
		
		
	}
	public void tapaction(int fingers,WebElement elements)
	{
		driver.tap(fingers, elements,500);
	}
			
}
