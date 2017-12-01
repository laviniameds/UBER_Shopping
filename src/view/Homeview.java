package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Homeview extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoginUsuario;
	private JPasswordField txtLoginPassword;
	private JLabel lblUsurio;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homeview frame = new Homeview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Homeview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(157, 199, 117, 25);
		contentPane.add(btnLogin);
		
		txtLoginUsuario = new JTextField();
		txtLoginUsuario.setBounds(157, 107, 114, 19);
		contentPane.add(txtLoginUsuario);
		txtLoginUsuario.setColumns(10);
		
		txtLoginPassword = new JPasswordField();
		txtLoginPassword.setBounds(157, 138, 117, 19);
		contentPane.add(txtLoginPassword);
		
		JLabel lblNewLabel = new JLabel("UBER SHOPPING");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(68, 34, 293, 53);
		contentPane.add(lblNewLabel);
		
		lblUsurio = new JLabel("Usuário:");
		lblUsurio.setBounds(69, 109, 70, 15);
		contentPane.add(lblUsurio);
		
		lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(68, 140, 70, 15);
		contentPane.add(lblNewLabel_1);
	}
}
