package conexaoBanco;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Classes.Login;

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
						+ " from usuario join cadastro on usuario = '" + usuario + "' and senha = '" + senha + "' and"
						+ " ");
				rs = stmt.executeQuery();
				
				
				while(rs.next())
				{
					Login.setUsuario(rs.getString("usuario"));
					Login.setSenha(rs.getString("senha"));
					Login.setNivel(Integer.valueOf(rs.getString("privilegio")));
					Login.setCadastro(Integer.valueOf(rs.getString("id_cadastro")));
					stmt2 = conn.prepareStatement("select id_endereco from usuario where usuario = " + Login.getUsuario());
					rs2 = stmt2.executeQuery();
					Login.setIdEnd(Integer.parseInt(rs2.getString("id_endereco")));
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
