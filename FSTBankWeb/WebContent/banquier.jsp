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
						<i class="glyphicon glyphicon-star-empty"></i>Liste des banquiers
					</h2>
				</div>
				<div class="box-content">
					<!-- put your content here -->
					<div class="box-content">
						<div class="alert alert-info">
							For help with such table please check <a
								href="http://datatables.net/" target="_blank">http://datatables.net/</a>
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
							<c:forEach items="${banquiers}" var="banquier">
								<tr>
									<td>${banquier.id}</td>
									<td class="center">${banquier.nom}</td>
									<td class="center">${banquier.prenom}</td>
									<td class="center">${banquier.mail}<span
										class="label-success label label-default">Active</span></td>
									<td class="center"><a class="btn btn-success" href="#">
											<i class="glyphicon glyphicon-zoom-in icon-white"></i> View
									</a> <a class="btn btn-info" href="#"> <i
											class="glyphicon glyphicon-edit icon-white"></i> Modifier
									</a> <a class="btn btn-danger" href="#"> <i
											class="glyphicon glyphicon-trash icon-white"></i> Supprimer
									</a></td>
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