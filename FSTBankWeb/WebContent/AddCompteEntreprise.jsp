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
						<i class="glyphicon glyphicon-star-empty"></i> Ajouter compte professionnel 
					</h2>
				</div>
				<div class="box-content">
					<!-- put your content here -->
					<c:if test="${done == true}">
						<div class="alert alert-success">success . . .</div>
					</c:if>



					<form action="AddCompteControlleur" method="post">
										<input type="hidden" name="fornNum" value="3">
												<div class="form-group">
													<label for="exampleInputEmail1">Client</label>
													<div class="control-group">
														<div class="controls">
															<select name="client0" class="form-control"
																data-rel="chosen">
																<option value="" selected disabled>choisir un
																	client</option>
																<c:forEach items="${clients}" var="client">
																	<option value="${client.id}">${client.mail}</option>
																</c:forEach>
															</select>
														</div>
													</div>
													<br>
												</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Nom de l'entreprise</label> <input
												type="text" class="form-control" name="nom"
												placeholder="Nom de l'entreprise" required>
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Adresse</label> <input
												type="text" class="form-control" name="adresse"
												placeholder="Adresse" required>
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Numero de Téléphone</label> <input
												type="number" class="form-control" name="num"
												placeholder="Numero de Tél" required>
										</div>
										<input type="reset" class="btn btn-secondary btn-sm"
											value="Annuler">
										<button class="btn btn-primary btn-sm">Confirmer</button>
									</form>



				</div>
			</div>
		</div>
	</div>
	<!--/row-->


	<!-- content ends -->
</div>
<!--/#content.col-md-0-->


<jsp:include page="footer.jsp"></jsp:include>