import java.io.*;
import java.text.SimpleDateFormat;

/**
 * Project iCalendar based on RFC5545
 * 
 *		University of Hawaii at Manoa Spring 2016, ICS314 
 * 		Team Cinco: Lucas Calabrese, Nicholas Winters, and Songmin Kim
 * 		
 * 		Created Date: 02/20/2016
 */

/**
 * Comment style information
 *  / ** ... ** / Javadoc comment block
 *  / *  ...  * / Comment block
 *  //...         Temporary disabled line
 *   
 * @author Songmin Kim
 */

public class iCal {
	/**
	 * First team deliverable minimum properties 
	 * 		Due date: Week 7 
	 * 		Reference: RFC5455
	 * 
	 * Read required-rfc5545.info and sample.ics
	 */

	/* Start calendar properties */
	private static String vbegin = "BEGIN:VCALENDAR\n";
	private static String version = "VERSION:1.0\n";
	private static String prodid = "PRODID:-//University of Hawaii at Manoa// ICS314 Team Cinco Spring.2016//EN\n";
	private static String calscale = "CALSCALE:GREGORIAN\n";
	private static String method = "METHOD:PUBLISH\n";
	private static String calname = "X-WR-CALNAME:ICS314\n";
	private static String timezone = "X-WR-TIMEZONE:Pacific/Honolulu\n";
	private static String caldesc = "X-WR-CALDESC:ICS314\n";

	/* Start event properties */
	private static String ebegin = "BEGIN:VEVENT\n";
	private static String dtstart = "DTSTART:";
	private static String dtend = "DTEND:";
	//private static String dtstamp = "DTSTAMP:";
	private static String uid = "UID:";
	private static String created = "CREATED:";
	private static String description = "DESCRIPTION:";
	//private static String last = "LAST-MODIFIED:";
	private static String location = "LOCATION:";
	//private static String seq = "SEQUENCE:";
	//private static String status ="STATUS:";
	private static String summary = "SUMMARY:";

	/* End event */
	private static String eend = "END:VEVENT\n";
	/* End calendar */
	private static String vend = "END:VCALENDAR\n";

	/**
	 * Second team deliverable additional properties 
	 * Due: Week 9 
	 * Reference: RFC5545/3.8.1.6
	 */
	//private String geo = "GEO:";

	public static void main(String[] args) {

		/*
		 * Sample start here
		 * 
		 * Create an input data system instead this sample from command line or drop-down menus
		 */
		String start_dt = "20160218T203000Z";
		String end_dt = "20160218T204500Z";
		String event_description = "First Meeting";
		String event_location = "POST 318B";
		String event_summary = "ICS314 Meeting";
		/*
		 * Sample end here
		 */

		dtstart = dtstart + start_dt + "\n";
		dtend = dtend + end_dt + "\n";
		uid = uid + start_dt + "\n";
		description = description + event_description + "\n";
		location = location + event_location + "\n";
		summary = summary + event_summary + "\n";

		/* Create event file */
		createEvent(start_dt);
	}

	/**
	 * Create event file
	 * 
	 * @param start_dt string For a file name
	 */
	public static void createEvent(String start_dt) {
		StringBuilder event = new StringBuilder();
		event.append(start_dt);
		event.append(".ics");

		try {
			File file = new File(event.toString());

			/* if the file exist, break otherwise create a file */
			if (!file.exists()) {
				file.createNewFile();
			} else {
				System.out.println("Event already exist.\n");
			}

			/* write out to the file */
			System.out.println(file.getAbsolutePath());
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			/* Start calendar data here */
			bw.write(vbegin);
			bw.write(version);
			bw.write(prodid);
			bw.write(calscale);
			bw.write(method);
			bw.write(calname);
			bw.write(timezone);
			bw.write(caldesc);

			/* Start event data here */
			bw.write(ebegin);
			bw.write(dtstart);
			bw.write(dtend);
			//bw.write(dtstamp);
			bw.write(uid);
			String current_dt = new SimpleDateFormat("yyyyMMdd").format(new java.util.Date()) + "T";
			current_dt = current_dt + new SimpleDateFormat("HHmmss").format(new java.util.Date()) + "Z";
			created = created + current_dt + "\n";
			bw.write(created);
			bw.write(description);
			//bw.write(last);
			bw.write(location);
			//bw.write(seq);
			//bw.write(status);
			bw.write(summary);

			/* End event data here */
			bw.write(eend);
			/* End calendar data here */
			bw.write(vend);
			
			/* close the file */
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
