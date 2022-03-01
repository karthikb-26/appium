package com.drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.xpath.operations.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidKey_Action {
	AndroidDriver driver;
	@Test
	public void apilaunch() throws MalformedURLException, Throwable
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"moto g(10) power");
		dc.setCapability("appPackage","com.motorola.camera3");
		dc.setCapability("appActivity","com.motorola.camera.Camera");
		
		URL ur=new URL("http://localhost:4723/wd/hub");
		driver=new AndroidDriver(ur,dc);
		
		WebElement continuebtn = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
		tapaction(1, continuebtn);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//System.out.println(AndroidKeyCode.KEYCODE_VOLUME_UP);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_UP);
		
		//System.out.println(AndroidKeyCode.KEYCODE_VOLUME_MUTE);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_MUTE);
		//System.out.println(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		//System.out.println(AndroidKeyCode.ENTER);
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		
		//System.out.println(AndroidKeyCode.BACK);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		//System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		//System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
		//System.out.println(AndroidKeyCode.KEYCODE_CAMERA);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
	}
	public void tapaction(int fingers,WebElement elements)
	{
		driver.tap(fingers, elements,500);
	}

}
