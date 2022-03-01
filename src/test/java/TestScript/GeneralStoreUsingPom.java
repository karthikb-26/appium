package TestScript;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import POMclass.LoginApp;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GeneralStoreUsingPom{
	AndroidDriver driver;
	@Test
	public void generalStore() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "moto g(10) power");
		dc.setCapability(MobileCapabilityType.UDID, "ZF6526RP55");
		dc.setCapability(MobileCapabilityType.NO_RESET, "false");
		
		dc.setCapability("appPackage","com.androidsample.generalstore");
		dc.setCapability("appActivity",".SplashActivity");
		
		URL ur=new URL("http://localhost:4723/wd/hub");
		driver=new AndroidDriver(ur,dc);

		LoginApp lp = new LoginApp(driver);

		lp.login("k", 1, 500);
	}
}
