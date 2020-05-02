package com.restAssured;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class tggest {

	
	@Test
	String [][] provideData() throws IOException {
	String path = System.getProperty("user.dir")+"\\InputData.xlsx";
	int rowCount = ExcelRead.rowCount(path, "Sheet1");
	int columnCount = ExcelRead.columCount(path,"Sheet1",1);
	String [][] data = new String[rowCount][columnCount];
	
	for(int row =1;row<=rowCount;row++) {
		for( int column =0; column<columnCount;column++) {
			data[row -1][column] = ExcelRead.fethCellData(path, "Sheet1", rowCount, columnCount);
		}
	}
	System.out.println(data);
	//String [][] data = {{"name1","10000","15"},{"name2","20000","25"},{"name3","30000","35"}};
	return data;
}
}
