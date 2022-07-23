<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href=css/sale.css>
<link rel="stylesheet" href=css/salesProfile.css>
<link rel="stylesheet" href=css/retailSale.css>
<link rel="stylesheet" href="css/homePageStyle.css">
<link rel="stylesheet" href="css/profile.css">
<link rel="stylesheet" href="css/register.css">
<link rel="stylesheet" href="css/connexion.css">
<link rel="stylesheet" href="css/header.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<meta charset="UTF-8">
 <style>
	 input {
	 margin-bottom: 3px;
	 }
</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"></script>
<title>Eni Enchères</title>
</head>


<body>

    <header>

      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-light bg-light backgroundNavbar">
        <div class="container-fluid">
          <a class="navbar-brand" href="homePage">
          	<img class="logo" alt="logo eni enchere" src="img/logo.png">
          </a>
          
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="true" aria-label="Toggle navigation">
           	<span class="navbar-toggler-icon"></span>
          </button>
          
          <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            </ul>
            
            <c:if test="${ !sessionScope.connecte }">     
	            <span class="navbar-text">
	              <a class="nav-link" href="connexion">Connexion</a>
	            </span>
	             <span class="navbar-text">
	              <a class="nav-link" href="register">Inscription</a>
	            </span>
	        </c:if>
	        
			<c:if test="${ sessionScope.connecte }">
	            <span class="navbar-text">
	              <a class="nav-link" href="homePage">Enchères</a>
	            </span>
	             <span class="navbar-text">
	              <a class="nav-link" href="sale">Vendre un article</a>
	            </span>
	            <span class="navbar-text">
	              <a class="nav-link" href="profile">Mon profil</a>
	            </span>
	             <span class="navbar-text">
	              <a class="nav-link" href="disconnect">Déconnexion</a>
	            </span>
	        </c:if>
          </div>
        </div>
      </nav>

    </header>
    
    