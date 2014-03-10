import java.io.IOException;

import org.google.expense.GoogleCredentials;
import org.google.expense.workbook.CreateWorkBook;

import com.google.gdata.util.ServiceException;

public class CreateSpreadSheetTest {

	public static void main(String[]args) throws IOException, ServiceException{
		GoogleCredentials credentials = new GoogleCredentials("dhanushanthp", "qffpaxvyuwclyaev");
		CreateWorkBook c = new CreateWorkBook(credentials);
		c.createSpreadSht("MyExpenses","My Service");
	}

}
