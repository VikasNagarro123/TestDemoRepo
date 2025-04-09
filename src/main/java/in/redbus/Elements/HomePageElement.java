package in.redbus.Elements;

import java.util.Arrays;
import java.util.List;

public interface HomePageElement {
// Page Elements Locators for Home Page
    String logo="#main_header_new .rb_logo";

    String railBookingBox="rail_tickets_vertical";

    String busTicketsBox="bus_tickets_vertical";

    String helpCareBox="help_redcare";

    String accountDropdown="#account_dd";

    String accountOptionsList="//ul[@class='header_dropdown_menu']/li/span";

    List<String> ActualAccountOptions= Arrays.asList(
                "Cancel Ticket",
                "Change Travel Date",
                "Show My Ticket",
                "Email/SMS",
                "Login/ Sign Up"   );
    String source = "src";
    String destination = "dest";



}
