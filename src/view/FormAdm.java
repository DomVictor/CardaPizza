package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import methods.ScreenSize;
import java.awt.Panel;

public class FormAdm extends JFrame {

	PainelPrincipal_Administrador painelPrincipal_Administrador = new PainelPrincipal_Administrador();
	
	
	private JPanel contentPane;
	
	
	final static String PPA = "Painel Principal";
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAdm frame = new FormAdm();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unused")
	private void selectedPanel(String g){
		 CardLayout cl = (CardLayout)(contentPane.getLayout());
		    cl.show(contentPane, g);
	}
	
	public FormAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, ScreenSize.getScreenWidth(), ScreenSize.getScreenHeight());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		contentPane.add(painelPrincipal_Administrador, PPA);
		
	}
	
	

}
