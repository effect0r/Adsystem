package Adsystem;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GenerateReport {
	String date_format = "MMM d, yyyy";
	String day = "d";
	String month = "MM";
	String year = "yyyy";
	SimpleDateFormat format_day = new SimpleDateFormat(day);
	SimpleDateFormat format_month = new SimpleDateFormat(month);
	SimpleDateFormat format_year = new SimpleDateFormat(year);
	SimpleDateFormat format_next = new SimpleDateFormat(date_format);
	DecimalFormat cash = new DecimalFormat("#0.00");

	public GenerateReport(int i) {
		switch (i) {
		case 1:
			// System.out.println(format_next.format(date.getTime()));
			pagination_report(format_next.format(AdsList.current_day.getTime()));
			Calendar today = (Calendar) AdsList.current_day;
			// System.out.println(Integer.valueOf(format_year.format(today.getTime()))
			// + " " + Integer.valueOf(format_month.format(today.getTime())) +
			// " " + Integer.valueOf(format_day.format(today.getTime())));
			Calendar date = new GregorianCalendar(Integer.valueOf(format_year.format(today.getTime())), Integer.valueOf(format_month.format(today.getTime())) - 1, Integer.valueOf(format_day.format(today.getTime())));
			date.add(Calendar.DAY_OF_MONTH, 1);
			AdsList.current_day = date;
			JOptionPane.showMessageDialog(null, "Date changed. New date: " + format_next.format(date.getTime()) + ".", "Date change", JOptionPane.PLAIN_MESSAGE);
			break;
		case 2:
			unpaid_report();
			break;
		default:
			break;
		}

	}

	private void pagination_report(String day) {
		File file = new File("reports" + File.separator + "Pagination_report.csv");
		day = day.replaceAll(",", "");
		String current_month = day.substring(0, 3).replaceAll(" ", "");
		int current_day = Integer.valueOf(day.substring(3, 6).replaceAll(" ", ""));// removes
																					// comma
		String current_year = day.substring(6).replaceAll(" ", ""); // makes the
																	// year 4
																	// chars
																	// long

		ArrayList<Advertisement> list = new ArrayList<>();

		try {
			String column_headers = "Category\t" + "Title\t" + "Rows\t" + "Columns\t" + "Content";
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			out.println("Pagination Report");
			out.println("Date:\t" + format_next.format(AdsList.current_day.getTime()));
			out.println("");
			out.println(column_headers);
			// System.out.println(column_headers);
			try {
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader("ads.db"));
				JSONArray jsonObject = (JSONArray) obj;
				for (int i = 0; i < jsonObject.size(); i++) {
					JSONObject jobj = (JSONObject) jsonObject.get(i);
					boolean billing_paid = (boolean) jobj.get("Paid");
					if (billing_paid) {
						String ad_month, ad_year;
						int ad_day;
						ad_month = ((String) jobj.get("Month")).substring(0, 3); // Dec
						ad_day = Integer.valueOf((String) jobj.get("Day")); // #
						ad_year = (String) jobj.get("Year");// ####

						//System.out.println((ad_month.compareTo(current_month) == 0));
						//System.out.println(ad_day <= current_day);
						//System.out.println((ad_year.compareTo(current_year) == 0));
						if ((ad_month.compareTo(current_month) == 0) && (ad_day <= current_day) && (ad_year.compareTo(current_year) == 0)) {
							//System.out.printf("%s = %s, %s = %s, %s = %s%n", current_month, ad_month, current_day, ad_day, current_year, ad_year);
							long category = (long) jobj.get("Type");
							String title = (String) jobj.get("Title");
							String rows = String.format("%s", (long) jobj.get("Columns"));
							String columns = String.format("%s", (long) jobj.get("Rows"));
							String content = (String) jobj.get("Content");
							String line = TYPE.get(category).get_name() + "\t" + title + "\t" + rows + "\t" + columns + "\t" + content;
							// System.out.println(line);
							out.println(line);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Advertisement a : AdsList.ads_list) {
			if (a.isBilling_paid()) {
				String ad_month = a.getMonth().substring(0, 3);
				int ad_day = Integer.valueOf(a.getDay());
				String ad_year = a.getYear();
				if ((ad_month.compareTo(current_month) != 0) || (ad_day > current_day) || (ad_year.compareTo(current_year) != 0)) {
					list.add(a);
				}
			}
		}

		AdsList.tbl_model.set_data(list);
		AdsList.ads_list = list;
		AdsList.save_ads();
		JOptionPane.showMessageDialog(null, "Pagination report sent and saved.", "Pagination Process", JOptionPane.PLAIN_MESSAGE);
	}

	private void unpaid_report() {
		// todo: this function generates the unpaid report for the manager.
		// I would format like this:
		/*
		 * AdID: Name: Phone: Title: Cost: Content: width:20 Width:20 width:12
		 * width:30 width: 10 width: 200
		 */

		try {
			String column_headers = "AdID:\t" + "Name:\t" + "Phone:\t" + "Title:\t" + "Cost:\t" + "Content:";
			File file = new File("reports" + File.separator + "unpaid_report.csv");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			out.println("Unpaid Ads Report");
			out.println("Date:\t" + format_next.format(AdsList.current_day.getTime()));
			out.println("");
			out.println(column_headers);
			// System.out.println(column_headers);
			try {
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader("ads.db"));
				JSONArray jsonObject = (JSONArray) obj;
				double total_cost = 0.0;
				for (int i = 0; i < jsonObject.size(); i++) {
					JSONObject jobj = (JSONObject) jsonObject.get(i);
					boolean billing_paid = (boolean) jobj.get("Paid");
					if (!billing_paid) {
						double cost = (double) jobj.get("Cost");
						String str_cost = "$" + cash.format(cost);
						long ID = (long) jobj.get("ID");
						String content = (String) jobj.get("Content");
						String title = (String) jobj.get("Title");
						String billing_name = (String) jobj.get("Name");
						String billing_phone = (String) jobj.get("Phone");
						String fmt_phone = "";
						for (int j = 0; j < billing_phone.length(); j++) {
							if (j == 3 || j == 6) {
								fmt_phone += "-";
							}
							fmt_phone += billing_phone.charAt(j);
						}
						total_cost += cost;
						String report_line = Long.toString(ID) + "\t" + billing_name + "\t" + fmt_phone + "\t" + title + "\t" + str_cost + "\t" + content.replaceAll("\t", "").replaceAll("\n", "").replaceAll("\r", "");
						out.println(report_line);
						// System.out.println(report_line);
					}
				}
				out.println("");
				out.println("\t\t\t\tTotal:\t$" + cash.format(total_cost));
			} catch (Exception e) {
				e.printStackTrace();
			}

			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
