package br.com.feltex.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe responsável pela Conexão com o Banco de dados. É utilizada por outras
 * classes de persistência de dados.
 * 
 */
public class DAO {
	public Connection getConexao() {
		Connection conexao = null;
		String usuario = "postgres";
		String senha = "teco01";
		String nomeBancoDados = "bdacademicnet";

		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nomeBancoDados,
					 usuario, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
}