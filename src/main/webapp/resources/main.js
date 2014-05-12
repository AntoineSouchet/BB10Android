$(function() {
	
	
	//dev
	//var redirection = "android";
	
	//prod
	var redirection = "BB10Android";
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

$(document).on("click", ".Home", function () {
	
	$.post('/' + redirection + '/index.sd', function(data) {
		$("#MyBody").html(data);
	});
});

$(document).on("click", ".AppList", function () {
	$.post('/' + redirection + '/AppList.sd', function(data) {
		$("#MyBody").html(data);
	});
});

$(document).on("click", ".Logout", function() {
	$.post('/' + redirection + '/Lougout.sd', function(data) {
		$("#MyBody").html(data);
	});
});

$(document).on("click", ".btn-zoomApp",function(){
	var idApp = $(this).siblings("input:hidden").val();
	$.post('/' + redirection + '/ZoomApp.sd?idApp=' +idApp,function(data)
	{
		var chaine = data.split("/////");
		$("#Titre").html(chaine[0]);
		$("#infoApp").html(chaine[1]);
	});
});

//Search Application
$(document).on("click", ".Seek",function() {
	var AppName = $("#AppName").val();
	$.post('/' + redirection + '/Seek.sd?AppName=' + AppName,function(data)
			{
		$("#MyBody").html(data);
			});
});

$(document).on("click", ".Login", function() {
	var login = $("#login").val();
	var pass = $("#pass").val();

	$.post('/' + redirection + '/Login.sd?log=' + login + '&pass=' + pass, function(data) {
		$("#MyBody").html(data);
	});
});


function login()
{
	var login = $("#login").val();
	var pass = $("#pass").val();

	$.post('/' + redirection + '/Login.sd?log=' + login + '&pass=' + pass, function(data) {
		$("#MyBody").html(data);
	});
	}


$(document).on("click", ".NewApp", function() {

	$("#CreateNOK").hide();
	$("#CreateOK").hide();
	$("#Incomp").hide();
	var AppName = $("#Name").val();
	var Description = $("#Description").val();
	var Editeur = $("#Editeur").val();
	var Google = $("#Google").val();
	var Type = $("#Type").val();
	var Fonctionne = $("#Fonctionne").val();
	var User = $("#MonId").html();

	if(AppName == "")
		{
		$("#Incomp").show();
		}
	if (Description == "")
		{
		$("#Incomp").show();
		}
	$.post('/' + redirection + '/NewApp.sd?Name=' + AppName + '&Description=' + Description + '&Editeur=' + Editeur + '&Google=' + Google + '&Type=' + Type + '&Fonctionne=' + Fonctionne + '&User=' + User, function(data) {
		if (data == "X")
			{
			$("#CreateNOK").show();
			}
		else if(data == "ok")
			{
			$("#Name").val("");
			$("#Description").val("");
			$("#Editeur").val("");
			$("#Google").val("");
			$("Type").val("");
			$("#Fonctionne").val("");
			$("#CreateOK").show();
			}
	});
});
$(document).on("click", ".CreateMonLog", function() {
	$.post('/' + redirection + '/NewLog.sd', function(data) {
		$("#MyBody").html(data);
	});
});
$(document).on("click", ".CreateLog" ,function() {
	var login = $("#Login").val();
	var pass = $("#password2").val();
	var pass2 = $("#passwordbis").val();
	var sexe = $("#Sexe").val();
	var mail = $("#MonMail").val();
	
	$("#EmptyMail").hide();
	$("#Log").hide();
	$("#MonPassw").hide();
	$("#DoublePass").hide();
	$("#duplicate").hide();
	if (mail == "")
		{
		$("#EmptyMail").show();
		return false;
		}
	if (login == "")
		{
		$("#Log").show();
		return false;
		}
	if(pass == "")
		{
		$("#MonPassw").show();
		return false;
		}
	if(pass != pass2)
		{
		$("#DoublePass").show();
		return false;
		}
	$.post('/' + redirection + '/CreateLog.sd?login='+ login+ '&password=' + pass + '&sexe=' + sexe + '&email=' + mail, function(data) {
		if (data != "X")
			{
			$("#duplicate").show();
			}
		else
			{
			$("#Compte").html("");
			$("#Compte").html("<div class=\"alert alert-success\" name=\"CreateOK\" name=\"CreateOK\">Compte cr&eacute;e avec succ&eacute;s, v&eacute;rifiez votre boite de r&eacute;ception afin de la valider votre addrese.</div>");
			}

	});
});
    
});

