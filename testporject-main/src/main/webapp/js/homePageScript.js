function searchBar() {
    var input, filter, cards, cardContainer, h5, title, i;
    input = document.getElementById("myFilter");
    filter = input.value.toUpperCase();
    cardContainer = document.getElementById("myItems");
    cards = cardContainer.getElementsByClassName("card");
    for (i = 0; i < cards.length; i++) {
        title = cards[i].querySelector(".card-body h5.card-title");
        if (title.innerText.toUpperCase().indexOf(filter) > -1) {
            cards[i].style.display = "";
        } else {
            cards[i].style.display = "none";
        }
    }
}

function submitForm()
{
   document.getElementById("searchButtonForm").submit();
}
window.onload=submitForm;

/*$(function() {
    $('#searchButtonForm').click();
});*/

/*$(function autoClick() {
    var that = this;
    
    document.getElementById("watchButton").addEventListener("click", function () {
        $(this).fadeOut().fadeIn().fadeOut().fadeIn();
        that._handleWatch.apply(that, arguments);
    }, false);
    
    document.getElementById("refreshButton").addEventListener("click", function () {
        $(this).fadeOut().fadeIn().fadeOut().fadeIn();
        that._handleRefresh.apply(that, arguments);
    }, false);

    $('#watchButton').click();
});*/


$("input[type='radio']").change(function(){
    	   
    	   if($(this).val()=="purchases")
    	   {
    	       $("#otherPurchases").show();
    	   }
    	   else
    	   {
	          $("#otherPurchases").hide(); 
    	   }
    	       
    	   });

$("input[type='radio']").change(function(){
   
   if($(this).val()=="sells")
   {
       $("#otherSells").show();
   }
   else
   {
      $("#otherSells").hide(); 
   }
       
   });

 $(".uncheckPurchases").click(function(){
        $("#openBid").prop("checked", false);
		$("#myBid").prop("checked", false);
		$("#wonBid").prop("checked", false);
    });

 $(".uncheckSells").click(function(){
        $("#salesInProgress").prop("checked", false);
		$("#salesNotBegin").prop("checked", false);
		$("#completeSales").prop("checked", false);
    });