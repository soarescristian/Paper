package br.com.feltex.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpServer;

import br.com.feltex.dao.AlunoDAO;
import br.com.feltex.entidade.Aluno;

@WebServlet("/AlunoServlet")
public class AlunoServlet<HttpServletRequest> extends HttpServer {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String destino = "sucesso.jsp";
		String mensagem = "";
		List<Aluno> lista = new ArrayList<>();

		
		Aluno aluno = new Aluno();
		AlunoDAO dao = new AlunoDAO();
		
		try {

			//Se a ação for DIFERENTE de Listar são lidos os dados da tela
			if (!acao.equalsIgnoreCase("Listar")) {
				aluno.setMatricula(Long.parseLong(request.getParameter("matricula")));
				aluno.setNome(request.getParameter("nome"));
				aluno.setTelefone(request.getParameter("telefone"));
				aluno.setEmail(request.getParameter("email"));
				
				//Faz a leitura da data de cadastro. Caso ocorra um erro de formatação
				// o sistema utilizará a data atual
				try {
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");					
					aluno.setDataCadastro(df.parse(request.getParameter("dataCadastro")));
				} catch (Exception e) {
					aluno.setDataCadastro(new Date());	
				}
				
			}

			if (acao.equalsIgnoreCase("Incluir")) {
				// Verifica se a matrícula informada já existe no Banco de Dados
				// Se existir enviar uma mensagem senão faz a inclusão
				if (dao.existe(aluno)) {
					mensagem = "Matrícula informada já existe!";
				} else {
					dao.inserir(aluno);
				}
			} else if (acao.equalsIgnoreCase("Alterar")) {
				dao.alterar(aluno);
			} else if (acao.equalsIgnoreCase("Excluir")) {
				dao.excluir(aluno);
			} else if (acao.equalsIgnoreCase("Consultar")) {
				request.setAttribute("aluno", aluno);
				aluno = dao.consultar(aluno);
				destino = "aluno.jsp";
			}
		} catch (Exception e) {
			mensagem += e.getMessage();
			destino = "erro.jsp";
			e.printStackTrace();
		}
		
		// Se a mensagem estiver vazia significa que houve sucesso!
		// Senão será exibida a tela de erro do sistema.
		if (mensagem.length() == 0) {
			mensagem = "Aluno Cadastrado com sucesso!";
		} else {
			destino = "erro.jsp";
		}

		// Lista todos os registros existente no Banco de Dados
		lista = dao.listar();
		request.setAttribute("listaAluno", lista);
		request.setAttribute("mensagem", mensagem);
		

		//O sistema é direcionado para a página 
		//sucesso.jsp Se tudo ocorreu bem
		//erro.jsp se houver algum problema.
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
}