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
						



					
					
					
					<c:if test="${trouveR== true}">
					<h3>Transaction entrante</h3>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Date de transaction</th>
									<th scope="col">IBAN sender</th>
									<th scope="col">IBAN receiver</th>
									<th scope="col">Transaction solde</th>
								</tr>
							</thead>
							<tbody>
								<e:forEach items="${listeR}" var="listeR">
									<tr>
										<th scope="row">${listeR.getId()}</th>
										<td>${listeR.getDateTransaction()}</td>
										<td>${listeR.getId_sender()}</td>
										<td>${listeR.getId_receiver()}</td>
										<td>${listeR.getTrasanction_solde()}</td>
									</tr>
								</e:forEach>
							</tbody>
						</table>
						


					</c:if>
					
					<c:if test="${trouve== true || trouveR== true}">
						<a href="javascript:window.print()"><button class="btn btn-info btn-sm">Imprimer le relever de Compte</button></a>
					</c:if>
					
					<c:if test="${trouve== false && trouveR== false}">
						<div
							style="font-size: 40px; letter-spacing: 4px; text-align: center;"
							class="alert alert-danger">Pas de transaction ,aucune
							action n'a été trouvée</div>

					</c:if>







				</div>
			</div>
		</div>
	</div>
	<!--/row-->


	<!-- content ends -->
</div>
<!--/#content.col-md-0-->


<jsp:include page="footer.jsp"></jsp:include>