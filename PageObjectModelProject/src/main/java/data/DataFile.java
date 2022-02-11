package data;

import utility.Xls_Reader;

public class DataFile extends NumberFormat {
		Xls_Reader d = new Xls_Reader("D:\\QA\\Selenium_Workspace\\PageObjectModelProject\\src\\main\\java\\configuration\\TheBayTestData.xlsx");
		public String FN = d.getCellData("data1","first name",2);
		public String LN = d.getCellData("data1","last name",2);
		public String EMAIL= d.getCellData("data1","email",2);
		public String PASS= d.getCellData("data1","password",2);
		public String CONFPASS = d.getCellData("data1", "conf pass",2) ;
		public String POSTCODE = d.getCellData("data1", "postal",2) ;
		public String PH1 = d.getCellData("data1", "phone1",2);
		public String PH2 = d.getCellData("data1", "phone2",2);
		public String PIN = d.getCellData("data1", "new pin",2) ;
		public String CONFPIN = d.getCellData("data1", "conf pin",2) ;
		public String BDY = d.getCellData("data1", "birthday",2) ;
		public String HudsonRewards = d.getCellData("data1", "RewardNum",2) ;
		public String expectErr = d.getCellData("data1", "expected error",2);
		public String fieldErr = d.getCellData("data1", "FieldErr",2) ;
		
		

}
