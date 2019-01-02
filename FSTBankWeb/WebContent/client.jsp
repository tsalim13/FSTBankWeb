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
						<i class="glyphicon glyphicon-star-empty"></i>Liste des clients
					</h2>
				</div>
				<div class="box-content">
					<!-- put your content here -->
					<div class="box-content">
						<div class="alert alert-info">

							<!-- Button trigger modal -->
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#exampleModal">Ajouter un client</button>

							<!-- Modal -->
							<div class="modal fade" id="exampleModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Ajouter
												un client</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<form action="ClientControlleur" method="post">

											<div class="modal-body">
												<div class="form-group">
													<label for="exampleInputEmail1">Nom</label> <input
														type="text" class="form-control" name="nom"
														placeholder="Nom" required>
												</div>
												<div class="form-group">
													<label for="exampleInputEmail1">Prenom</label> <input
														type="text" class="form-control" name="prenom"
														placeholder="Prenom" required>
												</div>
												<div class="form-group">
													<label for="exampleInputEmail1">Email address</label> <input
														type="email" class="form-control" name="mail"
														placeholder="Enter email" required>
												</div>


												<div class="form-group">
													<label for="exampleInputEmail1">Mot de passe</label> <input
														type="password" class="form-control" name="mdp"
														placeholder="Mot de passe" required>
												</div>
											</div>

											<div class="modal-footer">
												<button type="button" class="btn btn-secondary btn-sm"
													data-dismiss="modal">Close</button>

												<button class="btn btn-primary btn-sm">Save Changes</button>
											</div>
										</form>

									</div>
								</div>
							</div>
						</div>
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<th>Code</th>
									<th>Nom</th>
									<th>Prenom</th>
									<th>Mail</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${clients}" var="client">
									<tr>
									<form action="CompteControlleur" method="post">
										<td>${client.id}</td>
										<td class="center">${client.nom}</td>
										<td class="center">${client.prenom}</td>
										<td class="center">${client.mail}<span
											class="label-success label label-default">Active</span></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="glyphicon glyphicon-zoom-in icon-white"></i> View
										</a> <a class="btn btn-info" href="#"> <i
												class="glyphicon glyphicon-edit icon-white"></i> Modifier
										</a> <a class="btn btn-danger" href="#"
											title="Attention tout information seront supprimées."
											data-toggle="tooltip"> <i
												class="glyphicon glyphicon-trash icon-white"></i> Supprimer
										</a>
												    <input type="hidden" value="${client.id}" name="id">
												<button class="btn btn-primary">Ajouter
													un compte</button>
													
											</form></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!-- Modal -->
						<div class="modal fade" id="exampleModal2" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h3 class="modal-title" id="exampleModalLabel">Ajouter un
											compte</h3>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<form action="ClientControlleur" method="post">

										<div class="modal-body">
											<h4>Choix type de compte banquaire:</h4>
											<div class="select">
												<select name="select" class="form-control">
													<option>veuillez choisix type de compte...</option>
													<option>Compte professionel</option>
													<option>Compte particulier</option>

												</select>

											</div>



										</div>

										<div class="modal-footer">
											<button type="button" class="btn btn-secondary btn-sm"
												data-dismiss="modal">Close</button>

											<button class="btn btn-primary btn-sm">Save Changes</button>
										</div>
									</form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/row-->

		<!-- content ends -->
	</div>
	<!--/#content.col-md-0-->


	<jsp:include page="footer.jsp"></jsp:include>