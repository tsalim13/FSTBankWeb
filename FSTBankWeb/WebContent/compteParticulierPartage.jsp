<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"></jsp:include>

<div id="content" class="col-lg-10 col-sm-10">
	<!-- content starts -->


	<div>
		<ul class="breadcrumb">
			<li><a href="#">Home</a></li>
			<li><a href="#">Blank</a></li>
		</ul>
	</div>

	<div class="row">
		<div class="box col-md-12">
			<div class="box-inner">
				<div class="box-header well" data-original-title="">
					<h2>
						<i class="glyphicon glyphicon-star-empty"></i>Liste des comptes
						particulier partage
					</h2>
				</div>
				<div class="box-content">
					<!-- put your content here -->
					<div class="box-content">
						<div class="alert alert-info">

							<form action="AddCompteControlleur" methode="get">
								<input type="hidden" name="form" value="1">
								<button class="btn btn-primary">Ajouter un compte particulier partage</button>
							</form>

						</div>
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<th>id</th>
									<th>code IBAN</th>
									<th>solde</th>
									<th>client</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="list">
									<tr>
										<form action="AddCompteControlleur" method="get">
											<td>${list.id}</td>
											<td class="center">${list.codeIBN}</td>
											<td class="center">${list.solde}</td>
											<td class="center"></td>
											<td class="center"><input type="hidden" name="form" value="1">
												<button class="btn btn-primary">Ajouter un compte</button>
										</form>

										<a class="btn btn-danger" href="#"
											title="Attention tout information seront supprimées."
											data-toggle="tooltip"> <i
											class="glyphicon glyphicon-trash icon-white"></i> Supprimer
										</a>
										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!--/row-->

		<!-- content ends -->
	</div>
	<!--/#content.col-md-0-->


	<jsp:include page="footer.jsp"></jsp:include>