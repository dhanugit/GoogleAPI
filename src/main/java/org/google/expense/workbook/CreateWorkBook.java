package org.google.expense.workbook;
import java.io.IOException;
import java.net.URL;

import org.google.expense.GoogleCredentials;

import com.google.gdata.client.docs.DocsService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.util.ServiceException;

/**
 * This Class use to create New Google Spread Book.
 * @author Dhanushanth
 * @version 1.0
 * 
 *
 */
public class CreateWorkBook {
	private  GoogleCredentials credentials;
	
	public CreateWorkBook(GoogleCredentials credentials){
		this.credentials = credentials;
	}
	
	public void createSpreadSht(String workBookName,String serviceName) throws IOException, ServiceException{
		DocsService docsService = new DocsService(serviceName);
		
		//Set the Credentials 
	    docsService.setUserCredentials(credentials.getUserName(), credentials.getPassWord());
	    
	    //Create new Sheet reference
	    DocumentListEntry documentListEntry = new com.google.gdata.data.docs.SpreadsheetEntry();
	    
	    // Define the URL to request.  This should never change.
	    URL GOOGLE_DRIVE_FEED_URL = new URL("https://docs.google.com/feeds/default/private/full/");
	    
	    //Set Title For Spread Sheet
	    documentListEntry.setTitle(new PlainTextConstruct(workBookName));
	  
	    //Insert the New Excel Spread Sheet
	    documentListEntry = docsService.insert(GOOGLE_DRIVE_FEED_URL, documentListEntry);
	    
	}
}
