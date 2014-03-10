package org.google.expense.workbook;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.google.expense.GoogleCredentials;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.util.ServiceException;

public class CheckWorkBook {
	private final String REQUEST_URL = "https://spreadsheets.google.com/feeds/spreadsheets/private/full";
	private final GoogleCredentials credentials;
	
	public CheckWorkBook(GoogleCredentials credentials){
		this.credentials = credentials;
	}
	
	public boolean isWorkbookExist(String workBookName) throws IOException, ServiceException{
		
		// Define the URL to request.  This should never change.
        URL SPREADSHEET_FEED_URL = new URL(REQUEST_URL);
        SpreadsheetService service =   new SpreadsheetService(workBookName);
        
        // Work Book that we want to check
		service.setUserCredentials(credentials.getUserName(),credentials.getPassWord());
		
		// Make a request to the API and get all spreadsheets.
        SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL, SpreadsheetFeed.class);
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
