<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>


<main>
	<section class="sectionRegister d-flex align-items-center">
		<div class="container">
			<h1 class="titleRegister  text-center">Inscription</h1>
			<form class="formRegister text-center" action="register" method="Post">
				<div class="row formRegisterPadding">
					<div class="formRgisterLeft col-6">
						<div class="inputRegister mb-3 row">
							<label for="pseudo" class="col-lg-4 col-form-label">Pseudo&nbsp:</label> 
							<div class="col-sm-7">
								<input type="text" class="form-control" id="pseudo" name="userName" ><span class="error">${ error.username }</span><span class="error">${ error.existingUsername }</span></div>	
						</div>
						<div class="inputRegister mb-3 row">
							<label for="firstName" class="col-lg-4 col-form-label">Prénom&nbsp:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="firstName" name="firstName">
									
							</div>
						</div>
						<div class="inputRegister mb-3 row">
							<label for="phoneNumber" class="col-lg-4 col-form-label">Phone&nbsp:</label>
							<div class="col-sm-7">
								<input type="tel" class="form-control" id="phoneNumber" name="phoneNumber"><span class="error">${ error.phone }</span>
									
							</div>
						</div>
						<div class="inputRegister mb-3 row">
							<label for="PostalCode" class="col-lg-4 col-form-label">Code
								postal&nbsp:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="PostalCode" name="PostalCode">
							</div>
						</div>
						<div class="inputRegister mb-3 row">
							<label for="password" class="col-lg-4 col-form-label">Mot de passe&nbsp:</label>
							<div class="col-sm-7">
								<input type="password" class="form-control" id="password" name="password">	
							</div>
						</div>
					</div>

					<div class="formRgisterLeft col-6">
						<div class="inputRegister mb-3 row">
							<label for="name" class="col-lg-3 col-form-label">Nom&nbsp:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="name" name="name">
							</div>
						</div>
						<div class="inputRegister mb-3 row">
							<label for="email" class="col-lg-3 col-form-label">Email&nbsp:</label>
							<div class="col-sm-8">
								<input class="form-control" id="email" name="email" ><span class="error">${ error.email }</span><span class="error">${ error.existingEmail }</span>
							</div>
						</div>
						<div class="inputRegister mb-3 row">
							<label for="street" class="col-lg-3 col-form-label">Rue&nbsp:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="street" name="street">
							</div>
						</div>
						<div class="inputRegister mb-3 row">
							<label for="city" class="col-lg-3 col-form-label">Ville&nbsp:</label>
							<div class="col-sm-8">	
								<input type="text" class="form-control" id="city" name="city">
							</div>
						</div>

						<div class="inputRegister mb-3 row">
							<label for="check" class="col-lg-3 col-form-label">Confirmation&nbsp:</label>
							<div class="col-sm-8 checkEyes">
								<input type="password" class="form-control" id="check" name="check"><span class="error">${ error.password }</span>
								<img id="oeil" onmouseup="cacherMdp()" onmousedown="afficherMdp()" class="icon ms-2" src="img/logoOeilFerme.png" alt="logo_oeil" title="logo_oeil"/>
							</div>
						</div>
					</div>
					<span class="error">${ error.emptyField }</span>
				</div>
				<div class=" text-center buttonRegister p-5 d-flex justify-content-center">
					<div class="create">
						<button type="submit" class="btnCreate me-5">Créer</button>
					</div>
				
						<a class="btnCancel" href="homePage">Annuler</a>
				</div>
			</form>
		</div>
	</section>
	</main>
	<script src="js/register.js"></script>

</body>
</html>