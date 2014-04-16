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
        <li  class="active"><a href="#Home" class="Home" id="Home" name="Home">Home</a></li>
        <li><a href="#Home">Applications</a></li>
        <li><a href="#Tuto" class="Tuto" id="Tuto" name="Tuto">Tutorials</a></li>
        <li><a href="#Propos" class="Propos" id="Propos" name="Propos">A propos</a></li>
      </ul>
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
${getTopBar}
          <input type="text" class="form-control" placeholder="Rechercher">
        </div>
        <a href="#Seek" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></a>
      </form>
    </div>
    </div>
</nav>    


<form class="form-horizontal">
<fieldset style="margin:5%">
<div id="Compte">
<!-- Form Name -->
<legend>Créer un compte d'utilisateur</legend>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Nom d'utilisateur : </label>
  <div class="controls">
    <input id="Login" name="Login" type="text" placeholder="Nom" style="width:200px">
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="password2">Password : </label>
  <div class="controls">
    <input id="password2" name="password2" type="password" placeholder="Password" style="width:200px">

  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Password : </label>
  <div class="controls">
    <input id="passwordbis" name="passwordbis" type="password" placeholder="Ressaisir le password" style="width:200px">

  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="MonMail">Adresse mail : </label>
  <div class="controls">
    <input id="MonMail" name="MonMail" type="text" placeholder="email" style="width:300px">
  </div>
</div>

<!-- Select Basic -->
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
<br />
<a href="#AnnuApp" class="AnnuApp btn btn-warning" >Annuler</a>
<a href="#AddApp" class="CreateLog btn btn-success" style="margin-left:2%">Créer mon compte</a>
</center>
<br />
<div class="alert alert-success" name="CreateOK" name="CreateOK" style="display:none">Compte crée avec succés, vérifiez votre boite de réception afin de la valider votre addrese.</div>
<div class="alert alert-warning" name="duplicate" id="duplicate" style="display:none">Le nom d'utilisateur ou cette adresse mail existe deja !</div>
<div class="alert alert-danger" name="DoublePass" id="DoublePass" style="display:none">Les deux mots de passes ne correspondent pas.</div>
<div class="alert alert-danger" name="EmptyMail" id="EmptyMail" style="display:none">Merci de saisir une adresse mail.</div>
<div class="alert alert-danger" name="Log" id="Log" style="display:none">Merci de saisir un nom d'utilisateur.</div>
<div class="alert alert-danger" name="MonPassw" id="MonPassw" style="display:none">Merci de saisir un mot de passe.</div>
</fieldset>
</form>

</div>


</div>
  