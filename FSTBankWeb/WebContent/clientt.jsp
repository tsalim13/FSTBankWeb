<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="e"%>

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
						<i class="glyphicon glyphicon-star-empty"></i> list Clients
					</h2>
				</div>
				<div class="box-content">
					<!-- put your content here -->


					<h3>Liste des Client</h3>

					<button type="button" class="btn btn-info btn-lg"
						data-toggle="modal" data-target="#exampleModal2">Ajouter
						un Client</button>

					<table class="table">
						<thead>
							<tr>
								<th>Code</th>
								<th>Nom</th>
								<th>Prenom</th>
								<th>Mail</th>
							</tr>
						</thead>
						<tbody>
							<e:forEach items="${liste}" var="liste">
								<tr>

									<td>${liste.id}</td>
									<td class="center">${liste.nom}</td>
									<td class="center">${liste.prenom}</td>
									<td class="center">${liste.mail}</td>
								</tr>
							</e:forEach>
						</tbody>
					</table>



					<!-- Modal2 -->
					<div class="modal fade" id="exampleModal2" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h3 class="modal-title" id="exampleModalLabel">ajouter un client</h3>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<form action="CompteParticulierPartage" method="get">


									<div class="modal-body">
										<div class="form-group">
											<label for="exampleInputEmail1">Choisir le client</label> <select
												name="client" class="form-control">
							
													<c:forEach items="${list}" var="list">
														<option>${list.mail}</option>
													</c:forEach>
												
											</select>
										</div>
										
										<input type="hidden" name="addClient">
									</div>

									<div class="modal-footer">
										<button type="button" class="btn btn-secondary btn-sm"
											data-dismiss="modal">Quiter</button>
										<input type="reset" class="btn btn-secondary btn-sm"
											value="Videz les champs">
										<button class="btn btn-primary btn-sm">Confirmer</button>
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