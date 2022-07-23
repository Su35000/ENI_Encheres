<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

	<main>
		<section class="sectionRetailSale">
			<c:if test="${ isBidNotFinish }">
				<h1 class="titleRetail text-center">Détail vente</h1>
			</c:if>

			<c:if test="${ !isBidNotFinish }">
				<h1 class="titleRetail  text-center">Pseudo !!! a remporté la
					vente</h1>
			</c:if>
			<div class="container saleRetailContainer">
				<form class="formRetailSale" action="retailSale" method="post">

					<div class="row">
						<div class="col-6">
							<img class="pictureRetailSale" alt="" src="img/mercedes.png">
						</div>

						<div class="col-6 productDescription">
							<div class="card-body">
								<table classe="table table-borderless">

									<tbody class="saleFormBody">
										<tr>
											<td><h2 class="titleRetailName my-3">${ArticleId.getNom() }
												</h2></td>

										</tr>
										<tr>
											<td><label for="description" class="col-form-label mb-5">Description&nbsp:</label><span
												class="textretailSale">${ArticleId.getDescription() }</span></td>

										</tr>
										<tr>
											<td><label for="Categorie" class=" col-form-label mb-3">Categorie&nbsp:</label><span
												class="textretailSale">${ArticleId.categorie.getLabel() }</span></td>

										</tr>

										<tr>
											<td><label for="Price" class="col-form-label">Meilleur
													offre&nbsp: </label><span class="textretailSale">${maxSale}
													pts par ${ArticleId.vendeur.getUsername() }</span></td>
										<tr>
										<tr>
											<td><label for="Price" class="col-form-label">Mise
													à prix&nbsp: </label><span class="textretailSale">${ArticleId.getStartPrice() }
													points</span></td>
										</tr>

										<tr>
											<td><label class=" col-form-label mb-5">Fin de
													l'enchère&nbsp: </label><span class="textretailSale">${ArticleId.getDtBidEnd() }</span class="textretailSale"></td>

										</tr>

										<tr>

											<td><label for="codePostal" class=" col-form-label mb-3">Retrait&nbsp:
											</label><span class="textretailSale">${ArticleId.vendeur.getStreet()}&nbsp
													${ArticleId.vendeur.getPostalCode()}&nbsp
													${ArticleId.vendeur.getCity()}</span></td>
										</tr>
										<tr>
											<td><label for="ville" class=" col-form-label mb-3">Vendeur&nbsp:
											</label><span class="textretailSale">${ArticleId.vendeur.getUsername() }</span></td>

										</tr>
										<c:if test="${ !isBidNotFinish }">
											<button>
												<a href="homePage"> Back </a>
											</button>
										</c:if>
										<c:if test="${ isBidNotFinish }">
											<tr class="PriceRetail">
												<td><label for="Price" class="col-form-label">
														Ma proposition&nbsp: </label></td>
												<td><input type="number" id="Price" name="price">
												</td>
												<input type="hidden" name="idArticle"
													value="${ArticleId.idArticle }" />
												<td><input type="submit" class="btnReset" name="bid"
													value="Enchèrir"></td>
											</tr>
										</c:if>
									</tbody>

								</table>

							</div>

						</div>
					</div>
				</form>
		</section>
	</main>
</body>
</html>