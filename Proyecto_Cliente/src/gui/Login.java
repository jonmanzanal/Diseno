package gui;

import javax.swing.JFrame;

import controller.ReservaController;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login  extends JFrame  {
	public ReservaController controller;
	private JTextField textField;
	private JTextField textField_1;
	public Login(ReservaController controller) {
		this.controller = controller;
	}
	private String u;
	private String p;
	
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setSize(600,400);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(284, 203, 89, 23);
		getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				u=textField.getText();
				p=textField_1.getText();
				
			}
		});
		textField = new JTextField();
		textField.setBounds(159, 109, 135, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 161, 135, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(161, 84, 48, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(159, 140, 76, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Google");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 25));
		lblNewLabel_2.setBounds(161, 30, 117, 43);
		getContentPane().add(lblNewLabel_2);
		
		
	}
	
	public void login() {
		System.out.println(" - Login into the server: '" + u + "' - '" + p + "'");
		
		boolean loginResult = controller.login(u, p);
		
		System.out.println("    * Login result: " + loginResult);
	}
	public static void main(String[] args) {
		

	}
}
