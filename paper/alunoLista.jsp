<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml"
        xmlns:h="http://java.sun.com/jsf/html"
        xmlns:b="http://bootsfaces.net/ui" lang="pt">
<head>

<!-- Última versão CSS compilada e minificada -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Tema opcional -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Última versão JavaScript compilada e minificada -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Alunos</title>
</head>
<body>
	<div align="center">
		<P>Lista de Alunos</P>
		<table border="1">
			<tr>
				<td>Matricula</td>
				<td>Nome</td>
				<td>Telefone</td>
				<td>Data Cadastro</td>
				<td>Comandos</td>
			</tr>
			<c:forEach var="aluno" items="${listaAluno}">
				<tr>
					<td>${aluno.matricula}</td>
					<td>${aluno.nome}</td>
					<td>${aluno.telefone}</td>
					<td><fmt:formatDate value="${aluno.dataCadastro}" type="both" pattern="dd/MM/yyyy"/>  
					<td><a href="AlunoServlet?acao=Excluir&matricula=${aluno.matricula}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${fn:length(listaAluno) > 0}">
   		Existem ${fn:length(listaAluno)} alunos!
 		</c:if><br> 		
	</div>
	<a href="menu.jsp">Voltar</a>
	
</body>
</html>