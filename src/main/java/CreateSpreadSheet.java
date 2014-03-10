import java.io.IOException;
import java.net.URL;

import com.google.gdata.client.docs.DocsService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.util.ServiceException;


public class CreateSpreadSheet {
	private  String USERNAME;
	private  String PASSWORD;
	
	public CreateSpreadSheet(String username,String passWord){
		this.USERNAME = username;
		this.PASSWORD = passWord;
	}
	
	public void createSpreadSht(String sheetName) throws IOException, ServiceException{
		DocsService docsService = new DocsService("MySampleApplication-v3");
	    docsService.setUserCredentials(USERNAME, PASSWORD);
	    URL GOOGLE_DRIVE_FEED_URL = new URL("https://docs.google.com/feeds/default/private/full/");
	    DocumentListEntry documentListEntry = new com.google.gdata.data.docs.SpreadsheetEntry();
	    documentListEntry.setTitle(new PlainTextConstruct(sheetName));
	    documentListEntry = docsService.insert(GOOGLE_DRIVE_FEED_URL, documentListEntry);
	}
}
