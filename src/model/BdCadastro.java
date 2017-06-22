package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import control.Cadastro;
import control.Login;
import view.FormLogin;

public class BdCadastro {
	
	
	public static void updateCadastro() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		String insert = "UPDATE CADASTRO SET "
				+ "NOME = '" + Cadastro.getNome() + "', "
				+ "CPF_CNPJ = " + Cadastro.getCnpj() + ", "
				+ "EMAIL = '" + Cadastro.getEmail() + "', "
				+ "SOBRE = '" + Cadastro.getSobre() + "', "
				+ "TELEFONE = " + Cadastro.getTelefone() + ", "
				+ "TELEFONE_2 = " + Cadastro.getTelefone2() + ", "
				+ "ATIVO = '1' "
				+ "WHERE ID_CADASTRO = " + Login.getCadastro(); 
		
				String insert2 = 
				" UPDATE ENDERECO SET"
				+ " CEP = " + Cadastro.getCep()
				+ ", NUMERO = " + Cadastro.getNumero()
				+ " WHERE ID_ENDERECO = " + Login.getIdEnd();

		try {
			dbConnection = ConnectionFactory.getConnection();
			statement = dbConnection.createStatement();

			System.out.println(insert);
			statement.executeUpdate(insert);
			statement.executeUpdate(insert2);
			System.out.println("Record inserted!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		
	}


}
