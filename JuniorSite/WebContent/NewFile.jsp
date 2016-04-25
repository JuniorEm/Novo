<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
</head>
<body>
<div class="container-fluid">
    <header>
        <div class="jumbotron">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a href="#">Home</a></li>
                <li role="presentation"><a href="#">U.S</a></li>
            </ul>
        </div>
    </header>
    <div class="row col-md-8" role="main">
        <h2 class="page-header">In�cio</h2>
        <p>O formul�rio logo ao lado representa algumas informa��es das quais precisamos saber.</p>
    </div>

    <aside role="complementary" class="col-md-4">
        <form>
            <label for="input-nome">Nome</label>
            <input type="text" id="input-nome" name="nome" value="Cr�codilo" class="form-control"/>
        </form>
    </aside>
</div>


<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>