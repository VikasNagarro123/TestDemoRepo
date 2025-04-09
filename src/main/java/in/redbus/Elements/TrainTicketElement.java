package in.redbus.Elements;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface TrainTicketElement {
    String trainTicketBox = "rail_tickets_vertical";
    String source = "src";
    String destination = "dst";
    String calenderIcon = "//div[@class='date-text']";
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd");
    String dateOnly = sdf.format(date);
    String selectDate= "//span[normalize-space()='"+dateOnly+"']";
    String searchButton = "//button[@class='search-btn ' and normalize-space()='search trains']";
}
