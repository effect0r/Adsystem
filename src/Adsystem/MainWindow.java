package Adsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ComponentOrientation;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import java.awt.Component;

import javax.swing.SwingConstants;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class MainWindow {

	private static JFrame main_gui;
	private static NewAd new_ad_frame;
	private static ArrayList<User> users;
	private static Login login;
	private static JButton btnCreateNewAd;
	private static JButton btnLogout;
	private static AdsList list;
	public static User current_user;
	private static JTable table;
	private static JButton btn_unpaid;
	private static JButton btn_pagination;

	/*
	 * int n = JOptionPane.showConfirmDialog( frame,
	 * "Are you sure you wish to delete?", "Confirm Deletion",
	 * JOptionPane.YES_NO_OPTION);
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.main_gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		users = new ArrayList<>();
		Scanner s;
		try {
			s = new Scanner(new File("usernames.db"));
			while (s.hasNext()) {
				users.add(new User(s.next(), s.nextInt()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (@SuppressWarnings("unused")
		User u : users) {
			// System.out.println("User: " + u);
		}
		initialize();
		login = new Login(this);
		login.setLocation(main_gui.getWidth() / 2, main_gui.getHeight() / 2);
		login.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		main_gui = new JFrame();
		main_gui.setIconImage(Toolkit.getDefaultToolkit().getImage("ICON2_Scaled.png"));
		main_gui.setResizable(false);
		main_gui.setTitle("Ad System Database");

		main_gui.setBounds(100, 100, 1024, 610);
		main_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_gui.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int window_width = main_gui.getWidth();
				// int height = menuBar.getHeight();
				int window_height = main_gui.getHeight();

				// menuBar.setSize(window_width, height);
				login.setLocation((window_width - 125) / 2, (window_height) / 2);
				// main_gui.pack();
			}
		});

		btnLogout = new JButton("Logout");
		btnLogout.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnLogout.setEnabled(false);
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				logout();
			}

			private void logout() {
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you wish to logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					btnLogout.setEnabled(false);
					btnCreateNewAd.setEnabled(false);
					login.setVisible(true);
					table.setEnabled(false);
					table.setVisible(false);
					btn_pagination.setEnabled(false);
					btn_unpaid.setEnabled(false);
					main_gui.setTitle("Ad System Database");
				}
			}
		});
		btnLogout.setToolTipText("Logout of the system");

		btnCreateNewAd = new JButton("Create New Ad");
		btnCreateNewAd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new_ad_frame = new NewAd();
				new_ad_frame.setVisible(true);
			}
		});
		btnCreateNewAd.setActionCommand("Create New Ad");
		btnCreateNewAd.setToolTipText("Opens dialog to create a new ad");
		btnCreateNewAd.setEnabled(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);

		btn_pagination = new JButton("Pagination Report");
		btn_pagination.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int n = JOptionPane.showConfirmDialog( null,
						  "Are you sure?", "Confirm Pagination",
						  JOptionPane.YES_NO_OPTION);
				if (n == 0 ) {
					@SuppressWarnings("unused")
					GenerateReport report = new GenerateReport(1);
				}
			}
		});
		btn_pagination.setToolTipText("Generate report sent to pagination");
		btn_pagination.setEnabled(false);
		btn_pagination.setActionCommand("Create New Ad");

		btn_unpaid = new JButton("Unpaid Ads Report");
		btn_unpaid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int n = JOptionPane.showConfirmDialog( null,
						  "Are you sure?", "Confirm Ads Report",
						  JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					@SuppressWarnings("unused")
					GenerateReport report = new GenerateReport(2);
				}
			}
		});
		btn_unpaid.setToolTipText("Generate report sent to Manager");
		btn_unpaid.setEnabled(false);
		btn_unpaid.setActionCommand("Create New Ad");
		GroupLayout groupLayout = new GroupLayout(main_gui.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE).addComponent(btnCreateNewAd, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE).addComponent(btn_pagination, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)).addComponent(btn_unpaid, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)).addGap(10).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false).addComponent(scrollPane, Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnCreateNewAd, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(btn_pagination, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(btn_unpaid, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))).addGap(616)));
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] { btnLogout, btnCreateNewAd });
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] { btnLogout, btnCreateNewAd });
		list = new AdsList();
		table = list.get_table();
		scrollPane.setViewportView(table);
		main_gui.getContentPane().setLayout(groupLayout);

	}

	public static boolean login(String user) {
		// do stuff to login.
		if (veryify_creditials(user)) {
			int i = 0;
			int index = -1;
			for (User u : users) {
				if (users.get(i).equals(u)) {
					index = i;
					main_gui.setTitle("Ad System Database. Logged in as " + user);
					break;
				}
				i++;
			}
			if (index >= 0) {
				switch (users.get(index).getLevel()) {
				case 2:
					btnLogout.setVisible(true);
					btnCreateNewAd.setVisible(true);
					btnLogout.setEnabled(true);
					btnCreateNewAd.setEnabled(true);
					login.setVisible(false);
					table.setEnabled(true);
					table.setVisible(true);
					btn_pagination.setVisible(true);
					btn_pagination.setEnabled(true);
					btn_unpaid.setVisible(true);
					btn_unpaid.setEnabled(true);
					break;
				case 1:
					btnLogout.setVisible(true);
					btnCreateNewAd.setVisible(true);
					btnLogout.setEnabled(true);
					btnCreateNewAd.setEnabled(true);
					login.setVisible(false);
					table.setEnabled(true);
					table.setVisible(true);
					btn_pagination.setVisible(true);
					btn_pagination.setEnabled(true);
					btn_unpaid.setVisible(true);
					btn_unpaid.setEnabled(true);
					break;
				default:
					break;
				}
				Login.user_name.setText("");
				
				return true;
			}
		}
		return false;
	}

	private static boolean veryify_creditials(String user) {
		User to_check = new User(user);
		for (User u : users) {
			if (u.equals(to_check)) {
				current_user = u;
				return true;
			}
		}
		return false;

	}
}
