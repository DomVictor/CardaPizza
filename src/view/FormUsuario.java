package view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import control.Cadastro;
import methods.ScreenSize;
import model.BdCadastro;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FormUsuario extends JFrame {

	private static JPanel contentPane;

	PainelPrincipal_Usuario PainelPrincipal_Usuario = new PainelPrincipal_Usuario();
	PanelProdutos panelProdutos = new PanelProdutos();
	Painel2 painel2 = new Painel2();
	PanelCadastroView_Usuario PanelCadastroView_Usuario = new PanelCadastroView_Usuario();
	PanelCadastroEdit_Usuario PanelCadastroEdit_Usuario = new PanelCadastroEdit_Usuario();
	Panel4 panel4 = new Panel4();
	Panel5 panel5 = new Panel5();
	 
	final static String PPU = "Painel Principal";
	final static String A = "Avaliações";
	final static String MP = "Meus Produtos";
	final static String C = "Meu Cadastro";
	final static String NL = "Nem Lembro";
	final static String CE = "Cadastro Edit";
	
	private JTextField txtCnpj;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtTelefone2;
	private JTextField txtCep;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtNome;
	private JComboBox cbEstado;
	private JTextArea txaSobre;
	private JTable table;
	private JTable table_1;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormUsuario frame = new FormUsuario();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} catch(Exception e) {
					  System.out.println("Error setting native LAF: " + e);
					}
			}
		});
	}

	private void selectedPanel(String g){
		 CardLayout cl = (CardLayout)(contentPane.getLayout());
		    cl.show(contentPane, g);
	}
	
	public FormUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(0, 0, ScreenSize.getScreenWidth(), ScreenSize.getScreenHeight());

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnAvaliacoes = new JButton("Avaliações");
		btnAvaliacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedPanel(PPU);
			}
		});
		menuBar.add(btnAvaliacoes);
		
		JButton btnProdutos = new JButton("Meus Produtos");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedPanel(A);
			}
		});
		menuBar.add(btnProdutos);
		
		JButton btnCadastro = new JButton("Meu Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedPanel(C);
			}
		});
		menuBar.add(btnCadastro);
		
		JButton btnPizzaria = new JButton("Minha Pizzaria");
		btnPizzaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedPanel(MP);
			}
		});
		menuBar.add(btnPizzaria);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		contentPane.add(PainelPrincipal_Usuario, PPU);
		
		JLabel lblNomeA = new JLabel("Nome Pizzaria - Avalia\u00E7oes");
		lblNomeA.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNomeA.setBounds(10, 11, 343, 22);
		PainelPrincipal_Usuario.add(lblNomeA);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 101, 810, 549);
		PainelPrincipal_Usuario.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JLabel lblAvaliaoGeral = new JLabel("Avalia\u00E7\u00E3o Geral: 4,7");
		lblAvaliaoGeral.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAvaliaoGeral.setBounds(1157, 12, 233, 22);
		PainelPrincipal_Usuario.add(lblAvaliaoGeral);
		
		JLabel lblNewLabel = new JLabel("Filtrar:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 76, 70, 14);
		PainelPrincipal_Usuario.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mais recentes", "Mais altas", "Mais baixas"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(57, 74, 111, 20);
		PainelPrincipal_Usuario.add(comboBox);
		
		JButton btnNewButton = new JButton("Responder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(1052, 611, 134, 39);
		PainelPrincipal_Usuario.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(830, 101, 500, 499);
		PainelPrincipal_Usuario.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(1196, 611, 134, 39);
		PainelPrincipal_Usuario.add(btnNewButton_1);
		contentPane.add(panelProdutos, A);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblProdutos.setBounds(10, 11, 178, 32);
		panelProdutos.add(lblProdutos);
		
		table_1 = new JTable();
		table_1.setBounds(10, 71, 1175, 592);
		panelProdutos.add(table_1);
		
		JButton button = new JButton("Alterar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(1195, 71, 134, 39);
		panelProdutos.add(button);
		
		JButton button_1 = new JButton("Excluir");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(1195, 121, 135, 39);
		panelProdutos.add(button_1);
		
		JButton button_2 = new JButton("Novo");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_2.setBounds(1195, 173, 134, 39);
		panelProdutos.add(button_2);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVoltar.setBounds(1195, 624, 134, 39);
		panelProdutos.add(btnVoltar);
		contentPane.add(painel2, MP);
		contentPane.add(PanelCadastroView_Usuario, C);
		contentPane.add(PanelCadastroEdit_Usuario, CE);
		contentPane.add(panel4, NL);
		
		
		// Panel Cadastro View Conteúdo
		JLabel lblNomePizzaria = new JLabel(Cadastro.getNome());
		lblNomePizzaria.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNomePizzaria.setBounds(150, 5, 739, 25);
		PanelCadastroView_Usuario.add(lblNomePizzaria);
		
		JLabel lblCnpj = new JLabel("Cnpj: " + Cadastro.getCnpj());
		lblCnpj.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblCnpj.setBounds(150, 70, 100, 20);
		PanelCadastroView_Usuario.add(lblCnpj);
		
		JLabel lblEmail = new JLabel("E-mail: " + Cadastro.getEmail());
		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblEmail.setBounds(150, 110, 100, 20);
		PanelCadastroView_Usuario.add(lblEmail);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(6, 6, 130, 128);
		PanelCadastroView_Usuario.add(panel);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEndereco.setBounds(6, 200, 150, 20);
		PanelCadastroView_Usuario.add(lblEndereco);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRua.setBounds(253, 255, 50, 20);
		PanelCadastroView_Usuario.add(lblRua);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumero.setBounds(706, 255, 70, 20);
		PanelCadastroView_Usuario.add(lblNumero);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCep.setBounds(6, 260, 46, 14);
		PanelCadastroView_Usuario.add(lblCep);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBairro.setBounds(952, 255, 108, 20);
		PanelCadastroView_Usuario.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCidade.setBounds(6, 300, 94, 20);
		PanelCadastroView_Usuario.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstado.setBounds(390, 300, 94, 20);
		PanelCadastroView_Usuario.add(lblEstado);
		
		JLabel lblSobre = new JLabel("Sobre:");
		lblSobre.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSobre.setBounds(6, 404, 108, 25);
		PanelCadastroView_Usuario.add(lblSobre);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone.setBounds(875, 76, 70, 20);
		PanelCadastroView_Usuario.add(lblTelefone);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPanel(CE);
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEditar.setBounds(1160, 601, 170, 46);
		PanelCadastroView_Usuario.add(btnEditar);
		
		
		// Panel Cadastro Edit Conteúdo
		JLabel lblNomePizzariaE = new JLabel("Nome: ");
		lblNomePizzariaE.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNomePizzariaE.setBounds(150, 5, 739, 25);
		PanelCadastroEdit_Usuario.add(lblNomePizzariaE);
		
		JLabel lblCnpjE = new JLabel("Cnpj: ");
		lblCnpjE.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblCnpjE.setBounds(150, 70, 100, 20);
		PanelCadastroEdit_Usuario.add(lblCnpjE);
		
		JLabel lblEmailE = new JLabel("E-mail:");
		lblEmailE.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblEmailE.setBounds(150, 110, 100, 20);
		PanelCadastroEdit_Usuario.add(lblEmailE);
		
		JPanel FotoPerfilE = new JPanel();
		FotoPerfilE.setBackground(new Color(0, 102, 153));
		FotoPerfilE.setBounds(6, 6, 130, 128);
		PanelCadastroEdit_Usuario.add(FotoPerfilE);
		
		JLabel lblEnderecoE = new JLabel("Endere\u00E7o:");
		lblEnderecoE.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEnderecoE.setBounds(6, 200, 150, 20);
		PanelCadastroEdit_Usuario.add(lblEnderecoE);
		
		JLabel lblRuaE = new JLabel("Rua:");
		lblRuaE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRuaE.setBounds(253, 255, 50, 20);
		PanelCadastroEdit_Usuario.add(lblRuaE);
		
		JLabel lblNumeroE = new JLabel("N\u00FAmero:");
		lblNumeroE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroE.setBounds(706, 255, 70, 20);
		PanelCadastroEdit_Usuario.add(lblNumeroE);
		
		JLabel lblCepE = new JLabel("CEP:");
		lblCepE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCepE.setBounds(6, 260, 46, 14);
		PanelCadastroEdit_Usuario.add(lblCepE);
		
		JLabel lblBairroE = new JLabel("Bairro:");
		lblBairroE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBairroE.setBounds(952, 255, 108, 20);
		PanelCadastroEdit_Usuario.add(lblBairroE);
		
		JLabel lblCidadeE = new JLabel("Cidade:");
		lblCidadeE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCidadeE.setBounds(6, 300, 94, 20);
		PanelCadastroEdit_Usuario.add(lblCidadeE);
		
		JLabel lblEstadoE = new JLabel("Estado:");
		lblEstadoE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstadoE.setBounds(390, 300, 70, 20);
		PanelCadastroEdit_Usuario.add(lblEstadoE);
		
		JLabel lblSobreE = new JLabel("Sobre:");
		lblSobreE.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSobreE.setBounds(6, 404, 108, 25);
		PanelCadastroEdit_Usuario.add(lblSobreE);
		
		JLabel lblTelefoneE = new JLabel("Telefone:");
		lblTelefoneE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefoneE.setBounds(875, 76, 70, 20);
		PanelCadastroEdit_Usuario.add(lblTelefoneE);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = txtNome.getText();
				Cadastro.setNome(nome);
				String cnpj = txtCnpj.getText();
				Cadastro.setCnpj(cnpj);
				String email = txtEmail.getText();
				Cadastro.setEmail(email);
				String telefone = txtTelefone.getText();
				Cadastro.setTelefone(telefone);
				String telefone2 = txtTelefone2.getText();
				Cadastro.setTelefone2(telefone2);
				String cep = txtCep.getText();
				Cadastro.setCep(cep);
				String rua = txtRua.getText();
				Cadastro.setRua(rua);
				String numero = txtNumero.getText();
				Cadastro.setNumero(numero);
				String bairro = txtBairro.getText();
				Cadastro.setBairro(bairro);
				String cidade = txtCidade.getText();
				Cadastro.setCidade(cidade);
				String estado = String.valueOf(cbEstado.getSelectedItem());
				Cadastro.setEstado(estado);
				String sobre = txaSobre.getText();
				Cadastro.setSobre(sobre);
				try {
					BdCadastro.updateCadastro();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				selectedPanel(C);
				
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSalvar.setBounds(1160, 601, 170, 46);
		PanelCadastroEdit_Usuario.add(btnSalvar);
		
		txtCnpj = new JTextField();
		txtCnpj.setBounds(195, 70, 298, 20);
		PanelCadastroEdit_Usuario.add(txtCnpj);
		txtCnpj.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(205, 110, 354, 20);
		PanelCadastroEdit_Usuario.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(949, 76, 274, 20);
		PanelCadastroEdit_Usuario.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblTelefone2E = new JLabel("Telefone 2:");
		lblTelefone2E.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone2E.setBounds(875, 116, 85, 20);
		PanelCadastroEdit_Usuario.add(lblTelefone2E);
		
		txtTelefone2 = new JTextField();
		txtTelefone2.setBounds(970, 116, 253, 20);
		PanelCadastroEdit_Usuario.add(txtTelefone2);
		txtTelefone2.setColumns(10);
		
		txtCep = new JTextField();
		txtCep.setBounds(50, 257, 155, 20);
		PanelCadastroEdit_Usuario.add(txtCep);
		txtCep.setColumns(10);
		
		txtRua = new JTextField();
		txtRua.setBounds(293, 257, 359, 20);
		PanelCadastroEdit_Usuario.add(txtRua);
		txtRua.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(778, 257, 100, 20);
		PanelCadastroEdit_Usuario.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(1007, 257, 298, 20);
		PanelCadastroEdit_Usuario.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(67, 302, 253, 20);
		PanelCadastroEdit_Usuario.add(txtCidade);
		txtCidade.setColumns(10);
		
		cbEstado = new JComboBox();
		cbEstado.setModel(new DefaultComboBoxModel(new String[] {"AM", "AC", "AL", "RO", "RR", "AP", "SE", "PE", "BA", "PI", "PB", "CE", "MA", "RS", "SC", "RJ", "ES", "MG", "MT", "MS", "PR", "PA", "GO", "SP", "TO", "RN"}));
		cbEstado.setBounds(452, 302, 50, 20);
		PanelCadastroEdit_Usuario.add(cbEstado);
		
		txaSobre = new JTextArea();
		txaSobre.setBounds(6, 440, 1300, 137);
		PanelCadastroEdit_Usuario.add(txaSobre);
		
		txtNome = new JTextField();
		txtNome.setBounds(217, 5, 728, 26);
		PanelCadastroEdit_Usuario.add(txtNome);
		txtNome.setColumns(10);
		
	}
}
