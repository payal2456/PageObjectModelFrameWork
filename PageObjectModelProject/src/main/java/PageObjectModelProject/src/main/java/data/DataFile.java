package data;

import utility.Xls_Reader;

public class DataFile {
		Xls_Reader d = new Xls_Reader("D:\\QA\\Testing\\TheBayTestData.xlsx");
		public String WrongEmail = d.getCellData("login1","WrongEmail",2);
		public String WrongPassword = d.getCellData("login1","WrongPassword",2);
		public String EmailWithSpecialChar= d.getCellData("login1","EmailWithSpecialChar",2);
		public String GlobalErr= d.getCellData("login1","GlobalErr",2);
		public String emptyEmailErr = d.getCellData("login1", "emptyEmailErr",2) ;
		public String emptyPasswordErr = d.getCellData("login1", "emptyPasswordErr",2) ;
		public String emailWithSpecialCharErr = d.getCellData("login1", "emailWithSpecialCharErr",2) ;
}
