<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- CSS bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<title>Lista de Clientes</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar scroll</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
				aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarScroll">
				<ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="index.html">Home</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="lista.jsp">Lista de Clientes</a>
					</li>
				</ul>
				<form action="CreateAndFind" method="get" class="d-flex" role="search">
					<input name="pesquisa" class="form-control me-2" type="search" placeholder="Digiteo Nome ou CPF" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Buscar</button>
				</form>
			</div>
		</div>
	</nav>
	<br>
	<div class="container">
		<div class="row">
			<div class="cold-md-7">
				<hr>
				<h3>Clientes Cadastrados</h3>
				<hr>
				<table class="table">
					<thead>
						<tr>
							<th>id#</th>
							<th>Nome</th>
							<th>CPF</th>
							<th>Nascimento</th>
							<th>Situação</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clientes}" var="cliente">
							<tr>
								<td>${cliente.id}</td>
								<td>${cliente.nome}</td>
								<td>${cliente.cpf}</td>
								<td>${cliente.nascimento}</td>
								<td>${cliente.situacao}</td>
								<td>
									<a href="ClienteDestroy?clienteId=${cliente.id}">deletar</a> |
									<a href="ClienteUpdate?clienteId=${cliente.id}">atualizar</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="index.html" > <button class="btn btn-primary"> Cadastro </button> </a>
			</div>
		</div>
	</div>
	<!-- java script bootstrap -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>

</html>