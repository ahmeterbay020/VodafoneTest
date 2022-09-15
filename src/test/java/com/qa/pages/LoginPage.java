package com.qa.pages;

import com.qa.utils.DriverManager;
import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	TestUtils utils = new TestUtils();

	//@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")
	@FindBy(xpath = "(//*[@text='555 555 55 55'])")
	@iOSXCUITFindBy (id = "test-Username")
	private MobileElement usernameTxtFld;


	@FindBy(xpath = "//*[@text='Fan']")
	@iOSXCUITFindBy (id = "test-Username")
	private MobileElement userbtn;

	@AndroidFindBy(xpath= "//*[@*='NavigateLogin']")
	//@FindBy()
	@iOSXCUITFindBy ( id = "NavigateLogin")
	private MobileElement lgnBtn1;

	//@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")
	@FindBy(xpath = "(//*[@text='Password'])[2]")
	@iOSXCUITFindBy (id = "test-Password")
	private MobileElement passwordTxtFld;

	@AndroidFindBy(xpath= "//*[@*='Login-With-Phone']")
	@FindBy(xpath = "(//*[@text='Log in'])[2]")
	@iOSXCUITFindBy (id = "test-LOGIN")
	private MobileElement loginBtn;

	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
	private MobileElement errTxt;

	public LoginPage(){
	}

public LoginPage enterUserName(String username) throws InterruptedException {
		click(userbtn);


	//new DriverManager().getDriver().findElementByAccessibilityId("NavigateRegister").click();
		click(lgnBtn1);
		//wait(1500);
	clear(usernameTxtFld);	
	sendKeys(usernameTxtFld, username, "login with " + username);
	return this;
}

public LoginPage enterPassword(String password) {
	clear(passwordTxtFld);
	sendKeys(passwordTxtFld, password, "password is " + password);
	return this;
}

public ProductsPage pressLoginBtn() {
	click(loginBtn, "press login button");
	return new ProductsPage();
}

public ProductsPage login(String username, String password) throws InterruptedException {
	enterUserName(username);
	enterPassword(password);
	return pressLoginBtn();
}

public String getErrTxt() {
	String err = getText(errTxt, "error text is - ");
	return err;
}

}
