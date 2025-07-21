package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders{
	
	//Data Provider 1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\openkart_logindata.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) 
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i,j);
			}
		}
		return logindata;
	}
	
	//Data Provider 2
	
	//Data Provider 3
	
	

}
