/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gdata.client.spreadsheet.*;
import com.google.gdata.data.Link;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.TextConstruct;
import com.google.gdata.data.docs.ExportFormat;
import com.google.gdata.data.spreadsheet.*;
import com.google.gdata.util.*;


import java.io.IOException;
import java.net.*;
import java.util.*;
import javax.xml.soap.Text;


    /**
     *
     * @author satyam
     */
    public class SpreadSheet {

        public static void main(String[] args)
                throws AuthenticationException, MalformedURLException, IOException, ServiceException {

            SpreadsheetService service =   new SpreadsheetService("gBuddy");

            // TODO: Authorize the service object for a specific user (see other sections)
            String USERNAME = "dhanushanthp";
            String PASSWORD = "qffpaxvyuwclyaev";

            service.setUserCredentials(USERNAME, PASSWORD);


            // Define the URL to request.  This should never change.
            URL SPREADSHEET_FEED_URL = new URL(
                    "https://spreadsheets.google.com/feeds/spreadsheets/private/full");

            // Make a request to the API and get all spreadsheets.
            SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL, SpreadsheetFeed.class);
            List<SpreadsheetEntry> spreadsheets = feed.getEntries();

            // Iterate through all of the spreadsheets returned
            for (SpreadsheetEntry spreadsheet : spreadsheets) {
    //             Print the title of this spreadsheet to the screen;
                System.out.println(spreadsheet.getTitle().getPlainText());
            }

            SpreadsheetEntry spreadsheet = spreadsheets.get(1);
    //        System.out.println(spreadsheet.getTitle().getPlainText());

    //        // Create a local representation of the new worksheet.
            WorksheetEntry worksheet = new WorksheetEntry();
            worksheet.setTitle(new PlainTextConstruct("New Worksheet"));
            worksheet.setColCount(10);
            worksheet.setRowCount(20);

            // Send the local representation of the worksheet to the API for
            // creation.  The URL to use here is the worksheet feed URL of our
            // spreadsheet.
            URL worksheetFeedUrl = spreadsheet.getWorksheetFeedUrl();
            WorksheetEntry insert = service.insert(worksheetFeedUrl, worksheet);
        }
    }