      package model;

import java.sql.*;
import javax.swing.*;

public class TesteDeConexao {
	public static void main(String[] args) {
		try {
			new ConnectionFactory();
			Connection conexao = ConnectionFactory.getConnection();
			JOptionPane.showMessageDialog(null,
					"Conexão realizada com sucesso!");
			conexao.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,
					"Problemas com a fonte de dados!", "Falha", 0);
		}
	}
}


