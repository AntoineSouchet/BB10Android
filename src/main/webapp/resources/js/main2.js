$(function() {
	
	
	
	//dev
	//var redirection = "android";
	
	//prod
	var redirection = "BB10AndroidV2";
	
	
	
	$('.arrow, [class^=arrow-]').bootstrapArrows();
	
	
	$(document).on("click", ".Login", function() {
		TopBar();
		var login = $("#login").val();
		var pass = $("#pass").val();
		$("#LogResult").html("");
		$.post('/' + redirection + '/Login.sd?log=' + login + '&pass=' + pass, function(data) {
			if (data != "ok") {
			$("#LogResult").html(data); }
			else {
			$('#myModal').modal('hide');
			TopBar();
			}
		});
	});
	
	function TopBar()
	{
		$.post('/' + redirection + '/MyTopBar.bb', function(data) {
			$("#TopBar").html(data);
			return data;
		});
	}
	
	$(document).on("click", ".NewApp", function() {
		TopBar();
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
		return false;
		}
	if (Description == "")
		{
		$("#Incomp").show();
		return false;
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
			$.post('/' + redirection + '/RefreshApp.sd', function(data){
				$("#ListeApplication").html(data);
			});
			}
	});
	});
	
});