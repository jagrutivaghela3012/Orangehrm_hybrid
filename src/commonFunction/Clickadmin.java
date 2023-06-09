package commonFunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Clickadmin {
	WebDriver driver;
	@FindBy(xpath = "//b[normalize-space()='Admin']")
	WebElement clickadminbtn;
	public void Adminclick()
	{
		clickadminbtn.click();
	}

}
