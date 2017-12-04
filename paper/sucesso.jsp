<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml"
        xmlns:h="http://java.sun.com/jsf/html"
        xmlns:b="http://bootsfaces.net/ui" lang="pt">
<head>
<title>P�gina de Sucesso</title>
</head>
<body>
<H1>Mensagem JSTL:	<c:out value="${mensagem}" /></H1>	
<jsp:include page="alunoLista.jsp"/>	
</body>
</html>