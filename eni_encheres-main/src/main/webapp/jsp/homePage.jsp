<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="header.jsp"%>
	<main>
	<section class="sectionHomePageBakground">
		<h1 class="TitleBid text-center">Liste des enchères</h1>
		<div class="container">
			<form class="formHomePage mb-5" action="homePage" method="post"
				name="bidForm">
				<div class="row">
					<div class="col">
						<div class="homePageCategory col-sm-12 mb-3">
							<label class="labelFilterHomePage mb-2" for="myFilter">Filtres&nbsp:</label>
							<input type="text" id="myFilter" class="form-control" onkeyup="searchBar()" placeholder="Le nom de l'article contient...">
						</div>
						<div class="homePageCategory col-sm-12 mb-3">
							<label class="labelCategory mb-2" for="selectCategory">Catégories&nbsp:</label>
							<select class="form-select" id="selectCategory" name="category" aria-label="Default select example">
								<option value="0">Toutes</option>
								<c:forEach items="${ lstCategories }" var="categorie">
									<c:if test="">
										<option value="${ categorie.idCategorie }">${ categorie.label }</option>
									</c:if>
									<option value="${ categorie.idCategorie }">${ categorie.label }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col buttonHomePage gy-5">
						<div class="content">
							<button id="searchButtonForm" type="submit"
								class="btn btn-lg btnSearch">Rechercher</button>
						</div>
						<br>
					</div>
				</div>
				<c:if test="${ sessionScope.connecte }">
					<div class="row">
						<div class="col">
							<div class="row">
								<div class="col checkAchatHomePage">
									<label>Achats</label>
									<c:if test="${ radioPurchases != true }">
										<input class="uncheckSells" type="radio" name="userChoice"
											checked="checked" value="purchases" />
									</c:if>
									<c:if test="${ radioPurchases == true }">
										<input class="uncheckSells" type="radio" name="userChoice"
											value="purchases" />
									</c:if>
									<!-- <div style="display: block" name="otherPurchases" id="otherPurchases" >
										<input type="checkbox" id="openBid" name="openBid" value="openBid"> 
										<label> enchères ouvertes</label> 
										<br>
										<input type="checkbox" id="myBid" name="myBid" value="myBid">
										<label> Mes enchères</label> 
										<br> 
										<input type="checkbox" id="wonBid" name="wonBid" value="wonBid"> 
										<label> Mes enchères remport�es</label>
									</div> -->
								</div>
							</div>
						</div>
						<div class="col checkPurshasesHomePage">
							<label> Mes ventes </label>
							<c:if test="${ radioPurchases == true }">
								<input class="uncheckPurchases" type="radio" name="userChoice"
									checked="checked" value="sells" />
							</c:if>
							<c:if test="${ radioPurchases != true }">
								<input class="uncheckPurchases" type="radio" name="userChoice"
									value="sells" />
							</c:if>
							<!-- <div style="display: none" name="otherSells" id="otherSells">
								<ul>
									<li>
										<input type="checkbox" id="salesInProgress" name="salesInProgress" value="salesInProgress"> 
										<label>Mes ventes en cours</label>
									</li>
									<li>
										<input type="checkbox" id="salesNotBegin" name="salesNotBegin" value="salesNotBegin"> 
										<label> Ventes non distribu�es</label>
									</li>
									<li>
										<input type="checkbox" id="completeSales" name="completeSales" value="completeSales"> 
										<label>Ventes termin�es</label>
									</li>
								</ul>
							</div> -->
						</div>
					</div>
				</c:if>
			</form>
		</div>
		<div class="container">
			<div class="col-6-sm-4 mb-3">
				<div class="row g-0" id="myItems">
					<p class="form-check">
						<span class="erreur">${ erreur}</span>
					</p>
					<c:if test="${ !sessionScope.connecte }">
						<c:forEach items="${ lstArticlesToShowDisconnect }" var="article">
							<div class="card ms-3 mb-3 mt-2">
								<div class="card-body card-style">
									<div class="row">
										<div class="col">
											<a href="connexion"> <img alt="Mercedes"
												src="img/mercedes.png" style="width: 108px;">
											</a>
										</div>
										<div class="col">
											<h5 class="card-title">${ article.nom }</h5>
											<p class="card-text">Prix : ${ article.startPrice }</p>
											<p class="card-text">Fin de l'enchère : ${ article.dtBidEnd }</p>
											<c:if test="${ !sessionScope.connecte }">
												<p class="card-text">Vendeur :${ article.vendeur.name }
													${ article.vendeur.firstName }</p>
											</c:if>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${ sessionScope.connecte }">
						<c:forEach items="${ lstArticlesToShow }" var="article">
							<div class="card ms-3 mb-3 mt-2">
								<div class="card-body card-style">
									<div class="row">
										<c:if test="${article.vendeur.id == sessionScope.user.id }">
											<form action="sale" method="post">
												<div class="col">
													<button class="btnArticle" type="submit" name="mySale"
														value="hidden">
														<img alt="Mercedes" src="img/mercedes.png"
															style="width: 108px;">
													</button>
												</div>
												<div class="col">
													<input type="hidden" value="${ article.idArticle }"
														name="idMyArticle">
													<h5 class="card-title">${ article.nom }</h5>
													<p class="card-text">Prix : ${ article.startPrice }</p>
													<p class="card-text">Fin de l'enchère : ${ article.dtBidEnd }</p>
												</div>
											</form>
											<form action="salesProfile" method="POST">
												<c:if test="${ sessionScope.connecte }">
													<p class="card-text">
														<input type="hidden" value="${ article.vendeur.id }"
															name="idUser"> <input type="hidden"
															value="${ article.vendeur.username }" name="usernameUser">
														<input type="hidden" value="${ article.vendeur.name }"
															name="nameUser"> <input type="hidden"
															value="${ article.vendeur.firstName }"
															name="firstNameUser"> <input type="hidden"
															value="${ article.vendeur.email }" name="emailUser">
														<input type="hidden"
															value="${ article.vendeur.phoneNumber }"
															name="phoneNumberUser"> <input type="hidden"
															value="${ article.vendeur.street }" name="streetUser">
														<input type="hidden" value="${ article.vendeur.city }"
															name="cityUser">
														<button type="submit" value="hidden">Vendeur :${ article.vendeur.name }
															${ article.vendeur.firstName }</button>
													</p>
												</c:if>
											</form>
										</c:if>
										<c:if test="${ article.vendeur.id != sessionScope.user.id}">
											<form action="retailSale" method="post">
												<div class="col">
													<button class="btnArticle" type="submit" value="hidden">
														<img alt="Mercedes" src="img/mercedes.png"
															style="width: 108px;">
													</button>
												</div>
												<div class="col">
													<input type="hidden" value="${ article.idArticle }"
														name="idArticle">
													<h5 class="card-title">${ article.nom }</h5>
													<p class="card-text">Prix : ${ article.startPrice }</p>
													<p class="card-text">Fin de l'enchère : ${ article.dtBidEnd }</p>
												</div>
											</form>
											<form action="salesProfile" method="POST">
												<c:if test="${ sessionScope.connecte }">
													<p class="card-text">
														<input type="hidden" value="${ article.vendeur.id }"
															name="idUser"> <input type="hidden"
															value="${ article.vendeur.username }" name="usernameUser">
														<input type="hidden" value="${ article.vendeur.name }"
															name="nameUser"> <input type="hidden"
															value="${ article.vendeur.firstName }"
															name="firstNameUser"> <input type="hidden"
															value="${ article.vendeur.email }" name="emailUser">
														<input type="hidden"
															value="${ article.vendeur.phoneNumber }"
															name="phoneNumberUser"> <input type="hidden"
															value="${ article.vendeur.street }" name="streetUser">
														<input type="hidden" value="${ article.vendeur.city }"
															name="cityUser">
														<button type="submit" value="hidden">Vendeur :${ article.vendeur.name }
															${ article.vendeur.firstName }</button>
													</p>
												</c:if>
											</form>
										</c:if>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	</main>
</body>

<script src="js/homePageScript.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous">
	
</script>
</html>