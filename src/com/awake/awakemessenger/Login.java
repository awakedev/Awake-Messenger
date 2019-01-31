package com.awake.awakemessenger;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JLabel lblIP;
	private JTextField txtIP;
	private JLabel lblPort;
	private JTextField txtPort;
	private JLabel lblPortDesc;
	private JLabel lblAddressDesc;

	
	public Login() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		setResizable(false);
		setFont(new Font("Adobe Gurmukhi", Font.PLAIN, 12));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,380);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(80, 43, 133, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(24, 46, 46, 14);
		contentPane.add(lblName);
		
		lblIP = new JLabel("IP Address:");
		lblIP.setBounds(10, 102, 89, 14);
		contentPane.add(lblIP);
		
		txtIP = new JTextField();
		txtIP.setColumns(10);
		txtIP.setBounds(80, 99, 133, 20);
		contentPane.add(txtIP);
		
		lblPort = new JLabel("Port:");
		lblPort.setBounds(24, 166, 46, 14);
		contentPane.add(lblPort);
		
		txtPort = new JTextField();
		txtPort.setColumns(10);
		txtPort.setBounds(80, 160, 133, 20);
		contentPane.add(txtPort);
		
		lblPortDesc = new JLabel("(e.g 8192)");
		lblPortDesc.setBounds(109, 184, 75, 14);
		contentPane.add(lblPortDesc);
		
		lblAddressDesc = new JLabel("(e.g 192.168.0.2)");
		lblAddressDesc.setBounds(95, 127, 104, 14);
		contentPane.add(lblAddressDesc);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String address = txtIP.getText();
				int port = Integer.parseInt(txtPort.getText());
				login(name, address, port);
			}

			
		});
		btnLogin.setBounds(102, 251, 89, 23);
		contentPane.add(btnLogin);
	}
	
	private void login(String name, String address, int port) {
		dispose();
		new Client(name, address, port);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


