package gui;

import controller.ReservaController;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {
	public ReservaController controller;
	public Ventana(ReservaController controller) {
		this.controller = controller;
	}
	
	public Ventana() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		this.setSize(600,400);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login=new Login(controller);
				login.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton.setBounds(70, 214, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registro");
		btnNewButton_1.setBounds(296, 214, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a EasyBooking");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(59, 69, 326, 48);
		getContentPane().add(lblNewLabel);
		
	}
	
	public static void main(String[] args) {
		Ventana v=new Ventana();
		v.setVisible(true);

	}
}
