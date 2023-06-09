package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonFunction.Clickadmin;
import commonFunction.OHAddEmp;
import commonFunction.OHAddUser;
import commonFunction.OHLogin;
import commonFunction.OHLogout;
import config.OHAppUtil;
import utilities.ExcelFileUtil;

public class OHdriverScript extends OHAppUtil {
	
	String inputpath="E:\\SELENIUM_TESTING\\Orangehrm_HybridFramework\\FileInput\\OHDataEngine.xlsx";
	String outputpath="E:\\SELENIUM_TESTING\\Orangehrm_HybridFramework\\FileOutput\\AdduserResult.xlsx";
	String TCsheet="TestCase";
	String TSsheet="TestStep";
	@Test
	public void startTest()throws Throwable
	{
		boolean res=false;
		String tcres="";
		ExcelFileUtil xl=new ExcelFileUtil(inputpath);
		int tccount=xl.rowCount(TCsheet);
		int tscount=xl.rowCount(TSsheet);
		for(int i=1;i<=tccount;i++)
		{
			String executionstatus=xl.getCellData(TCsheet, i, 2);
			if(executionstatus.equalsIgnoreCase("Y"))
			{
				String tcid=xl.getCellData(TCsheet, i, 0);
				for(int j=1;j<=tscount;j++)
				{
					String tsid=xl.getCellData(TSsheet, j, 0);
					if(tcid.equalsIgnoreCase(tsid))
					{
						String keyword=xl.getCellData(TSsheet, j, 3);
						if(keyword.equalsIgnoreCase("AdminLogin"))
						{
							OHLogin login=PageFactory.initElements(driver, OHLogin.class);
							String username=xl.getCellData(TSsheet, j, 5);
							String password=xl.getCellData(TSsheet, j, 6);
							res=login.verify_login(username, password);
						}
						else if(keyword.equalsIgnoreCase("AdminLogout"))
						{
							OHLogout logout=PageFactory.initElements(driver, OHLogout.class);
							res=logout.verify_logout();
						}
						else if(keyword.equalsIgnoreCase("Add User"))
						{
							OHAddUser adduser=PageFactory.initElements(driver, OHAddUser.class);
							Clickadmin admin=PageFactory.initElements(driver, Clickadmin.class);
							admin.Adminclick();
							String userrole=xl.getCellData(TSsheet, j, 5);
							String employeename=xl.getCellData(TSsheet, j, 6);
							String username=xl.getCellData(TSsheet, j, 7);
							String status=xl.getCellData(TSsheet, j, 8);
							String password=xl.getCellData(TSsheet, j, 9);
							String cpassword=xl.getCellData(TSsheet, j, 10);
							res=adduser.Verify_adduser(userrole, employeename, username, status, password, cpassword);
						}
						else if(keyword.equalsIgnoreCase("Add Employee"))
						{
							OHAddEmp addemp=PageFactory.initElements(driver, OHAddEmp.class);
							String fname=xl.getCellData(TSsheet, j, 5);
							String mname=xl.getCellData(TSsheet, j, 6);
							String lname=xl.getCellData(TSsheet, j, 7);
							res=addemp.verify_addemp(fname, mname, lname);
						}
						String tsres="";
						if(res)
						{
							tsres="Pass";
							xl.setCelldata(TSsheet, j, 4,tsres,outputpath);
						}
						else
						{
							tsres="Fail";
							xl.setCelldata(TSsheet, j, 4,tsres,outputpath);
						}
						tcres=tsres;
					}
					
				}
				xl.setCelldata(TCsheet, i, 3, tcres, outputpath);
			}
			else
			{
				xl.setCelldata(TCsheet, i, 3, "Blocked", outputpath);
			}
		}
		
		
		
		
	}

}
