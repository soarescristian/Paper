<!DOCTYPE html>
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

<title>Cadastro de Aluno</title>
</head>
<body>
	<div align="center">
		<form method="post" action="AlunoServlet">
			<fieldset>
				<legend>Cadastro de Alunos</legend>
				<label>Matr�cula: </label><input name="matricula" required
				    value="${aluno.matricula}"
					placeholder="2236541" /><br /> 
				<label>Name:</label><input
					name="nome" autofocus="autofocus" placeholder="Nome"  value="${aluno.nome}"/><br />
					
				 <label>Telefone:</label><input
					type="tel" name="telefone" placeholder="9999-9999" value="${aluno.telefone}" /><br />
				 <label>Email:</label><input
					type="email" name="email" placeholder="andre@feltex.com.br"  value="${aluno.email}"/><br />	
				<label>Data Cadastro:</label><input type="date" name="dataCadastro" value="${aluno.dataCadastro}"
					placeholder="10/10/2014" /><br /> <label>A��o</label> <select
					name="acao" required>
					<option selected value="Incluir">Incluir</option>
					<option value="Alterar">Alterar</option>
					<option value="Excluir">Excluir</option>
					<option value="Consultar">Consultar</option>
				</select><br /> <input type="submit" value="Enviar"> <input
					type="reset" value="Limpar"> <br />
			</fieldset>
		</form>
	</div>
</body>
</html>