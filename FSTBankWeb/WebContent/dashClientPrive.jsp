<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
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
						<i class="glyphicon glyphicon-star-empty"></i>Compte client
					</h2>
				</div>
				<div class="box-content">
					<!-- put your content here -->
					<div class="box-content">
						<e:if test="${cptValide== false}">
							<div class="alert alert-danger">ERREUR : Comple n'existe
								pas...</div>
						</e:if>

						<e:if test="${soldeInsuffisant == 2}">
							<div class="alert alert-danger">ERREUR : Solde Insuffisant.
								. .</div>
						</e:if>
						<e:if test="${soldeInsuffisant == 1}">
							<div class="alert alert-success">success . . .</div>
						</e:if>

						<c:choose>
							<c:when test="${trouve == true}">
								<div class="alert alert-info" align="center">
									<!-- Button trigger modal -->
									<div style="width: 30%; float: left;">
										<button type="button" class="btn btn-info btn-lg"
											data-toggle="modal" data-target="#exampleModal">Faire
											un virement</button>
									</div>
									<button type="button" class="btn btn-info btn-lg"
										data-toggle="modal" data-target="#exampleModal2">faire
										un retrait</button>

									<div style="width: 30%; float: right;">
										<button type="button" class="btn btn-info btn-lg"
											data-toggle="modal" data-target="#exampleModal">
											Relever de comptes</button>
									</div>
								</div>
								<d:forEach items="${liste}" var="liste">
									<div class="alert alert-success">${liste.getCodeIBN()}</div>
									<div
										style="font-size: 120px; letter-spacing: 4px; text-align: center;">
										${liste.getSolde()} DZ</div>
								</d:forEach>
							</c:when>
							<c:otherwise>
								<div
									style="font-size: 120px; letter-spacing: 4px; text-align: center;"
									class="alert alert-danger">vous n'aver pas un compte pariculier privé</div>
							</c:otherwise>
						</c:choose>

						<!-- Modal -->
						<div class="modal fade" id="exampleModal" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h3 class="modal-title" id="exampleModalLabel">Faire un
											virement</h3>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<form action="DashClientPrive" method="post">

										<div class="modal-body">
											<div class="form-group">
												<label for="exampleInputEmail1">Choisir le compte</label> <select
													name="iban" class="form-control">
													<c:if test="${trouve== true}">
														<d:forEach items="${liste}" var="liste">
															<option>${liste.getCodeIBN()}</option>
														</d:forEach>
													</c:if>
												</select>
											</div>
											<div class="form-group">
												<label for="exampleInputEmail1">IBAN code</label> <input
													type="text" class="form-control" name="iban2"
													placeholder="Entrer IBAN code" required>
											</div>

											<div class="form-group">
												<label for="exampleInputEmail1">Solde a verser</label> <input
													type="number" class="form-control" name="solde"
													placeholder="Solde a verser" required>
											</div>
											<input type="hidden" name="form1">
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
						<!-- Modal2 -->
						<div class="modal fade" id="exampleModal2" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h3 class="modal-title" id="exampleModalLabel">faire un
											retrait</h3>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<form action="DashClientPrive" method="post">


										<div class="modal-body">
											<div class="form-group">
												<label for="exampleInputEmail1">Choisir le compte</label> <select
													name="iban" class="form-control">
													<c:if test="${trouve== true}">
														<d:forEach items="${liste}" var="liste">
															<option>${liste.getCodeIBN()}</option>
														</d:forEach>
													</c:if>
												</select>
											</div>
											<div class="form-group">
												<label for="exampleInputEmail1">Solde a retrait</label> <input
													type="number" class="form-control" name="soldee"
													placeholder="Solde a retrait" required>
											</div>
											<input type="hidden" name="form2">
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
						<!-- Modal -->
						<div class="modal fade" id="exampleModal2" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h3 class="modal-title" id="exampleModalLabel">Détail du
											client</h3>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>


									<div class="modal-body"></div>

									<div class="modal-footer">
										<button type="button" class="btn btn-secondary btn-sm"
											data-dismiss="modal">Quiter</button>
										<input type="reset" class="btn btn-secondary btn-sm"
											value="Videz les champs">
										<button class="btn btn-primary btn-sm">Confirmer</button>
									</div>


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