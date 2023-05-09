package commonFunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class OHAddUser {
	WebDriver driver;
	@FindBy(xpath ="//input[@id='btnAdd']")
	WebElement clickaddbtn;
	@FindBy(xpath ="//select[@id='systemUser_userType']")
	WebElement enteruserrole;
	@FindBy(xpath ="//input[@id='systemUser_employeeName_empName']")
	WebElement enterempname;
	@FindBy(xpath ="//input[@id='systemUser_userName']")
	WebElement enterusername;
	@FindBy(xpath ="//select[@id='systemUser_status']")
	WebElement enterstatus;
	@FindBy(xpath ="//input[@id='systemUser_password']")
	WebElement enterpassword;
	@FindBy(xpath ="//input[@id='systemUser_confirmPassword']")
	WebElement entercpassword;
	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement clicksavebtn;
	public OHAddUser(WebDriver driver)
	{
		this.driver=driver;
	}
	public boolean Verify_adduser(String userrole,String empname,String username,String status,String password,String cpassword)
	{
		this.clickaddbtn.click();
		new Select(enteruserrole).selectByVisibleText(userrole);
		this.enterempname.sendKeys(empname);
		this.enterusername.sendKeys(username);
		new Select(enterstatus).selectByVisibleText(status);
		this.enterpassword.sendKeys(password);
		this.entercpassword.sendKeys(cpassword);
		this.clicksavebtn.click();
		String expectedurl="viewSystemUsers";
		String actualurl=driver.getCurrentUrl();
		if(actualurl.contains(expectedurl))
		{
			Reporter.log("User added successfully::"+expectedurl+"     "+actualurl,true);
			return true;
		}
		else
		{
			Reporter.log("User added Failed::"+expectedurl+"     "+actualurl,true);
			return false;
		}
		
	}

}
