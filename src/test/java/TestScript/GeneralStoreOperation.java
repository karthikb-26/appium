package TestScript;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GeneralStoreOperation {
	AndroidDriver driver;
	@Test
	public void install() throws Throwable {
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
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		WebElement dd = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
		tapaction(1,dd);
		scrollToElement(driver,"text","India");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		//takeScreenshot(driver,"General");
		
		
		WebElement txt = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		tapaction(1,txt);
		txt.sendKeys("k");
		WebElement male = driver.findElement(By.id("com.androidsample.generalstore:id/radioMale"));
		tapaction(1,male);
		WebElement shop = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		tapaction(1,shop);
		//WebElement shoe = driver.findElement(By.className("android.widget.TextView"));
		WebElement shoe = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]"));
		tapaction(1,shoe);
		WebElement shoe2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]"));
		tapaction(1,shoe2);
		WebElement cart = driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
		tapaction(1,cart);
		//Object c1 = driver.findElement(by.xpath("//android.widget.TextView[@Text()='$160.97']"));
		//String c11 = c1.getText();
		//WebElement c2 = driver.findElement(By.linkText("$120.0"));
		//String c22 = c2.getText();
		
		WebElement check = driver.findElement(By.className("android.widget.CheckBox"));
		tapaction(1,check);
		WebElement vist = driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"));
		tapaction(1,vist);
		
	}
	/*
	public static String takeScreenshot(WebDriver driver,String screenshotName) throws Throwable {
		String screenshotPath = "./screenshot/"+screenshotName+".PNG";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest  = new File(screenshotPath);
		Files.copy(src, dest);
		return screenshotName;
		
	}
	
	*/
	
	public static void scrollToElement(AndroidDriver driver,String an,String av) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}
	public void tapaction(int fingers,WebElement elements) {
		driver.tap(fingers, elements, 500);		
	}
}
