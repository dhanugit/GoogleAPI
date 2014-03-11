package org.google.expense.workbook;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.google.expense.GoogleCredentials;

import com.google.gdata.client.docs.DocsService;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.util.ServiceException;

/**
 * This Class use to create New Google Spread Book.
 * @author Dhanushanth
 * @version 1.0
 * 
 *
 */
public class WorkBookCreation {
	private  GoogleCredentials credentials;
	private final String REQUEST_URL = "https://spreadsheets.google.com/feeds/spreadsheets/private/full"; 
	
	public WorkBookCreation(GoogleCredentials credentials){
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
	
public boolean isWorkbookExist(String workBookName) throws IOException, ServiceException{
		
		// Define the URL to request.  This should never change.
        URL GOOGLE_DRIVE_FEED_URL = new URL(REQUEST_URL);
        SpreadsheetService service =   new SpreadsheetService(workBookName);
        
        // Work Book that we want to check
		service.setUserCredentials(credentials.getUserName(),credentials.getPassWord());
		
		// Make a request to the API and get all spreadsheets.
        SpreadsheetFeed feed = service.getFeed(GOOGLE_DRIVE_FEED_URL, SpreadsheetFeed.class);
        List<SpreadsheetEntry> workBooks = feed.getEntries();
      
	    // Iterate through all of the spreadsheets returned
        for (SpreadsheetEntry workBook : workBooks) {
        	//If found the workBook
        	if(workBook.getTitle().getPlainText().equals(workBookName)){
        		return true;
        	}else{
        		return false;
        	}
        }
        
        //If there or not we will create it
		return false;
	
	}
}
