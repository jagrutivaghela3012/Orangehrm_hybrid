package driverFactory;

import org.testng.annotations.Test;

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
				
			}
		}
		
		
		
		
	}

}
