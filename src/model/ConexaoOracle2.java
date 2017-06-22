package model;
import java.sql.*;

public class ConexaoOracle2 {
	
	public static void main(String[] args) {
                
        /*
         *	O driver JDBC do Oracle está disponível no seguinte endereço:
         *	http://www.oracle.com/technetwork/database/features/jdbc/index-091264.html
         */

        // Configuração dos parâmetros de conexão
        String server = "localhost";
        String port = "1521";               // Porta TCP padrão do Oracle
        String database = "xe";

        // Configuração dos parâmetros de autenticação
        String user = "victor";
        String passwd = "193700";

        try {
            String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;

            // Abre-se a conexão com o Banco de Dados
            Connection con = DriverManager.getConnection(url, user, passwd);

            // Cria-se Statement com base na conexão con
            Statement stmt = con.createStatement();

            // Exemplo: cria-se uma tabela no Banco de Dados de Teste
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


