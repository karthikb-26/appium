package TestScript;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TouchT {
	@Test
	public void install() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "moto g(10) power");
		dc.setCapability(MobileCapabilityType.UDID, "ZF6526RP55");
		dc.setCapability(MobileCapabilityType.NO_RESET, "false");
		dc.setCapability("appPackage","jp.rallwell.siriuth.touchscreentest");
		dc.setCapability("appActivity",".TouchScreenTestActivity");
		
		URL ur = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(ur,dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Dimension size = driver.manage().window().getSize();
		
		int ht = size.getHeight();
		int wd = size.getWidth();
		System.out.println("height of the phone " + ht);
		System.out.println("width of the phone " +wd);
		//vertical
		driver.swipe(wd/2, (int)(ht*0.25), wd/2, (int)(ht*0.70), 2000);
		driver.swipe((int)(wd*0.1), (int)(ht*0.25), (int)(wd*0.1), (int)(ht*0.70), 2000);
		driver.swipe((int)(wd*0.5), (int)(ht*0.25), (int)(wd*0.5), (int)(ht*0.70), 2000);
		driver.swipe((int)(wd*0.9), (int)(ht*0.25), (int)(wd*0.9), (int)(ht*0.70), 2000);
		//horizontal
		driver.swipe((int)(wd*0.25),(ht/2), (int)(wd*0.80),ht/2, 1000);
		driver.swipe((int)(wd*0.1),(int)(ht*0.75), (int)(wd*0.9),(int)(ht*0.75), 1000);
		driver.swipe((int)(wd*0.1),(int)(ht*0.2), (int)(wd*0.9),(int)(ht*0.2), 1000);
		driver.swipe((int)(wd*0.1),(int)(ht*0.5), (int)(wd*0.9),(int)(ht*0.5), 1000);
		
	}
}
