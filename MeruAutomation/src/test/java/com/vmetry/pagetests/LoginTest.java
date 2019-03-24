package com.vmetry.pagetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vmetry.base.Initialization;
import com.vmetry.pageobjects.HomePagePO;
import com.vmetry.pageobjects.LoginPO;
import com.vmetry.utils.UtilityClass;

public class LoginTest extends Initialization {
	
	
	
	@BeforeClass
	public void precond() throws IOException {
		initialize();
	}
	
	@BeforeMethod
	public void startLogiPage()
	{
		wd.navigate().to(p.getProperty("testingURL"));
	}
	
	
	@Test(dataProvider="td")
	public void testLogin(String tcid,String mobno,String pass,String expected){
		
		LoginPO lgpo=PageFactory.initElements(wd, LoginPO.class);
		HomePagePO hppo=PageFactory.initElements(wd, HomePagePO.class);
		System.out.println("Test Case ID is: "+tcid);
		lgpo.enterMobileNo(mobno);
		lgpo.enterPassword(pass);
		lgpo.clickSignIn();
		if(tcid.equals("TC_001")) {
		String actual=hppo.getUserDispName();
		hppo.clickUserName();
		hppo.clickLogOut();
		Assert.assertEquals(expected, actual);
		}else {
			
			String acterrmsg=lgpo.getValidationMsg();
			Assert.assertEquals(expected, acterrmsg);
		}
		
		
		
	}
	
	
	@DataProvider(name="td")
	public static String[][] getData() throws IOException{
		
		System.out.println("Sheetname: "+p.getProperty("logintestData"));
		String[][] data=UtilityClass.getExcelData(p.getProperty("logintestData"));
		return data;
		
		
		
	}

}
