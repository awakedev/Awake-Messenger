package com.awake.awakemessenger;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Client extends JFrame {

	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private String name, address;
	private int port;
	private JTextField txtMessage;
	private JTextArea txtAreaHistory;

	public Client(String name, String address, int port) {
		setTitle("Awake Messenger Client");
		this.name = name;
		this.address = address;
		this.port = port;
		createWindow();
		//console("Attempting connection to " + address + " : " + port + "with user: " + name);
		console("Attempting connection to " + name);

		console("Successfully disconnected!");

	}
	
	private void createWindow() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(880, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{28, 815, 7};
		gbl_contentPane.rowHeights = new int[]{35, 475, 0, 40};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		txtAreaHistory = new JTextArea();
		txtAreaHistory.setEditable(false);
		GridBagConstraints gbc_txtAreaHistory = new GridBagConstraints();
		gbc_txtAreaHistory.insets = new Insets(0, 0, 5, 5);
		gbc_txtAreaHistory.fill = GridBagConstraints.BOTH;
		gbc_txtAreaHistory.gridx = 1;
		gbc_txtAreaHistory.gridy = 1;
		gbc_txtAreaHistory.gridwidth = 2;
		gbc_txtAreaHistory.insets = new Insets(0, 5, 0, 0);
		
		contentPane.add(txtAreaHistory, gbc_txtAreaHistory);
		
		txtMessage = new JTextField();
		txtMessage.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				send(txtMessage.getText());
				}
			}
		});
		
		GridBagConstraints gbc_txtMessage = new GridBagConstraints();
		gbc_txtMessage.anchor = GridBagConstraints.NORTH;
		gbc_txtMessage.insets = new Insets(0, 0, 5, 5);
		gbc_txtMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMessage.gridx = 1;
		gbc_txtMessage.gridy = 2;
		contentPane.add(txtMessage, gbc_txtMessage);
		txtMessage.setColumns(10);

		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send(txtMessage.getText());
			}
		});
		
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.gridx = 2;
		gbc_btnSend.gridy = 3;
		contentPane.add(btnSend, gbc_btnSend);
		
		setVisible(true);	
		
		txtMessage.requestFocusInWindow();
	}
	
	public void console(String message) {
		txtAreaHistory.append(message + "\n\r");
	}
	
	private void send(String message) {
		if (message.equals("")) return ;
		message = name + ": " + message;
		console(message);
		txtMessage.setText("");
	}

}
