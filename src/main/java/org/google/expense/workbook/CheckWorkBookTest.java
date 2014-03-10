package org.google.expense.workbook;

import static org.junit.Assert.*;

import java.io.IOException;

import org.google.expense.GoogleCredentials;
import org.junit.Test;

import com.google.gdata.util.ServiceException;

public class CheckWorkBookTest {
	static GoogleCredentials credentials = new GoogleCredentials("dhanushanthp", "qffpaxvyuwclyaev");
	
	
	public static void main(String[]args) throws IOException, ServiceException{
		CheckWorkBook checkWorkBook = new CheckWorkBook(credentials);
		checkWorkBook.isWorkbookExist("MyExpenses");
	}

}
