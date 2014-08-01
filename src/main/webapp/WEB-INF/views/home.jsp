<!DOCTYPE html>
<html lang="fr">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>BB love Android. Quelles applications Android sont compatbile avec mon Blackberry ?</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/grayscale.css" rel="stylesheet">

	<link href="resources/Form.css" rel="stylesheet">
	<link href="resources/css/bootstrap-arrows.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="resources/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

    <!-- Navigation -->
    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">
                    <i class="fa fa-play-circle"></i>  <span class="light">BB </span> <span class="glyphicon glyphicon-heart"></span> Android
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#about">A Propos</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#applications">Applications</a>
                    </li>
                     <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                     <li id="TopBar" name="TopBar">
                    
                    ${getTopBar}
                    
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Intro Header -->
    <header class="intro">
        <div class="intro-body">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <h1 class="brand-heading">BB </span> <span class="glyphicon glyphicon-heart"></span> Android</h1>
                        <p class="intro-text">Quelles applications sont compatible avec mon BlacbkBerry 10 ?<br></p>
                        <a href="#about" class="btn btn-circle page-scroll">
                            <i class="fa fa-angle-double-down animated"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </header>


  <section id="about" class="container content-section text-center">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <h2>BB </span> <span class="glyphicon glyphicon-heart"></span> Android</h2>
                <p>BB Love Android, comment ça marche ?</p>
                 <p>BB Love Android a été crée dans un but de savoir quelles applications Android sont compatibles avec votre SmartPhone Canadien.</p>
                 <p style="margin-bottom:0px;">#1 Je télécharge et install l'APK sur mon Blackberry</p>
					<span class='arrow-success' data-angle='180'"></span>
                 <p style="margin-bottom:0px;">#2 Je test l'application sur mon téléphone</p>
					<span class='arrow-success' data-angle='180'"></span>
                 <p>#3 Je partage le résultat des mes tests sur le site</p>
					</div>
					
					
<!--                <div class="container" style="margin-top: 100px; margin-bottom: 100px;width:100%;"> -->
<!--     <div class="row"> -->
<!--         <div class="progress" id="progress1" style="width:50%;margin-left:auto;margin-right:auto;"> -->
<!--             <div class="progress-bar" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100" style="width: 33%;"> -->
<!--             </div> -->

<!--             <span class="progress-completed">0%</span> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="row"> -->
<!--         <div class="row step" > -->
<!--             <div id="div1" class="col-md-2 activestep" onclick="javascript: resetActive(event, 33, 'step-1');" style="width:33%;"> -->
<!--                 <span class="fa fa-cloud-download"></span> -->
<!--                 <p>Télécharger l'application</p> -->
<!--             </div> -->
<!--             <div class="col-md-2" onclick="javascript: resetActive(event, 66, 'step-2');" style="width:33%;"> -->
<!--                 <span class="fa fa-pencil"></span> -->
<!--                 <p>Vérification fonctionnement</p> -->
<!--             </div> -->
<!--             <div class="col-md-2" onclick="javascript: resetActive(event, 100, 'step-3');" style="width:33%;"> -->
<!--                 <span class="fa fa-refresh"></span> -->
<!--                 <p>Validation de l'application</p> -->
<!--             </div> -->
<!--         </div> -->
<!--     </div> -->
<!-- 		 <a href="#applications" class="btn btn-circle page-scroll"> -->
<!--                             <i class="fa fa-angle-double-down animated"></i> -->
<!--                         </a> -->
    
<!-- </div> -->
            </div>
        </div>
    </section>


  <section id="applications" class="container content-section text-center" style="width:100%;background-color:#bdc3c7;padding-top: 150px;" >

        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <h2>Liste des applications testées : </h2>
                <div id="ListeApplication" name="ListeApplication">
${ListeApp}
				</div>
            </div>
        </div>
    </section>

<!--     Contact Section -->
    <section id="contact" class="container content-section text-center">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <h2>Contact BBLoveAndroid</h2>
                <p>Pour nous contacter une seule addresse : </p>
                <p><a href="mailto:contact@bbloveandroid.com">contact@bbloveandroid.com</a>
                </p>
                <ul class="list-inline banner-social-buttons">
                    <li>
                        <a href="https://twitter.com/BBLoveAndroid" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Twitter</span></a>
                    </li>
                </ul>
            </div>
        </div>
    </section>

    <!-- Map Section -->
    <div id="map2" style="background-color:black"></div>

    <!-- Footer -->
    <footer>
        <div class="container text-center">
            <p>Copyright &copy; BBLoveAndroid 2014</p>
        </div>
    </footer>

<!-- Login Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <h4 class="modal-title"><div id="Titre">Se connecter</div></h4>
      </div>
      <div class="modal-body">
           <form class="form" id="form1">
      <center>
      <p class="login">
        <input name="login" type="text"  placeholder="login" id="login" style="color:black;" />
      </p>
      <p class="pass">
        <input name="pass" type="password"  id="pass" placeholder="Password" style="color:black;"
          />
      </p>

         <div id="LogResult" name="LogResult" style="color:black;"></div>

		<a href="#CreateMonLog" class="CreateMonLog btn btn-primary">Je n'ai pas de compte</a>
		 <a href="#Login" class="Login btn btn-success" >Connexion</a><br /><br />
		 </center><br />
		 <center>
		 <a href="#MdpLost" class="MdpLost">J'ai perdu mon mot de passe</a>
		 </center>
    </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
      </div>
    </div>
  </div>
</div>



<!-- Add Application Modal -->
<div class="modal fade" id="ModalAddApp" tabindex="-1" role="dialog" aria-labelledby="ModalAddAppLabel" aria-hidden="true" style="color:black;">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <h4 class="modal-title"><div id="Titre">Ajouter une application</div></h4>
      </div>
      <div class="modal-body">
        	<div id="Record" name="Record"  style="width:100%;margin-bottom:-15px;">
<div id="form" style=width:400px;margin-left:auto;margin-right:auto;margin-top:1%;>
    <form class="form" id="form1">
      
      <p class="Name">
        <input name="Name" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="Nom" id="Name" />
      </p>
      <p class="Description">
        <input name="Description" type="text" class="validate[required,custom[email]] feedback-input" id="Description" placeholder="Description" />
      </p>
      <p class="Editeur">
        <input name="Editeur" type="text" class="validate[required,custom[email]] feedback-input" id="Editeur" placeholder="Editeur" />
      </p>
      <p class="Google">
        <input name=""Google"" type="text" class="validate[required,custom[email]] feedback-input" id="Google" placeholder="Lien GooglePlay" />
      </p>
      
            <div class="control-group">
  <label class="control-label" for="Type">Type : </label>
  <div class="controls">
    <select id="Type" name="Type" class="input-xlarge">
	${Type}
    </select>
  </div>
</div>
      <div class="control-group">
  <label class="control-label" for="Fonctionne">Compatible : </label>
  <div class="controls">
    <select id="Fonctionne" name="Fonctionne" class="input-xlarge">
      <option id="1" value="1">Oui</option>
      <option id="0" value="0">Non</option>
    </select>
  </div>
</div>
<br />
      <center>
<!-- <a href="#AnnuApp" class="AnnuApp btn btn-warning" >Annuler</a> -->
<a href="#NewApp" class="NewApp btn btn-success" style="margin-left:2%">Ajouter</a>
		 </center>
    </form>
  </div>
  <br />
  <div class="alert alert-warning" name="CreateNOK" id="CreateNOK" style="display:none">Une application avec le même nom est déja dans la base de données.</div>
  <div class="alert alert-success" name="CreateOK" id="CreateOK" style="display:none">L'application a été ajoutée ! Merci de votre contribution.</div>
<div class="alert alert-warning" name="Incomp" id="Incomp" style="display:none">Toutes les données nécéssaires ne sont pas saisies !</div>
  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
      </div>
    </div>
  </div>
</div>


 <!-- jQuery Version 1.11.0 -->
    <script src="resources/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="resources/js/jquery.easing.min.js"></script>

    <!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

    <!-- Custom Theme JavaScript -->
    <script src="resources/js/grayscale.js"></script>

	 <script src="resources/js/main2.js"></script>
	 
	     <!-- Plugin JavaScript -->
    <script src="resources/js/bootstrap-arrows.min.js"></script>
<script type="text/javascript">
    function resetActive(event, percent, step) {
        $(".progress-bar").css("width", percent + "%").attr("aria-valuenow", percent);
        $(".progress-completed").text(percent + "%");

        $("div").each(function () {
            if ($(this).hasClass("activestep")) {
                $(this).removeClass("activestep");
            }
        });

        if (event.target.className == "col-md-2") {
            $(event.target).addClass("activestep");
        }
        else {
            $(event.target.parentNode).addClass("activestep");
        }

        hideSteps();
        showCurrentStepInfo(step);
    }

    function hideSteps() {
        $("div").each(function () {
            if ($(this).hasClass("activeStepInfo")) {
                $(this).removeClass("activeStepInfo");
                $(this).addClass("hiddenStepInfo");
            }
        });
    }

    function showCurrentStepInfo(step) {        
        var id = "#" + step;
        $(id).addClass("activeStepInfo");
    }
</script>

</body>

</html>
