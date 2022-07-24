<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<main>
	<section class="sectionSaleProfile">
		<h1 class="titleSaleProfile text-center">Détail vente</h1>
		<div class="container saleProfileContainer">		
			<form class="formSaleProfile">
				<div class="row">
					<div class="col-6">
						<table border="1">
							<tbody>						
								<tr>
									<th>Pseudo :</th>
									<td>
										${ usernameUser }
									</td>
								</tr>
								<tr>
									<th>Nom :</th>
									<td>
										${ nameUser }
									</td>
								</tr>
								<tr>
									<th>Prénom :</th>
									<td>
										${ firstNameUser }
									</td>
								</tr>
								<tr>
									<th>Email :</th>
									<td>
										${ emailUser }
									</td>
								</tr>
								<tr>
									<th>Téléphone :</th>
									<td>
										${ phoneNumberUser }
									</td>
								</tr>
								<tr>
									<th>Rue :</th>
									<td>
										${ streetUser }
									</td>
								</tr>
								<tr>
									<th>Ville :</th>
									<td>
										${ cityUser }
									</td>
								</tr>
							</tbody>
						</table>
						
					</div>
				</div>
			</form>
		</div>
	</section>
	</main>
</body>
</html>