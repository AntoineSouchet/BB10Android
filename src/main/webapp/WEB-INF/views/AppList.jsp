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
        <li><a href="#Home" class="Home" id="Home" name="Home">Accueil</a></li>
        <li class="active"><a href="#AppList" class="AppList" name="AppList" id="AppList">Applications</a></li>
        <li><a href="#Tuto" class="Tuto" id="Tuto" name="Tuto">Tutoriel</a></li>
        <li><a href="#Propos" class="Propos" id="Propos" name="Propos">A propos</a></li>
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
<table class="order-table table table-striped table-hover">
<thead bgcolor="#295e92" font-color="#fff">
<tr><th><font color="#fff">Nom</font></th>
<th><font color="#fff">Editeur</font></th>
<th><font color="#fff">Type</font></th>
<th><font color="#fff">Statut</font></th>
<th><font color="#fff">Utilisateur</font></th>
<th><font color="#fff">GooglePlay</font></th>
<th><font color="#fff">Informations</font></th>
</thead>
<tbody>
${ListeApp}
</tbody>
</table>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title"><div id="Titre"></div></h4>
      </div>
      <div class="modal-body">
       <div id="infoApp"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title"><div id="TitreUsr"></div></h4>
      </div>
      <div class="modal-body">
       <div id="infoUsr"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>