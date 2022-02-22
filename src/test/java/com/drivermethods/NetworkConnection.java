package com.drivermethods;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.remote.MobileCapabilityType;

public class NetworkConnection {
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
		
		Connection currentstate= driver.getConnection();
		System.out.println(currentstate);
		//driver.setConnection(Connection.WIFI);
		//System.out.println(driver.getConnection());
		//driver.setConnection(Connection.DATA);
		//System.out.println(driver.getConnection());
		driver.setConnection(Connection.AIRPLANE);
		System.out.println(driver.getConnection());
		
		
	}
}
