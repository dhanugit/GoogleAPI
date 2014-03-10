import java.io.IOException;

import com.google.gdata.util.ServiceException;

public class CreateSpreadSheetTest {

	public static void main(String[]args) throws IOException, ServiceException{
		CreateSpreadSheet c = new CreateSpreadSheet("dhanushanthp", "qffpaxvyuwclyaev");
		c.createSpreadSht("MyExpenses");
	}

}
