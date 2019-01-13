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
						<i class="glyphicon glyphicon-star-empty"></i> Relever de Compte
					</h2>
				</div>
				<div class="box-content">
					<!-- put your content here -->

					<c:if test="${trouve== true}">
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
								<e:forEach items="${liste}" var="liste">
									<tr>
										<th scope="row">${liste.getId()}</th>
										<td>${liste.getDateTransaction()}</td>
										<td>${liste.getId_sender()}</td>
										<td>${liste.getId_receiver()}</td>
										<td>${liste.getTrasanction_solde()}</td>
									</tr>
								</e:forEach>
							</tbody>
						</table>
						<a href="javascript:window.print()"><button class="btn btn-info btn-sm">Imprimer le relever de Compte</button></a>


					</c:if>

					<c:if test="${trouve== false}">
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