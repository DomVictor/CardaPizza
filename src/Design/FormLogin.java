package Design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Classes.Login;
import conexaoBanco.BdLogin;
import oracle.jdbc.OracleData;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class FormLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	public static String cadastro;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
		
	public FormLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(300, 250, 363, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setBounds(10, 78, 115, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(22, 123, 67, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(99, 75, 238, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
			
		txtSenha = new JTextField();
		txtSenha.setBounds(99, 117, 238, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
				try {
					BdLogin.ListLogin(txtUsuario.getText(), txtSenha.getText());
					if(Login.getUsuario().equals(txtUsuario.getText()) && Login.getSenha().equals(txtSenha.getText()))
					{
						JOptionPane.showMessageDialog(null, "Logado com sucesso!");
						if(Login.getNivel() == 1)
						{
							FormAdm f = new FormAdm();
							f.setVisible(true);
						}
						else
						{
							FormUsuario fu = new FormUsuario();
							fu.setVisible(true);
							
								
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		);
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEntrar.setBounds(245, 162, 96, 32);
		contentPane.add(btnEntrar);
	}
}