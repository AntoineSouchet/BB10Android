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
        <li class="active"><a href="#AppList" class="AppList" id="AppList" name="AppList">Applications</a></li>
        <li><a href="#Tuto" class="Tuto" id="Tuto" name="Tuto">Tutorials</a></li>
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

<!-- <div id="form-main"> -->
<!--   <div id="form-div"> -->
<div id="Record" name="Record" class="jumbotron" style="width:100%;margin-bottom:-15px;">
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
  <div class="alert alert-success" name="CreateOK" id="CreateOK" style="display:none">L'application a été ajouté ! Merci de votre contribution.</div>
<div class="alert alert-warning" name="Incomp" id="Incomp" style="display:none">Toutes les données nécéssaires ne sont pas saisies !</div>
  </div>



<!-- </div> -->
  