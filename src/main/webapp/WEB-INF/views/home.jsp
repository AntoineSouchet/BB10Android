<!doctype html>
 <meta http-equiv="X-UA-Compatible" content="IE=Edge">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>BB10 <3 Android</title>
</head>
<script src="resources/js/jquery-1.9.1.js"></script>
<script src="resources/js/jquery-ui.js"></script>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<link rel="stylesheet" href="resources/bootstrap-3.1.1/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="resources/bootstrap-3.1.1/css/bootstrap-theme.min.css" type="text/css" />
<script src="resources/bootstrap-3.1.1/js/bootstrap.js"></script>
<script src="resources/main.js"></script>
<style type="text/css">
h2{
    margin: 0;     
    color: #FFF;
    padding-top: 90px;
    font-size: 52px;
    font-family: "trebuchet ms", sans-serif;    
}
bottomText {
	color: #000;
    font-size: 8px;
    font-family: "trebuchet ms", sans-serif;   
}
.item{
    background: #295e92;    
    text-align: center;
    height: 300px !important;
}
.carousel{
    margin-top: 0px;
}
.bs-example{
	margin: 00px;
}
</style>
<body>
<nav class="navbar navbar-default" role="navigation" style="margin-bottom:0px;">
  <div class="container-fluid">
<!--     Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">BB10 <span class="glyphicon glyphicon-heart"></span> Android</a>
    </div>

<!--     Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#Home">Home</a></li>
        <li><a href="#Home">Applications</a></li>
        <li><a href="#Home">Tutorials</a></li>
        <li><a href="#Home">A propos</a></li>
      </ul>
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Rechercher">
        </div>
        <a href="#Seek" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></a>
      </form>
    </div>
    </div>
</nav>    
    <!-- Caroussel -->
<div class="bs-example">
    <div id="myCarousel" class="carousel slide" data-interval="3000" data-ride="carousel">
    	<!-- Carousel indicators -->
        <ol class="carousel-indicators">
            <li class="slide-one active"></li>
            <li class="slide-two"></li>
            <li class="slide-three"></li>
        </ol>   
        <!-- Carousel items -->
        <div class="carousel-inner">
            <div class="active item">
                <h2>BB10 <span class="glyphicon glyphicon-heart"></span> Android</h2>
         		<div class="carousel-caption">
                  <h3>Tutorial</h3>
                  <p>Découvez comment votre Blackberry peux utiliser vos APK.</p>
                </div>
            </div>
            <div class="item">
                <h2>Compatibilités</h2>
                <div class="carousel-caption">
                  <h3>Informations</h3>
                  <p>Découvrez la liste des applications testées et compatbiles.</p>
                </div>
            </div>
            <div class="item">
                <h2>Réseaux</h2>
                <div class="carousel-caption">
                  <h3>Facebook Twitter</h3>
                  <p>Rejoingnez nous sur les réseaus sociaux #BB10Android</p>
                </div>
            </div>
        </div>
        <!-- Carousel nav -->
        <a class="carousel-control left">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="carousel-control right">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>
</div>
<!-- Fin du caroussel -->
<br />


<nav class="navbar navbar-default" role="navigation" style="margin:10px;">
<p class="bg-info"><center>BB10 <span class="glyphicon glyphicon-heart"> Android, comment ça marche ?</center></p>
  <div class="container-fluid">
  
<div id="step" style="margin:20px;float:left;width:30%">
<div class="row">
<!--   <div class="col-sm-2 col-md-2"> -->
    <div class="thumbnail">
    <img src="resources/img/inverted-gray/mobile.png">
      <div class="caption"><center>
        <h3>Test</h3>
        <p>Télécharge et test l'application Android sur ton BlackBerry.</p>
        <p><a href="#" class="btn btn-success" role="button">#1</a></center></p>
      </div>
    </div>
<!--   </div> -->
</div>
</div>
<!-- </div> -->

<div id="step" style="margin:20px;float:left;width:30%">
<div class="row">
<!--   <div class="col-sm-2 col-md-2"> -->
    <div class="thumbnail">
    <img src="resources/img/inverted-gray/talkcloud.png">
      <div class="caption"><center>
        <h3>Résultat</h3>
        <p>J'indique si l'application est compatible.</p>
        <p><a href="#" class="btn btn-success" role="button">#2</a></center></p>
      </div>
    </div>
<!--   </div> -->
</div>
</div>

<div id="step" style="margin:20px;float:left;width:30%">
<div class="row">
<!--   <div class="col-sm-2 col-md-2"> -->
    <div class="thumbnail">
    <img src="resources/img/inverted-gray/smiley.png">
      <div class="caption"><center>
        <h3>Finit</h3>
        <p>Je viens d'aider la communauté des utilisateurs BlackBerry.</p>
        <p><a href="#" class="btn btn-success" role="button">#3</a></center></p>
      </div>
    </div>
<!--   </div> -->
</div>
</div>
<!-- </div> -->
</nav>
</div>
<nav class="navbar navbar-default" role="navigation">
<bottomText><center>
Copyright © 2014 BBLove Android<br />
Blackberry est une déposée, soumise au droit d'auteur.<br />
Android est une marque déposée, soumise au droit d'auteur.<br />
En France, sa mise à disposition est autorisée dans la limite des droits accordés par l'article L713-6 alinéa b du Code de la propriété intellectuelle et est reproduite ici en vertu de ces droits.</bottomText>
</center></nav>
</body>
</html>
