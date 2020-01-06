package gui;

import javax.swing.JFrame;

import controller.ReservaController;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Registro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ReservaController controller;
	private JTextField textField;
	public Registro(ReservaController controller) {
		this.controller = controller;
		iniciarRegistro();
	}
	
	private void iniciarRegistro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setSize(600,400);
		textField = new JTextField();
		textField.setBounds(48, 142, 96, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(48, 105, 48, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblUsuarioARegistrar = new JLabel("Usuario a registrar");
		lblUsuarioARegistrar.setBounds(48, 38, 328, 29);
		getContentPane().add(lblUsuarioARegistrar);
		
		JButton btnNewButton = new JButton("Registro");
		btnNewButton.setBounds(48, 192, 89, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean b=registro(textField.getText());
				if(b) {
					JOptionPane.showConfirmDialog(null, "registro efectuado");
					dispose();
					Ventana ventana=new Ventana(controller);
					ventana.setVisible(true);
				
			}}
		});
		
	}
	public boolean registro(String email) {
		boolean b = controller.registro(email);
		return b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
