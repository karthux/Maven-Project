package com.vmetry.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPO {
	
	
//	@FindBy(how=How.LINK_TEXT,using="Login")
//	public WebElement loginbutton;
//	
//	public void clickLogin() {
//		loginbutton.click();
//	}
	
	
	@FindBy(how=How.CSS,using="input.email")
	public WebElement mobNo;
	
	public void enterMobileNo(String mobile) {
		mobNo.sendKeys(mobile);
	}
	
	@FindBy(how=How.CSS,using="input.password")
	public WebElement password;
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	@FindBy(how=How.CLASS_NAME,using="signin-button")
	public WebElement signin;
	
	public void clickSignIn() {
		signin.click();
	}
	
	@FindBy(how=How.ID,using="error")
	public WebElement validationmsg;
	
	public String getValidationMsg() {
		return validationmsg.getText();
	}

}
