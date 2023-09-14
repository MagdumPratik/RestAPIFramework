package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String [][] getAllData() throws IOException   {
		String path=System.getProperty("user.dir")+"//testData//TestData.xlsx";
		XLUtilities xl=new XLUtilities(path);
		
		int rownum=xl.getRowCount("Sheet1");
		int colcount=xl.getCellCount("Sheet1", 1);
		
		String apidata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int c=0;c<colcount;c++)
			{
				apidata[i-1][c]=xl.getCellData("Sheet1", i, c);
			}
			
		}
		return apidata;
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//TestData.xlsx";
		XLUtilities xl=new XLUtilities(path);
		
		int rownum=xl.getRowCount("Sheet1");
		
		String apidata[]=new String[rownum];
		
		for(int i=1; i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("Sheet1", i, 1);
			
	}
		return apidata;
}
}