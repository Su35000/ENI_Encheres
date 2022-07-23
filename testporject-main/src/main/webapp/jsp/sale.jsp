<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<section class="sectionSale">
		<div class="container cardSale">
			<h1 class="titleSale  text-center">Nouvelle vente</h1>
			<div class="col-6-md-8 borderSale">
				<div class="card-body">
					<form class="formSale" action="sale" method="post" enctype="multipart/form-data">
						<input type="hidden" id="idArticle" name="idArticle"
							value="${article.idArticle }">
						<table classe="table table-borderless">

							<tbody class="saleFormBody">
								<tr>
									<td><label for="article"
										class="col-form-label mb-3 labelItemSale">Article&nbsp:
									</label></td>
									<td><input type="text" id="article"
										class="form-control mb-3" name="article"
										value="${article.nom}"></td>
								</tr>
								<tr>
									<td><label for="description" class="col-form-label mb-5">Description&nbsp:</label></td>
									<td><textarea id="description" class="form-control mb-3"
											name="description" rows="5" cols="33">${article.description}</textarea></td>
								</tr>
								<tr>
									<td><label for="Categorie" class=" col-form-label mb-3">Categorie&nbsp:</label></td>
									<td><select class="form-select mb-3" name="categorie"
										aria-label="Default select example">
											<c:if test="${article == null }"></c:if>
											<c:forEach items="${ lstCategories }" var="categorie">
												<option value="${ categorie.idCategorie }">${ categorie.label }</option>
											</c:forEach>
											<option value="${ article.categorie.idCategorie }">${ article.categorie.label }</option>
									</select></td>
								</tr>
								<tr>
									<td><label for="uploadImage" class="col-form-label mb-3">Photo
											de l'article&nbsp:</label></td>
									<td><input type="file" id="uploadImage" accept="image/*"
										multiple onchange="readFilesAndDisplayPreview(this.files);"
										class="form-control mb-3" name="uploadImage" value="UPLOAD"></td>
								</tr>
								<tr>
									<td><label for="Price" class="col-form-label">Mise
											à prix&nbsp: </label></td>
									<td><input type="number" id="Price"
										class="form-control mb-3" name="Price" min="0"
										value="${article.startPrice }"></td>
								</tr>
								<tr>
									<td><label for="dateDebut" class="col-form-label mb-3">Début
											de l'enchère&nbsp: </label></td>
									<td><input type="datetime-local" id="dateDebut"
										class="form-control mb-3" name="dateDebut"
										value="${article.dtBidStart }"></td>
								</tr>
								<tr>
									<td><label for="dateFin" class=" col-form-label mb-5">Fin
											de l'enchère&nbsp: </label>
									<td><input type="datetime-local" id="dateFin"
										class="form-control mb-5" name="dateFin"
										value="${article.dtBidEnd}"></td>
								</tr>

								<c:if test="${article.idArticle != null }">


									<tr class=streetSale>
										<td><label for="rue" class="col-form-label mb-3">Rue&nbsp:
										</label></td>
										<td><input type="text" id="rue" class="form-control mb-3"
											name="rue" value="${withdrawal.rue}"></td>

										<!-- 										<td class="withdrawalSale">Retrait</td> -->
									</tr>

									<!-- 								<tr class="withdrawalSale"> -->

									<!-- 								</tr> -->
									<tr>
										<td><label for="codePostal" class=" col-form-label mb-3">Code
												postal&nbsp:</label></td>
										<td><input type="text" id="codePostal"
											class="form-control mb-3" name="codePostal"
											value="${withdrawal.codePostal}"></td>
									</tr>
									<tr>
										<td><label for="ville" class=" col-form-label mb-3">Ville&nbsp:
										</label></td>
										<td><input type="text" id="ville"
											class="form-control mb-3" name="ville"
											value="${withdrawal.ville}"></td>
									</tr>

								</c:if>
								<c:if test="${article.idArticle == null }">
									<tr class=streetSale>
										<td><label for="rue" class="col-form-label mb-3">Rue&nbsp:
										</label></td>
										<td><input type="text" id="rue" class="form-control mb-3"
											name="rue" value="${user.street}"></td>

										<!-- 										<td class="withdrawalSale">Retrait</td> -->
										<!-- 									</tr> -->

										<!-- 								<tr class="withdrawalSale"> -->

										<!-- 								</tr> -->
									<tr>
										<td><label for="codePostal" class=" col-form-label mb-3">Code
												postal&nbsp:</label></td>
										<td><input type="text" id="codePostal"
											class="form-control mb-3" name="codePostal"
											value="${user.postalCode}"></td>
									</tr>
									<tr>
										<td><label for="ville" class=" col-form-label mb-3">Ville&nbsp:
										</label></td>
										<td><input type="text" id="ville"
											class="form-control mb-3" name="ville" value="${user.city}">
										</td>
									</tr>
								</c:if>

								<tr>
									<c:if test="${user.id == article.vendeur.id}">
										<td class="text-center"><input type="submit"
											class="btnUpdateSale mt-5" name="update" value="Modifier"></td>
									</c:if>
									<c:if test="${user.id != article.vendeur.id}">
										<td class="text-center"><input type="submit"
											class="btnSaveSale mt-5" name="add" value="Enregistrer"></td>
									</c:if>
									<td class="text-center"><input type="submit"
										class="btnReset mt-5" name="cancel" value="Annuler"></td>
									<c:if test="${user.id == article.vendeur.id}">
										<td><input type="submit" class="btnDeleteSale mt-5"
											name="delete" value="Annuler la vente"></td>
									</c:if>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</section>

	<script>
            /* Cette fonction permet d'afficher une vignette pour chaque image sélectionnée */
            function readFilesAndDisplayPreview(files) {
                laissez imageList = document.querySelector('#list');
                imageList.innerHTML = "" ;
                
                for ( let fichier de fichiers ) {
                    let reader = new FileReader();
                    
                    lecteur.addEventListener( "load", function( event ) {
                        laissez span = document.createElement('span');
                        span.innerHTML = ' <img height= "60" src= "' + event.target.result + '" / > '; 
                        imageList.appendChild( span );
                    });

                    lecteur.readAsDataURL (fichier);
                }
            }
        </script>
</head>
<body style="text-align: center">

</body>

</html>