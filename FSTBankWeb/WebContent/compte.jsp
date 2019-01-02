<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
						<i class="glyphicon glyphicon-star-empty"></i> Ajouter un compte
						banquaire
					</h2>
				</div>

				<div class="box-content">
					<div class="row">
						<div class="box col-md-6">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th"></i> Compte professionnel
									</h2>
								</div>
								<div class="box-content">
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

								</div>
							</div>
						</div>
						<div class="row">
							<div class="box col-md-6">
								<div class="box-inner">
									<div class="box-header well" data-original-title="">
										<h2>
											<i class="glyphicon glyphicon-th"></i> Compte particulier
										</h2>
									</div>
									<div class="box-content">

										<div class="box col-md-6">
											<div class="box-inner">
												<div class="box-header well" data-original-title="">
													<h2>
														<i class="glyphicon glyphicon-th"></i> Compte particulier
													</h2>
												</div>
												<div class="box-content">
													sjlkdjsqlkjd
												</div>

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