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
						<i class="glyphicon glyphicon-star-empty"></i> Acceuille
					</h2>
				</div>
				<div class="box-content">
					<!-- put your content here -->


					<div class="alert alert-info center">
						<h2>Bienvenue</h2>
					</div>
					<div class="alert alert-success">
						<h3>Nom : ${sessionScope.banquierNom }</h3>
						<h3>Prenom : ${sessionScope.banquierPrenom }</h3>
						<h3>Mail : ${sessionScope.banquierMail }</h3>
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