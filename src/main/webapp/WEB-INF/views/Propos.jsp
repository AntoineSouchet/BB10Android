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
      <a class="navbar-brand" href="#">BB <span class="glyphicon glyphicon-heart"></span> Android</a>
    </div>

<!--     Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#Home" class="Home" id="Home" name="Home">Home</a></li>
        <li><a href="#AppList" class="AppList" id="AppList" name="AppList">Applications</a></li>
        <li><a href="#Tuto" class="Tuto" id="Tuto" name="Tuto">Tutorials</a></li>
        <li class="active"><a href="#Propos" class="Propos" id="Propos" name="Propos">A propos</a></li>
      </ul>
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
${getTopBar}
          <input type="text" name="AppName" id="AppName" class="form-control" placeholder="Rechercher">
        </div>
        <a href="#Seek" class="Seek btn btn-primary"><span class="glyphicon glyphicon-search"></span></a>
      </form>
    </div>
    </div>
</nav> 

<div id="Record" name="Record" class="jumbotron" style="width:100%;margin-bottom:0px;">
<fieldset style="margin:5%;margin-top:0px;"><legend>A propos de BB <span class="glyphicon glyphicon-heart">Android : </legend>
<h3>Equipe : </h3><br />
<a href="http://www.linkedin.com/pub/antoine-souchet/5a/32b/70a" target="_blank">
<img src="resources/img/link.png" align="absmiddle"></a> 
<b>Fondateur : </b>Souchet Antoine <br /><br />
<a href="http://www.linkedin.com/pub/mickaël-cirany/59/70/990" target="_blank"><img src="resources/img/link.png" align="absmiddle"></a> <b>Architecture réseau : </b>Cirany Mickael <br /><br />
<a href="http://www.linkedin.com/pub/difallah-mehdi/19/882/323" target="_blank"><img src="resources/img/link.png" align="absmiddle"></a> <b>Résponsable administratif & financier : </b>Difallah Mehdi <br /><br />
<br />
<h3>Matériels disponibles :</h3>
Blackberry Q10 US noir<br />
Blackberry Z10 FR noir<br />
Blackberry Q5 FR noir <br />
Blackberry Q5 FR blanc <br />
Samsung galaxy S4<br />
<h3>Bibliothéques utilisées</h3>
<b>Css :</b> Bootstrap <br />
<b>Hébergement :</b> OVH<br />
<b>GitHub :</b> <a href="https://github.com/AntoineSouchet/BB10Android" target="_blank">Lien</a><br />
<b>Technologies :</b> Spring MVC
</fieldset>
</div>