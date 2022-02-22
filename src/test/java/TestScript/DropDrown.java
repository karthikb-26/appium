package TestScript;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DropDrown {
	AndroidDriver driver;
	@Test
	public void apilaunch() throws MalformedURLException, Throwable
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"moto g(10) power");
		dc.setCapability("appPackage","io.appium.android.apis");
		dc.setCapability("appActivity",".ApiDemos");
		
		URL ur=new URL("http://localhost:4722/wd/hub");
		driver=new AndroidDriver(ur,dc);
		WebElement continuebtn = driver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
		tapaction(1, continuebtn);
		WebElement ok = driver.findElement(By.id("android:id/button1"));
		tapaction(1, ok);
		WebElement views = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
		tapaction(1,views);
		WebElement controlsbtn = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Controls\"]"));
		tapaction(1, controlsbtn);
		WebElement lighttheme = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Light Theme\"]"));
		tapaction(1, lighttheme);
	
		driver.hideKeyboard();
		
		WebElement dropdown = driver.findElement(By.id("android:id/text1"));
		tapaction(1, dropdown);
	
		List<MobileElement> prnt = driver.findElements(By.className("android.widget.CheckedTextView"));
		for (int i = 0; i <=prnt.size(); i++) {
			System.out.println(prnt.get(i).getText());
		}
	}
	public void tapaction(int fingers,WebElement elements)
	{
		driver.tap(fingers, elements,500);
	}

}
