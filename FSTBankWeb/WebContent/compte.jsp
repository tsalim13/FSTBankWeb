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
				<div class="box-header well">
					<h2>
						<i class="glyphicon glyphicon-star-empty"></i> Ajouter un compte
						banquaire
					</h2>
				</div>

				<div class="box-content">
					<div class="row">
						<div class="box col-md-8">
							<div class="row">
								<div class="box-inner">
									<div class="box-header well">
										<h2>
											<i class="glyphicon glyphicon-th"></i> Compte particulier
										</h2>
									</div>
									<div class="box-content">
										<div class="row">
											<div class="box col-md-6">
												<div class="box-inner">
													<div class="box-header well">
														<h2>
															<i class="glyphicon glyphicon-th"></i> Compte particulier
															Partagée
														</h2>
													</div>
													<div class="box-content">
														<form action="CompteControlleur" method="post">
															<div class="form-group">
																<label for="exampleInputEmail1">Client a partage
																	le Compte avec eux</label>
																<div class="controls">
																	<c:choose>
																		<c:when test="${cl!= null}">
																			<input type="text" class="form-control"
																				value="${cl.mail}" disabled>
																		</c:when>
																		<c:otherwise>
																			<select name="client0" class="form-control">
																				<option>choisir un client</option>
																				<c:forEach items="${clients}" var="client">
																					<option>${client.mail}</option>
																				</c:forEach>
																			</select>
																		</c:otherwise>
																	</c:choose>
																</div>
																</br>
																<div class="controls">
																	<select name="client1" class="form-control">
																		<option>choisir un client</option>
																		<c:forEach items="${clients}" var="client">
																			<option>${client.mail}</option>
																		</c:forEach>
																	</select>
																</div>
																</br>
																<div class="controls">
																	<select name="client2" class="form-control">
																		<option>choisir un client</option>
																		<c:forEach items="${clients}" var="client">
																			<option>${client.mail}</option>
																		</c:forEach>
																	</select>
																</div>
																</br>
																<div class="controls">
																	<select name="client3" class="form-control">

																		<option>choisir un client</option>
																		<c:forEach items="${clients}" var="client">
																			<option>${client.mail}</option>
																		</c:forEach>
																	</select>
																</div>
																</br>
																<div class="controls">
																	<select name="client4" class="form-control">
																		<option>choisir un client</option>
																		<c:forEach items="${clients}" var="client">
																			<option>${client.mail}</option>
																		</c:forEach>
																	</select>
																</div>
																</br>
																<div class="controls">
																	<select name="client5" class="form-control">
																		<option>choisir un client</option>
																		<c:forEach items="${clients}" var="client">
																			<option>${client.mail}</option>
																		</c:forEach>
																	</select>
																</div>
																</br>
																<div class="controls">
																	<select name="client6" class="form-control">
																		<option>choisir un client</option>
																		<c:forEach items="${clients}" var="client">
																			<option>${client.mail}</option>
																		</c:forEach>
																	</select>
																</div>
																</br>
																<div class="controls">
																	<select name="client7" class="form-control">
																		<option>choisir un client</option>
																		<c:forEach items="${clients}" var="client">
																			<option>${client.mail}</option>
																		</c:forEach>
																	</select>
																</div>
																</br>
																<div class="controls">
																	<select name="client8" class="form-control">
																		<option>choisir un client</option>
																		<c:forEach items="${clients}" var="client">
																			<option>${client.mail}</option>
																		</c:forEach>
																	</select>
																</div>
																</br>
																<div class="controls">
																	<select name="client9" class="form-control">
																		<option>choisir un client</option>
																		<c:forEach items="${clients}" var="client">
																			<option>${client.mail}</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															<input type="reset" class="btn btn-secondary btn-sm"
																value="Annuler">
															<button class="btn btn-primary btn-sm">Confirmer</button>
														</form>
													</div>
												</div>
											</div>
											<div class="box col-md-6">
												<div class="box-inner">
													<div class="box-header well">
														<h2>
															<i class="glyphicon glyphicon-th"></i> Compte particulier
															privée
														</h2>
													</div>
													<div class="box-content">
														<form action="CompteControlleur" method="post">
															<c:choose>
																<c:when test="${cl!= null}">
																	<div class="form-group">
																		<label for="exampleInputEmail1">Client</label> <input
																			type="text" class="form-control" value="${cl.mail}"
																			disabled>
																	</div>
																</c:when>
																<c:otherwise>
																	<div class="form-group">
																		<label for="exampleInputEmail1">Client</label> <select
																			name="client0" class="form-control">
																			<option>choisir un client</option>
																			<c:forEach items="${clients}" var="client">
																				<option>${client.mail}</option>
																			</c:forEach>
																		</select>
																	</div>
																</c:otherwise>
															</c:choose>
															<input type="reset" class="btn btn-secondary btn-sm"
																value="Annuler">
															<button class="btn btn-primary btn-sm">Confirmer</button>
														</form>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="box col-md-4">
							<div class="box-inner">
								<div class="box-header well">
									<h2>
										<i class="glyphicon glyphicon-th"></i> Compte professionnel
									</h2>
								</div>
								<div class="box-content">
									<form action="CompteControlleur" method="post">
										<c:choose>
											<c:when test="${cl!= null}">
												<div class="form-group">
													<label for="exampleInputEmail1">Client</label> <input
														type="text" class="form-control" value="${cl.mail}"
														disabled>
												</div>
											</c:when>
											<c:otherwise>
												<div class="form-group">
													<label for="exampleInputEmail1">Client</label> <select
														name="client0" class="form-control">
														<option>choisir un client</option>
														<c:forEach items="${clients}" var="client">
															<option>${client.mail}</option>
														</c:forEach>
													</select>
												</div>
											</c:otherwise>
										</c:choose>
										<div class="form-group">
											<label for="exampleInputEmail1">Nom de l'entreprise</label> <input
												type="text" class="form-control" name="nom"
												placeholder="Nom de l'entreprise" required>
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Adresse</label> <input
												type="text" class="form-control" name="mail"
												placeholder="Adresse" required>
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Numero de Tél</label> <input
												type="number" class="form-control" name="number"
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
			</div>
		</div>
	</div>
</div>
<!--/#content.col-md-0-->


<jsp:include page="footer.jsp"></jsp:include>