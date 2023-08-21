<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<!-- CSS bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="cold-md-7">
				<hr>
				<h3>Atualização de Cliente</h3>
				<hr>
				<form action="ClienteUpdate" method="POST">
					<div class="form-floating mb-3">
						<input value="${cliente.id}" name="id" class="form-control">
						<label>ID</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.nome}" name="nome" maxlength="40" type="text" class="form-control" id="floatingInput1">
						<label>Nome completo</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.cpf}" name="cpf" maxlength="11" type="text" class="form-control">
						<label>CPF (apenas números)</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.nascimento}" name="nascimento" type="date" class="form-control" placeholder="Nascimento">
						<label>Nascimento</label>
					</div>
					<select  name="situacao" class="form-select mb-3" aria-label="Default select example">
						<option value="${cliente.situacao}" selected> ${cliente.situacao} </option>
						<option value="Ativo">Ativo</option>
						<option value="Inativo">Inativo</option>
					</select>

					<button class="btn btn-success" type="submit">Atualizar Cliente</button>
					<button class="btn btn-secondary" type="reset">Limpar Formulário</button>
				</form>
			</div>
		</div>
	</div>
	<!-- java script bootstrap -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>