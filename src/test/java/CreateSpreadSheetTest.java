import java.io.IOException;

import org.google.expense.workbook.CreateWorkBook;

import com.google.gdata.util.ServiceException;

public class CreateSpreadSheetTest {

	public static void main(String[]args) throws IOException, ServiceException{
		CreateWorkBook c = new CreateWorkBook("dhanushanthp", "qffpaxvyuwclyaev");
		c.createSpreadSht("MyExpenses","My Service");
	}

}
