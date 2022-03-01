package POMclass;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginApp {
	AndroidDriver driver;
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private MobileElement nameEdt;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private MobileElement MRB;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private MobileElement FRB;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private MobileElement LBT;

	public MobileElement getNameEdt() {
		return nameEdt;
	}

	public MobileElement getMRB() {
		return MRB;
	}

	public MobileElement getFRB() {
		return FRB;
	}

	public MobileElement getLBT() {
		return LBT;
	}
	
	public LoginApp(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public LoginApp() {
		nameEdt.sendKeys("k");
		MRB.tap(1, 500);
		LBT.click();
	} 
	
	public void login(String name,int fingers,int duration ) {
		nameEdt.sendKeys(name);
		MRB.tap(fingers, duration);
		LBT.click();
	}
}
