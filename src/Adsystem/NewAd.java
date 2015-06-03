package Adsystem;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.ComponentOrientation;

import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JCheckBox;

public class NewAd extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField txt_columns;
	private JTextField txt_rows;
	private JTextField txt_cost;
	private JTextField txt_name_billing;
	private JTextField txt_address_billing;
	private JTextField txt_city_billing;
	private JComboBox<String> cmbo_state_billing;
	private JTextField txt_phone_billing;
	private JTextField txt_ccn_billing;
	private JComboBox<String> cmbo_month_billing;
	private JTextField txt_cvv2_billing;
	private JComboBox<String> cmbo_year_billing;
	private JTextField txt_id;
	private JComboBox<String> cmbo_type;
	private JButton btn_update;
	private JButton btn_save;
	private JButton btn_cancel;
	private JEditorPane edit_content;
	private JTextField txt_title;
	private JComboBox<String> cmbo_month;
	private JComboBox<String> cmbo_day;
	private JComboBox<String> cmbo_year;
	private JComboBox<String> cmbo_country_billing;
	private JTextField txt_zip_billing;
	private JSeparator separator;
	private JCheckBox chck_paid;

	/**
	 * Create the panel.
	 */
	public NewAd() {
		setSize(new Dimension(620, 620));
		setResizable(false);
		setTitle("Edit Ad");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 620, 620);
		setIconImage(Toolkit.getDefaultToolkit().getImage("ICON2_Scaled.png"));
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Ad ID");
		label.setBounds(11, 34, 63, 14);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_1 = new JLabel("Title");
		label_1.setBounds(11, 65, 63, 15);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_2 = new JLabel("Content");
		label_2.setBounds(11, 93, 63, 14);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_3 = new JLabel("Columns");
		label_3.setBounds(11, 205, 63, 20);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_4 = new JLabel("Name");
		label_4.setBounds(16, 292, 63, 20);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_5 = new JLabel("Address");
		label_5.setBounds(11, 325, 68, 15);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_6 = new JLabel("City");
		label_6.setBounds(30, 357, 49, 14);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_7 = new JLabel("State");
		label_7.setBounds(30, 395, 49, 14);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_8 = new JLabel("Zip Code");
		label_8.setBounds(11, 430, 68, 20);
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txt_id = new JTextField();
		txt_id.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_id.setBounds(78, 31, 86, 20);
		txt_id.setEditable(false);
		txt_id.setColumns(10);
		
		txt_title = new JTextField();
		txt_title.setBounds(78, 62, 189, 20);
		txt_title.setColumns(10);
		
		edit_content = new JEditorPane();
		edit_content.setBounds(78, 93, 516, 106);
		
		txt_columns = new JTextField();
		txt_columns.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_columns.setBounds(78, 205, 32, 20);
		txt_columns.setColumns(10);
		
		JLabel lblRows = new JLabel("Rows");
		lblRows.setBounds(114, 205, 50, 20);
		
		txt_rows = new JTextField();
		txt_rows.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_rows.setBounds(154, 205, 22, 20);
		txt_rows.setEditable(false);
		txt_rows.setColumns(10);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(180, 205, 32, 20);
		
		txt_cost = new JTextField();
		txt_cost.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_cost.setBounds(216, 205, 55, 20);
		txt_cost.setEditable(false);
		txt_cost.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(271, 205, 50, 20);
		
		cmbo_type = new JComboBox<String>();
		cmbo_type.setBounds(322, 205, 272, 20);
		cmbo_type.setModel(new DefaultComboBoxModel<String>(new String[] {"01 - ANNOUNCEMENT_ENGAGEMENT", "02 - ANNOUNCEMENT_BIRTH", "03 - ANNOUNCEMENT_CELEBRATION", "04 - ANNOUNCEMENT_OTHER", "05 - PERSONAL", "06 - OBITUARY", "07 - HELP_WANTED_SKILLED", "08 - HELP_WANTED_UNSKILLED", "09 - PUBLIC_NOTICE", "10 - LOST_AND_FOUND_LOST", "11 - LOST_AND_FOUND_FOUND"}));
		cmbo_type.setSelectedIndex(0);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(271, 65, 42, 14);
		
		cmbo_month = new JComboBox<String>();
		cmbo_month.setBounds(312, 62, 101, 20);
		cmbo_month.setModel(new DefaultComboBoxModel<String>(new String[] {"Month...", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		
		cmbo_day = new JComboBox<String>();
		cmbo_day.setBounds(419, 62, 71, 20);
		cmbo_day.setModel(new DefaultComboBoxModel<String>(new String[] {"Day...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		cmbo_year = new JComboBox<String>();
		cmbo_year.setBounds(496, 62, 98, 20);
		cmbo_year.setModel(new DefaultComboBoxModel<String>(new String[] {"Year...","2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		
		JLabel lblAdInformation = new JLabel("Ad Information");
		lblAdInformation.setBounds(252, 31, 111, 20);
		
		JLabel lblBillingInformation = new JLabel("Billing Information");
		lblBillingInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblBillingInformation.setBounds(21, 248, 573, 14);
		
		txt_name_billing = new JTextField();
		txt_name_billing.setBounds(95, 292, 179, 20);
		txt_name_billing.setColumns(10);
		
		txt_address_billing = new JTextField();
		txt_address_billing.setBounds(95, 322, 179, 20);
		txt_address_billing.setColumns(10);
		
		txt_city_billing = new JTextField();
		txt_city_billing.setBounds(95, 354, 179, 20);
		txt_city_billing.setColumns(10);
		
		cmbo_state_billing = new JComboBox<String>();
		cmbo_state_billing.setBounds(95, 392, 179, 20);
		cmbo_state_billing.setModel(new DefaultComboBoxModel<String>(new String[] {"Select...", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"}));
		
		txt_zip_billing = new JTextField();
		txt_zip_billing.setBounds(95, 430, 179, 20);
		txt_zip_billing.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(11, 469, 68, 14);
		lblCountry.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cmbo_country_billing = new JComboBox<String>();
		cmbo_country_billing.setBounds(95, 466, 179, 20);
		cmbo_country_billing.setModel(new DefaultComboBoxModel<String>(new String[] {"Select...", "United States", "Canada", "----------------", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"}));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(21, 582, 70, 0);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(282, 295, 104, 15);
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txt_phone_billing = new JTextField();
		txt_phone_billing.setText("1234567890");
		txt_phone_billing.setBounds(391, 292, 205, 20);
		txt_phone_billing.setHorizontalAlignment(SwingConstants.LEFT);
		txt_phone_billing.setColumns(10);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(282, 322, 104, 20);
		lblCardNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txt_ccn_billing = new JTextField();
		txt_ccn_billing.setBounds(391, 322, 205, 20);
		txt_ccn_billing.setColumns(10);
		
		JLabel lblExpDate = new JLabel("Exp. Date");
		lblExpDate.setBounds(282, 354, 104, 20);
		lblExpDate.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cmbo_month_billing = new JComboBox<String>();
		cmbo_month_billing.setBounds(391, 354, 102, 20);
		cmbo_month_billing.setModel(new DefaultComboBoxModel<String>(new String[] {"Month...", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		JLabel lblCvv = new JLabel("CVV2");
		lblCvv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCvv.setBounds(282, 392, 104, 20);
		
		txt_cvv2_billing = new JTextField();
		txt_cvv2_billing.setBounds(391, 392, 205, 20);
		txt_cvv2_billing.setColumns(10);
		
		cmbo_year_billing = new JComboBox<String>();
		cmbo_year_billing.setBounds(494, 354, 102, 20);
		cmbo_year_billing.setModel(new DefaultComboBoxModel<String>(new String[] {"Year...", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		
		btn_save = new JButton("Save");
		btn_save.setBounds(258, 542, 101, 29);
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				save_ad();
			}
		});
		
		btn_update = new JButton("Calculate Cost");
		btn_update.setBounds(83, 542, 101, 29);
		btn_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				DecimalFormat df = new DecimalFormat("#0.00");
				String num_columns = txt_columns.getText();
				String content = edit_content.getText();
				double total_rows = 0;
				if (num_columns.compareToIgnoreCase("") != 0 || content.compareToIgnoreCase("") != 0) {
					total_rows = (double) content.length() / (Double.valueOf(num_columns) * 20.0);
					txt_rows.setText(String.valueOf((int)Math.ceil(total_rows)));
				}
				/*Columns						1 	  2 	3 	  4
				Base cost (title and 2 lines) $4.00	$5.50 $6.50 $8.00      
				Each additional line 		  $0.50 $0.75 $1.50 $3.00	*/
				double cost = 0.0;
				double cost_per_line_extra =0.0;
				switch (Integer.valueOf(num_columns)) {
				case 1:
					cost = 4.00;
					cost_per_line_extra = 0.5;
					break;
				case 2:
					cost = 5.50;
					cost_per_line_extra = 0.75;
					break;
				case 3:
					cost = 6.50;
					cost_per_line_extra = 1.50;
					break;
				case 4:
					cost = 8.00;
					cost_per_line_extra = 3.00;
					break;
				default:
					cost = 0.0;
					break;						
				}
				if (total_rows > 2) {
					cost += (total_rows - 2)*cost_per_line_extra;
				}
				txt_cost.setText("$" + df.format(cost));
			}
		});
		
		btn_cancel = new JButton("Cancel");
		btn_cancel.setBounds(433, 542, 115, 29);
		btn_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int n = JOptionPane.showConfirmDialog(null, "Discard changes and cancel?", "Discard Changes",JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					//yes
					dispose();
				}
			}
		});
		
		separator = new JSeparator();
		separator.setBounds(11, 236, 634, 6);
		contentPane.setLayout(null);
		contentPane.add(separator);
		contentPane.add(lblBillingInformation);
		contentPane.add(btn_update);
		contentPane.add(btn_save);
		contentPane.add(label);
		contentPane.add(txt_id);
		contentPane.add(lblAdInformation);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(label_3);
		contentPane.add(txt_title);
		contentPane.add(lblDate);
		contentPane.add(txt_columns);
		contentPane.add(lblRows);
		contentPane.add(txt_rows);
		contentPane.add(lblCost);
		contentPane.add(txt_cost);
		contentPane.add(lblType);
		contentPane.add(cmbo_month);
		contentPane.add(cmbo_day);
		contentPane.add(cmbo_year);
		contentPane.add(cmbo_type);
		contentPane.add(edit_content);
		contentPane.add(separator_1);
		contentPane.add(label_6);
		contentPane.add(txt_city_billing);
		contentPane.add(label_7);
		contentPane.add(cmbo_state_billing);
		contentPane.add(label_4);
		contentPane.add(txt_name_billing);
		contentPane.add(label_5);
		contentPane.add(txt_address_billing);
		contentPane.add(label_8);
		contentPane.add(lblCountry);
		contentPane.add(cmbo_country_billing);
		contentPane.add(txt_zip_billing);
		contentPane.add(lblCardNumber);
		contentPane.add(lblPhoneNumber);
		contentPane.add(lblExpDate);
		contentPane.add(lblCvv);
		contentPane.add(txt_cvv2_billing);
		contentPane.add(cmbo_month_billing);
		contentPane.add(cmbo_year_billing);
		contentPane.add(txt_ccn_billing);
		contentPane.add(txt_phone_billing);
		contentPane.add(btn_cancel);
		
		chck_paid = new JCheckBox("Paid");
		chck_paid.setHorizontalAlignment(SwingConstants.RIGHT);
		chck_paid.setBounds(278, 466, 316, 20);
		contentPane.add(chck_paid);
		txt_id.setText(String.valueOf(AdsList.num_ads+1));

	}

	protected void save_ad() {
			
		try {
			/**
			 * This stuff is for the actual system, but isn't needed for the purposes of this demo.
			 */
			String billing_address  = this.txt_name_billing.getText();
			String billing_city 	= this.txt_city_billing.getText();
			String billing_state 	= this.cmbo_state_billing.getItemAt(this.cmbo_state_billing.getSelectedIndex());
			String billing_zip 		= this.txt_zip_billing.getText();
			String billing_country 	= this.cmbo_country_billing.getItemAt(this.cmbo_country_billing.getSelectedIndex());			
			String billing_ccn 		= this.txt_ccn_billing.getText();
			String billing_month	= this.cmbo_month_billing.getItemAt(this.cmbo_month_billing.getSelectedIndex());
			String billing_year 	= this.cmbo_year_billing.getItemAt(this.cmbo_year_billing.getSelectedIndex());
			String billing_cvv2 	= this.txt_cvv2_billing.getText();
			String billing_phone 	= this.txt_phone_billing.getText();
			String billing_name 	= this.txt_name_billing.getText();
			double billing_cost		= Double.valueOf(this.txt_cost.getText().substring(1));
			boolean billing_paid	= this.chck_paid.isSelected();
			
			String ad_title 		= this.txt_title.getText();
			String ad_month 		= this.cmbo_month.getItemAt(this.cmbo_month.getSelectedIndex());
			String ad_day 			= this.cmbo_day.getItemAt(this.cmbo_day.getSelectedIndex());
			String ad_year 			= this.cmbo_year.getItemAt(this.cmbo_year.getSelectedIndex());			
			String ad_content 		= this.edit_content.getText();
			int ad_columns 			= Integer.valueOf(this.txt_columns.getText());
			int ad_rows 			= Integer.valueOf(this.txt_rows.getText());
			int ad_type 			= Integer.valueOf(this.cmbo_type.getItemAt(this.cmbo_type.getSelectedIndex()).substring(0, 1));
			
			long latest_id 			= ++AdsList.num_ads;
			//int ID,String title, String content, int rows, int columns, TYPE type, String date
			Advertisement tmp_ad 	= new Advertisement(
					latest_id, ad_title, ad_content, (int) ad_rows, (int) ad_columns, TYPE.get(ad_type), ad_month, ad_day, ad_year,
					billing_paid,billing_cost,billing_name,billing_address,billing_city,billing_state,billing_zip,billing_country,
					billing_phone,billing_cvv2,billing_month,billing_year,billing_ccn);	
			//long ad_id,String name, String address, String credit_card_number, String phone_number, int cvv, boolean paid
			
			AdsList.ads_list.add(tmp_ad);
			AdsList.tbl_model.set_data(AdsList.ads_list);
			AdsList.save_ads();
			this.dispose();
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error. All fields must be filled in.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
