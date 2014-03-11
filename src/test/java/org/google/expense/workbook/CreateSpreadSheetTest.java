package org.google.expense.workbook;
import java.io.IOException;

import org.google.expense.GoogleCredentials;
import org.google.expense.workbook.WorkBookCreation;

import com.google.gdata.util.ServiceException;

public class CreateSpreadSheetTest {

	public static void main(String[]args) throws IOException, ServiceException{
		GoogleCredentials credentials = new GoogleCredentials("dhanushanthp", "qffpaxvyuwclyaev");
		WorkBookCreation c = new WorkBookCreation(credentials);
		c.createSpreadSht("MyExpenses","My Service");
	}

}
