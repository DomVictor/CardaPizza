package model;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import control.Login;

public class BdLogin 
{
	public static int ListLogin(String usuario, String senha) throws SQLException
	{
		
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			PreparedStatement stmt2 = null;
			ResultSet rs2 = null;
			ResultSet rs = null;
			int id = 0;

			try
			{	
				stmt = conn.prepareStatement("Select u.usuario, u.senha, u.privilegio, u.id_cadastro, c.id_endereco"
						+ " from usuario u join cadastro c on u.usuario = '" + usuario + "' and u.senha = '" + senha + "' and"
						+ " u.id_cadastro = c.id_cadastro");
				rs = stmt.executeQuery();
				
				
				while(rs.next())
				{
					Login.setUsuario(rs.getString("usuario"));
					Login.setSenha(rs.getString("senha"));
					Login.setNivel(Integer.valueOf(rs.getString("privilegio")));
					Login.setCadastro(Integer.valueOf(rs.getString("id_cadastro")));
					Login.setIdEnd(Integer.parseInt(rs.getString("id_endereco")));
				}
			}
			catch(SQLException e)
			{
				Logger.getLogger(BdLogin.class.getName()).log(Level.SEVERE, null, e);
			}
			finally
			{
				ConnectionFactory.closeConnection(conn, stmt, rs);
			}
			return id;
			
		}
		
}
