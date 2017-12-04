package br.com.feltex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.feltex.entidade.Aluno;

/**
 * 
 * Classe de Persistência de dados dos objetos de Aluno
 * é "filha" da Classe DAO. 
 *
 */

public class AlunoDAO extends DAO {

	public void alterar(Aluno aluno) {
		try {
			Connection conexao = getConexao();

			PreparedStatement pstmt = conexao
					.prepareStatement("Update tbaluno SET nome = ?, telefone = ?, email = ?, datacadastro = ?,"
							+ " WHERE matricula = ? ");
			pstmt.setString(1, aluno.getNome());
			pstmt.setString(2, aluno.getTelefone());
			pstmt.setString(3, aluno.getEmail());
			pstmt.setDate(4, new java.sql.Date(aluno.getDataCadastro().getTime()));
			pstmt.setLong(5, aluno.getMatricula());
			pstmt.execute();
			pstmt.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Aluno aluno) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Delete from	tbaluno where matricula = ? ");
			pstm.setLong(1, aluno.getMatricula());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean existe(Aluno aluno) {
		boolean achou = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from tbaluno where matricula =	?");
			pstm.setLong(1, aluno.getMatricula());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				achou = true;
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return achou;
	}

	public void inserir(Aluno aluno) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Insert into	tbaluno (matricula, nome, telefone, email, datacadastro) values	(?,?,?,?,?)");
			pstm.setLong(1, aluno.getMatricula());
			pstm.setString(2, aluno.getNome());
			pstm.setString(3, aluno.getTelefone());
			pstm.setString(4, aluno.getEmail());
			pstm.setDate(5, new java.sql.Date(aluno.getDataCadastro()
					.getTime()));
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Aluno> listar() {
		List<Aluno> lista = new ArrayList<>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from tbaluno");
			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getLong("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setEmail(rs.getString("email"));
				aluno.setDataCadastro(new java.util.Date(rs.getDate("datacadastro").getTime()));
				lista.add(aluno);
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Aluno consultar(Aluno aluno) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from tbaluno where matricula =	?");
			pstm.setLong(1, aluno.getMatricula());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				aluno.setMatricula(rs.getLong("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setEmail(rs.getString("email"));
				aluno.setDataCadastro(new java.util.Date(rs.getDate("datacadastro").getTime()));
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aluno;
	}
}