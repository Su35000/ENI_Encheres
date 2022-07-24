function afficherMdp() {
	document.getElementById("check").type = "text";
	document.getElementById("oeil").src = "img/logoOeilOuvert.png"
}

function cacherMdp() {
	document.getElementById("check").type = "password";
	document.getElementById("oeil").src = "img/logoOeilFerme.png"
}