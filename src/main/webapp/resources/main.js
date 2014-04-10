$(function() {
	
	
	var redirection = "android";
    // Activate carousel
    $("#myCarousel").carousel();
    
    // Enable carousel control
	$(".left").click(function(){
    	$("#myCarousel").carousel('prev');
    });
    $(".right").click(function(){
    	$("#myCarousel").carousel('next');
    });
    
    // Enable carousel indicators
    $(".slide-one").click(function(){
    	$("#myCarousel").carousel(0);
    });
    $(".slide-two").click(function(){
    	$("#myCarousel").carousel(1);
    });
    $(".slide-three").click(function(){
    	$("#myCarousel").carousel(2);
    });
    $(".slide-four").click(function(){
    	$("#myCarousel").carousel(3);
    });

//    AddApp
$(document).on("click", ".AddApp", function () {
		
		$.post('/' + redirection + '/AddApp.sd', function(data) {
			$("#MyBody").html(data);
		});
	});

//PageLog
$(document).on("click", ".PageLog", function () {
	
	$.post('/' + redirection + '/Connexion.sd', function(data) {
		$("#MyBody").html(data);
	});
});

//Tuto
$(document).on("click", ".Tuto", function () {
	
	$.post('/' + redirection + '/Tuto.sd', function(data) {
		$("#MyBody").html(data);
	});
});

//Propos
$(document).on("click", ".Propos", function () {
	
	$.post('/' + redirection + '/Propos.sd', function(data) {
		$("#MyBody").html(data);
	});
});
    
});

