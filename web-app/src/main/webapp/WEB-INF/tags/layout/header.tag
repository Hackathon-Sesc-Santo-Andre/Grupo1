<%@ tag body-content="empty" description="Header tag file"%>

<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="user" required="true" description="User logged" %>
<div id="header" class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a> <a class="brand" href="home.do">Spark</a>
			<div class="nav-collapse collapse">
				<p class="navbar-text pull-right">
					Logado como <a href="#" class="navbar-link"> <c:out	value="${user}" />
					</a>
				</p>
				<ul class="nav">
					<li class="active"><a href="home.do">Principal</a></li>
					<li><a href="#about">Sobre</a></li>
					<li><a href="#contact">Contato</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Cadastros <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class="nav-header">Area Equipamento</li>
							<li><a href="listAparelhos.do">Listagem de Aparelho</a></li>
							<li><a href="listManut.do">Listagem de Manutenções</a></li>
							<li class="divider"></li>
							<li class="nav-header">Area Usuário</li>
							<li><a href="listUsuarios.do">Listagem de Usuários</a></li>
							<li><a href="listPerfis.do">Listagem de Perfis</a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>
