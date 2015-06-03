package Adsystem;

import java.awt.Dimension;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

public class AdsList extends JFrame {
	public static long num_ads = 0;
	private static final long serialVersionUID = -1318422114742712238L;
	private JTable table;
	public static ArrayList<Advertisement> ads_list;
	public static MyTableModel tbl_model;
	static Calendar current_day;

	/**
	 * Create the frame.
	 */
	public AdsList() {
		String pattern = "MMM d, yyyy";
		@SuppressWarnings("unused")
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		current_day = new GregorianCalendar();
		// System.out.println(format.format(current_day.getTime()));
		ads_list = new ArrayList<>();
		populate_ads();
		update();
	}

	public static void save_ads() {
		File file = new File("ads.db");
		try {
			file.createNewFile();
			FileWriter fileWriter;

			fileWriter = new FileWriter(file);
			fileWriter.write("[");
			for (Advertisement a : ads_list) {
				fileWriter.write(a.unpaid_info().toJSONString());
			}
			fileWriter.append("]");
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {

		}

	}

	private void populate_ads() {
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("ads.db"));
			long max_id = 0;
			JSONArray jsonObject = (JSONArray) obj;
			for (int i = 0; i < jsonObject.size(); i++) {
				JSONObject jobj = (JSONObject) jsonObject.get(i);
				boolean billing_paid = (boolean) jobj.get("Paid");
				double billing_cost = (double) jobj.get("Cost");
				long type = (long) jobj.get("Type");
				long rows = (long) jobj.get("Rows");
				long columns = (long) jobj.get("Columns");
				long ID = (long) jobj.get("ID");
				String content = (String) jobj.get("Content");
				String title = (String) jobj.get("Title");
				String month = (String) jobj.get("Month");
				String day = (String) jobj.get("Day");
				String year = (String) jobj.get("Year");
				String billing_name = (String) jobj.get("Name");
				String billing_address = (String) jobj.get("Address");
				String billing_city = (String) jobj.get("City");
				String billing_state = (String) jobj.get("State");
				String billing_zip = (String) jobj.get("Zip");
				String billing_country = (String) jobj.get("Country");
				String billing_phone = (String) jobj.get("Phone");
				String billing_cvv2 = (String) jobj.get("CVV2");
				String billing_month = (String) jobj.get("ExpMonth");
				String billing_year = (String) jobj.get("ExpYear");
				String billing_ccn = (String) jobj.get("CCN");

				ads_list.add(new Advertisement(ID, title, content, (int) rows, (int) columns, TYPE.get(type), month, day, year, billing_paid, billing_cost, billing_name, billing_address, billing_city, billing_state, billing_zip, billing_country, billing_phone, billing_cvv2, billing_month, billing_year, billing_ccn));
				if (max_id < ID) {
					max_id = ID;
				}
			}
			AdsList.num_ads = max_id;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update() {
		tbl_model = new MyTableModel(ads_list);
		this.table = new JTable(tbl_model);
		this.table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		this.table.setFillsViewportHeight(true);
		this.table.setAutoCreateRowSorter(true);

		final JPopupMenu popupMenu = new JPopupMenu();
		addPopup(this.table, popupMenu);

		JMenuItem mntmEdit = new JMenuItem("View/Edit");
		mntmEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent anEvent) {
				if (anEvent.getButton() == 1) {
					// user LEFT CLICKED (selected)

					Object ad_id = table.getValueAt(table.getSelectedRow(), 0);
					Advertisement ad = null;
					for (Advertisement a : ads_list) {
						if (a.getId() == (long) ad_id) {
							ad = a;
						}
					}
					EditAd edit_ad = new EditAd(ad);
					edit_ad.setVisible(true);
				}
			}
		});
		popupMenu.add(mntmEdit);

		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent anEvent) {
				if (anEvent.getButton() == 1) {

					// user LEFT CLICKED (selected)
					Object[] data_row = tbl_model.getRowAt(table.getSelectedRow());
					long ad_id = (long) data_row[0];
					Advertisement ad = null;
					for (Advertisement a : ads_list) {
						if (a.getId() == ad_id) {
							ad = a;
						}
					}
					if (MainWindow.current_user.getLevel() == 2) {
						// can delete.
						// confirm deletion.
						int n = JOptionPane.showConfirmDialog(null, "Are you sure you wish to delete?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
						if (n == 0) {
							if (ad.isBilling_paid()) {
								// is paid, refund
								int j = JOptionPane.showConfirmDialog(null, "Issue refund?", "Refund", JOptionPane.YES_NO_OPTION);
								if (j == 0) {
									JOptionPane.showMessageDialog(null, "Refund request sent to billing.", "Refund Request", JOptionPane.PLAIN_MESSAGE);
								}
							}
							ads_list.remove(ad);
							AdsList.save_ads();
							tbl_model.set_data(ads_list);
						}
					}
				}
			}
		});
		popupMenu.add(mntmDelete);
		TableColumn column = null;
		for (int i = 0; i < 5; i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 4) {
				column.setPreferredWidth(150); // third column is bigger
			} else if (i == 3) {
				column.setPreferredWidth(50);
			} else if (i == 1 || i == 2) {
				column.setPreferredWidth(200);
			} else {
				column.setPreferredWidth(100);
			}
		}
		this.table.setEnabled(false);
		this.table.setVisible(false);
		this.table.getTableHeader().setReorderingAllowed(false);
		DefaultTableCellRenderer center_renderer = new DefaultTableCellRenderer();
		center_renderer.setHorizontalAlignment(JLabel.CENTER);
		this.table.getColumnModel().getColumn(0).setCellRenderer(center_renderer);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent anEvent) {
				if (anEvent.isPopupTrigger()) {
					JTable source = (JTable) anEvent.getSource();
					int row = source.rowAtPoint(anEvent.getPoint());
					int column = source.columnAtPoint(anEvent.getPoint());
					if (!source.isRowSelected(row))
						source.changeSelection(row, column, false, false);
					popup.show(anEvent.getComponent(), anEvent.getX(), anEvent.getY());
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public JTable get_table() {
		return this.table;
	}
}

class MyTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames = { "Ad ID", "Name", "Title", "Paid?", "Date" };
	public Object[][] data;

	public MyTableModel(ArrayList<Advertisement> list) {
		if (list.isEmpty()) {
			data[0] = new Object[] { "Empty", "Empty", "Empty", "Empty", "Empty" };
		} else {
			data = new Object[list.size()][columnNames.length];
			for (int i = 0; i < list.size(); i++) {
				Advertisement a = list.get(i);
				Object[] temp = { new Long(a.getId()), a.getBilling_name(), a.getTitle(), a.isBilling_paid(), new String(a.getDate()) };
				data[i] = temp;
			}
		}
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object[] getRowAt(int row) {
		return data[row];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/*
	 * Don't need to implement this method unless your table's editable.
	 */
	public boolean isCellEditable(int row, int col) {
		// Note that the data/cell address is constant,
		// no matter where the cell appears onscreen.
		return false;
	}

	/*
	 * Don't need to implement this method unless your table's data can change.
	 */
	public void set_data(ArrayList<Advertisement> list) {
		if (list.isEmpty()) {
			data[0] = new Object[] { "Empty", "Empty", "Empty", "Empty", "Empty" };
			fireTableDataChanged();
		} else {
			data = new Object[list.size()][columnNames.length];
			for (int i = 0; i < list.size(); i++) {
				Advertisement a = list.get(i);
				Object[] temp = { new Long(a.getId()), a.getBilling_name(), a.getTitle(), a.isBilling_paid(), new String(a.getDate()) };
				data[i] = temp;
			}
			fireTableDataChanged();
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

		return data[rowIndex][columnIndex];

	}

}
