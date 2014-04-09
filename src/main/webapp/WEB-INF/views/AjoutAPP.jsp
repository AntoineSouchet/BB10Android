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
        <li><a href="#Home">Home</a></li>
        <li class="active"><a href="#Home">Applications</a></li>
        <li><a href="#Home">Tutorials</a></li>
        <li><a href="#Home">A propos</a></li>
      </ul>
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
        <a href="#Login" class="btn btn-primary">Connexion</a>
        <a href="#AddApp" id="AddApp" class="AddApp btn btn-success">Ajouter application</a>
          <input type="text" class="form-control" placeholder="Rechercher">
        </div>
        <a href="#Seek" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></a>
      </form>
    </div>
    </div>
</nav>    

<div class="jumbotron" style="width:100%;">
<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Ajouter une application</legend>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Nom de l'application</label>
  <div class="controls">
    <input id="textinput" name="textinput" type="text" placeholder="Nom" style="width:200px">
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Site web de l'application</label>
  <div class="controls">
    <input id="textinput" name="textinput" type="text" placeholder="Url" style="width:500px">

  </div>
</div>

<div class="control-group">
  <label class="control-label" for="textinput">Lien Play Store</label>
  <div class="controls">
    <input id="textinput" name="textinput" type="text" placeholder="Url" style="width:500px">
  </div>
</div>

<!-- Select Basic -->
<div class="control-group">
  <label class="control-label" for="selectbasic">Type d'application</label>
  <div class="controls">
    <select id="selectbasic" name="selectbasic" class="input-xlarge">
      ${MesType}
    </select>
  </div>
</div>

<!-- Multiple Checkboxes -->
<div class="control-group">
  <label class="control-label" for="checkboxes">Testé sur</label>
  <div class="controls">
    <label class="checkbox" for="checkboxes-0">
      <input type="checkbox" name="checkboxes" id="checkboxes-0" value="Option one">
      Blackberry Q5
    </label>
    <label class="checkbox" for="checkboxes-1">
      <input type="checkbox" name="checkboxes" id="checkboxes-1" value="Option two">
       Blackberry Q10
    </label>
    <label class="checkbox" for="checkboxes-2">
      <input type="checkbox" name="checkboxes" id="checkboxes-2" value="Option tree">
       Blackberry Z10
    </label>
    <label class="checkbox" for="checkboxes-3">
      <input type="checkbox" name="checkboxes" id="checkboxes-3" value="Option four">
       Blackberry Z30
    </label>
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="selectbasic">Résultat du test</label>
  <div class="controls">
    <select id="selectbasic" name="selectbasic" class="input-xlarge">
      <option>Fonctionne</option>
      <option>Ne fonctionne pas</option>
    </select>
  </div>
</div>

</fieldset>
</form>




</div>
  