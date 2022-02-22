package TestScript;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Touch {
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
		
		//vertical swipe
		driver.swipe(350, 202, 360, 1363, 200);
		
		//horizontal swipe
		driver.swipe(43, 723, 596, 723, 500);
		

	}
}