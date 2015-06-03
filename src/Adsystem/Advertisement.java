package Adsystem;

import org.json.simple.*;

enum TYPE {
	ANNOUNCEMENT_ENGAGEMENT(1,"Engagement"), ANNOUNCEMENT_BIRTH(2,"Birth"), ANNOUNCEMENT_CELEBRATION(3,"Celebration"),ANNOUNCEMENT_OTHER(4,"Other"),
	PERSONAL(5,"Personal"),
	OBITUARY(6,"Obituary"),
	HELP_WANTED_SKILLED(7,"Help Wanted Skilled"), HELP_WANTED_UNSKILLED(8,"Help Wanted Unskilled"), 
	PUBLIC_NOTICE(9,"Public Notice"),
	LOST_AND_FOUND_LOST(10,"Lost and found, Lost"),LOST_AND_FOUND_FOUND(11,"Lost and found, found");
	private int value;
	private String name;

	private TYPE(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public String toString() {
		return String.valueOf(value);
	}
	public String get_name(){
		return name;
	}
	public int get_value() {
		return value;
	}

	public static TYPE get(long type) {
		int check = (int) type;
		switch (check) {
		case 1:
			return ANNOUNCEMENT_ENGAGEMENT;
		case 2:
			return ANNOUNCEMENT_BIRTH;
		case 3:
			return ANNOUNCEMENT_CELEBRATION;
		case 5:
			return PERSONAL;
		case 6:
			return OBITUARY;
		case 7:
			return HELP_WANTED_SKILLED;
		case 8:
			return HELP_WANTED_UNSKILLED;
		case 9:
			return PUBLIC_NOTICE;
		case 10:
			return LOST_AND_FOUND_LOST;
		case 11:
			return LOST_AND_FOUND_FOUND;
		default:
			return ANNOUNCEMENT_OTHER;

		}
	}
}

public class Advertisement {
	private long id;
	private int rows, columns;
	private TYPE ad_type;
	private String title, content;
	private String month, day, year;
	// private Billing billing;
	JSONObject adInfo = new JSONObject();
	private boolean billing_paid;
	private double billing_cost;
	private String billing_name;
	private String billing_address;
	private String billing_city;
	private String billing_state;
	private String billing_zip;
	private String billing_country;
	private String billing_phone;
	private String billing_cvv2;
	private String billing_month;
	private String billing_year;
	private String billing_ccn;

	/*
	 * Announcement Engagement Birth Celebration Other Personal Obituary Help
	 * wanted Skilled Unskilled Public Notice Lost & Found Lost Found
	 */

	
	public Advertisement(long ID,String title, String content, int rows, int columns, TYPE type, String month,String day, String year,
			boolean billing_paid, double billing_cost, String billing_name, String billing_address, String billing_city, String billing_state, String billing_zip, String billing_country,
			String billing_phone, String billing_cvv2, String billing_month, String billing_year, String billing_ccn) {
		this.id					= ID;
		this.title 				= title;
		this.content 			= content;
		this.rows 				= rows;
		this.columns 			= columns;
		this.ad_type 			= type;
		this.month			 	= month;
		this.day 				= day;
		this.year 				= year;
		this.billing_paid		= billing_paid;
		this.billing_cost		= billing_cost;
		this.billing_name		= billing_name;
		this.billing_address	= billing_address;
		this.billing_city		= billing_city;
		this.billing_state		= billing_state;
		this.billing_zip		= billing_zip;
		this.billing_country	= billing_country;
		this.billing_phone		= billing_phone;
		this.billing_cvv2		= billing_cvv2;
		this.billing_month		= billing_month;
		this.billing_year		= billing_year;
		this.billing_ccn		= billing_ccn;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getAdInfo() {
		try {
			adInfo.put("Title", this.title);
			adInfo.put("Content", this.content);
			adInfo.put("Rows", this.rows);
			adInfo.put("Columns", this.columns);
			adInfo.put("Type", this.ad_type);
			adInfo.put("ID", this.id);
			adInfo.put("Month", this.month);
			adInfo.put("Day", this.day);
			adInfo.put("Year", this.year);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adInfo;
	}
	@SuppressWarnings("unchecked")
	public JSONObject pagination_info() {
		JSONObject pagination = new JSONObject();
		try {
			pagination.put("Title", this.title);
			pagination.put("Content",this.content);
			pagination.put("Category", this.ad_type.get_name());
			pagination.put("Size", this.columns +" by " + this.rows);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pagination;
	}
	@SuppressWarnings("unchecked")
	public JSONObject unpaid_info() {
		JSONObject unpaid = new JSONObject();
		try {
			unpaid.put("ID", this.id);
			unpaid.put("Name", this.billing_name);
			unpaid.put("Address", this.billing_address);
			unpaid.put("City",this.billing_city);
			unpaid.put("State",this.billing_state);
			unpaid.put("Zip",this.billing_zip);
			unpaid.put("Country",this.billing_country);
			unpaid.put("Phone", this.billing_phone);
			unpaid.put("CCN", this.billing_ccn);
			unpaid.put("CVV2", this.billing_cvv2);
			unpaid.put("ExpMonth",this.billing_month);
			unpaid.put("ExpYear",this.billing_year);
			unpaid.put("Paid", this.billing_paid);
			unpaid.put("Cost", this.billing_cost);
			unpaid.put("Title", this.title);
			unpaid.put("Content", this.content);
			unpaid.put("Rows", this.rows);
			unpaid.put("Columns", this.columns);
			unpaid.put("Type", this.ad_type);
			unpaid.put("ID", this.id);
			unpaid.put("Month", this.month);
			unpaid.put("Day", this.day);
			unpaid.put("Year", this.year);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return unpaid;
	}

	/**
	 * @return the id
	 */
	
	public boolean equals(Object obj) {
		if (obj instanceof Advertisement) {
			if (((Advertisement) obj).getId() == this.getId()) {
				return true;
			}
			else return false;
		}
		return false;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * @return the ad_type
	 */
	public TYPE getAd_type() {
		return ad_type;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @return the billing_paid
	 */
	public boolean isBilling_paid() {
		return billing_paid;
	}

	/**
	 * @return the billing_cost
	 */
	public double getBilling_cost() {
		return billing_cost;
	}

	/**
	 * @return the billing_name
	 */
	public String getBilling_name() {
		return billing_name;
	}

	/**
	 * @return the billing_address
	 */
	public String getBilling_address() {
		return billing_address;
	}

	/**
	 * @return the billing_city
	 */
	public String getBilling_city() {
		return billing_city;
	}

	/**
	 * @return the billing_state
	 */
	public String getBilling_state() {
		return billing_state;
	}

	/**
	 * @return the billing_zip
	 */
	public String getBilling_zip() {
		return billing_zip;
	}

	/**
	 * @return the billing_country
	 */
	public String getBilling_country() {
		return billing_country;
	}

	/**
	 * @return the billing_phone
	 */
	public String getBilling_phone() {
		return billing_phone;
	}

	/**
	 * @return the billing_cvv2
	 */
	public String getBilling_cvv2() {
		return billing_cvv2;
	}

	/**
	 * @return the billing_month
	 */
	public String getBilling_month() {
		return billing_month;
	}

	/**
	 * @return the billing_year
	 */
	public String getBilling_year() {
		return billing_year;
	}

	/**
	 * @return the billing_ccn
	 */
	public String getBilling_ccn() {
		return billing_ccn;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * @param columns the columns to set
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}

	/**
	 * @param ad_type the ad_type to set
	 */
	public void setAd_type(TYPE ad_type) {
		this.ad_type = ad_type;
	}

	/**
	 * @param title the title to set
	 */
	public void set_title(String title) {
		this.title = title;
	}

	/**
	 * @param content the content to set
	 */
	public void set_content(String content) {
		this.content = content;
	}

	/**
	 * @param month the month to set
	 */
	public void set_month(String month) {
		this.month = month;
	}

	/**
	 * @param day the day to set
	 */
	public void set_day(String day) {
		this.day = day;
	}

	/**
	 * @param year the year to set
	 */
	public void set_year(String year) {
		this.year = year;
	}

	/**
	 * @param adInfo the adInfo to set
	 */
	public void set_AdInfo(JSONObject adInfo) {
		this.adInfo = adInfo;
	}

	/**
	 * @param billing_paid the billing_paid to set
	 */
	public void set_billing_paid(boolean billing_paid) {
		this.billing_paid = billing_paid;
	}

	/**
	 * @param billing_cost the billing_cost to set
	 */
	public void set_billing_cost(double billing_cost) {
		this.billing_cost = billing_cost;
	}

	/**
	 * @param billing_name the billing_name to set
	 */
	public void set_billing_name(String billing_name) {
		this.billing_name = billing_name;
	}

	/**
	 * @param billing_address the billing_address to set
	 */
	public void set_billing_address(String billing_address) {
		this.billing_address = billing_address;
	}

	/**
	 * @param billing_city the billing_city to set
	 */
	public void set_billing_city(String billing_city) {
		this.billing_city = billing_city;
	}

	/**
	 * @param billing_state the billing_state to set
	 */
	public void set_billing_state(String billing_state) {
		this.billing_state = billing_state;
	}

	/**
	 * @param billing_zip the billing_zip to set
	 */
	public void set_billing_zip(String billing_zip) {
		this.billing_zip = billing_zip;
	}

	/**
	 * @param billing_country the billing_country to set
	 */
	public void set_billing_country(String billing_country) {
		this.billing_country = billing_country;
	}

	/**
	 * @param billing_phone the billing_phone to set
	 */
	public void set_billing_phone(String billing_phone) {
		this.billing_phone = billing_phone;
	}

	/**
	 * @param billing_cvv2 the billing_cvv2 to set
	 */
	public void set_billing_cvv2(String billing_cvv2) {
		this.billing_cvv2 = billing_cvv2;
	}

	/**
	 * @param billing_month the billing_month to set
	 */
	public void set_billing_month(String billing_month) {
		this.billing_month = billing_month;
	}

	/**
	 * @param billing_year the billing_year to set
	 */
	public void set_billing_year(String billing_year) {
		this.billing_year = billing_year;
	}

	/**
	 * @param billing_ccn the billing_ccn to set
	 */
	public void set_billing_ccn(String billing_ccn) {
		this.billing_ccn = billing_ccn;
	}

	public String getDate() {
		// TODO Auto-generated method stub
		return this.day + " " + this.month + " " + this.year;
	}

}
