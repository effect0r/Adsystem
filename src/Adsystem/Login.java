package Adsystem;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8206053141819763367L;
	private JPanel contentPane;
	static JTextField user_name;

	/**
	 * Launch the application.
	 */
	
	public Login(MainWindow main) {
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("ICON2_Scaled.png"));
		setBounds(100, 100, 281, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(29, 30, 89, 17);
		contentPane.add(lblUsername);
		
		user_name = new JTextField();
		user_name.setBounds(147, 29, 89, 20);
		contentPane.add(user_name);
		user_name.setColumns(10);
		
		JButton btnOk = new JButton("Login");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name;
				name = user_name.getText();
				
				if(MainWindow.login(name)) {
					//login successful
					
				}else {
					//error.
				}
			}
		});
		btnOk.setBounds(29, 79, 89, 23);
		contentPane.add(btnOk);
		JRootPane rootPane = this.getRootPane();
	    rootPane.setDefaultButton(btnOk);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(147, 79, 89, 23);
		contentPane.add(btnCancel);
	}
}
