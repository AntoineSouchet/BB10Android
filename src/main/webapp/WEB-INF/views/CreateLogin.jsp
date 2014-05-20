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
        <li  class="active"><a href="#Home" class="Home" id="Home" name="Home">Accueil</a></li>
        <li><a href="#AppList" class="AppList" id="AppList" name="AppList">Applications</a></li>
        <li><a href="#Tuto" class="Tuto" id="Tuto" name="Tuto">Tutoriel</a></li>
        <li><a href="#Propos" class="Propos" id="Propos" name="Propos">A propos</a></li>
      </ul>
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
${getTopBar}
          <input type="text" name="AppName" id="AppName" class="form-control" placeholder="Rechercher">
        </div>
        <a href="#Seek" class="Seek btn btn-primary"><span class="glyphicon glyphicon-search"></span></a></span></a>
      </form>
    </div>
    </div>
</nav>    
<div id="Record" name="Record" class="jumbotron" style="width:100%;margin-bottom:-15px;">
<div id="Compte" name="Compte">
<div id="form" style=width:400px;margin-left:auto;margin-right:auto;margin-top:1%;>
    <form class="form" id="form1">
      
      <p class="login">
        <input name="Login" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="Login" id="Login" />
      </p>
      <p class="pass">
        <input name="password2" type="password" class="validate[required,custom[email]] feedback-input" id="password2" placeholder="Password" />
      </p>
      <div class="alert alert-danger" name="MonPassw" id="MonPassw" style="display:none">Merci de saisir un mot de passe.</div>
      <p class="pass">
        <input name="passwordbis" type="password" class="validate[required,custom[email]] feedback-input" id="passwordbis" placeholder="Password à nouveau" />
      </p>
      <div class="alert alert-danger" name="DoublePass" id="DoublePass" style="display:none">Les deux mots de passes ne correspondent pas.</div>
            <p class="email">
        <input name="MonMail" type="text" class="validate[required,custom[email]] feedback-input" id="MonMail" placeholder="Adresse mail valide" />
      </p>
      
      <div class="control-group">
  <label class="control-label" for="Sexe">Sexe : </label>
  <div class="controls">
    <select id="Sexe" name="Sexe" class="input-xlarge">
      <option id="1" value="1">Homme</option>
      <option id="0" value="0">Femme</option>
    </select>
  </div>
</div>
<br />
      <center>
<!-- <a href="#AnnuApp" class="AnnuApp btn btn-warning" >Annuler</a> -->
<a href="#AddApp" class="CreateLog btn btn-success" style="margin-left:2%">Créer mon compte</a>
		 </center>
    </form>
  </div>
  <br />
  <div class="alert alert-success" name="CreateOK" name="CreateOK" style="display:none">Compte crée avec succés, vérifiez votre boite de réception afin de la valider votre addrese.</div>
<div class="alert alert-warning" name="duplicate" id="duplicate" style="display:none">Le nom d'utilisateur ou cette adresse mail existe deja !</div>
<div class="alert alert-danger" name="EmptyMail" id="EmptyMail" style="display:none">Merci de saisir une adresse mail.</div>
<div class="alert alert-danger" name="Log" id="Log" style="display:none">Merci de saisir un nom d'utilisateur.</div>

  </div>


<br />

</fieldset>
</form>
</div>
</div>


</div>
  