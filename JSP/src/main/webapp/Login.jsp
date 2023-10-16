<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>S.I.G.A - LOGIN</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-sky-400 static">
		
	<div class="mx-auto container mx-auto w-full h-screen relative flex flex-col justify-center items-center ">
		<form id="login" class="grid grid-cols-4 content-center gap-2 h-32 " method="post" action="LoginServlet">
			<h1 class="text-center text-3xl col-span-4 font-bold text-white">LOGIN</h1>
			<label for="username" class="text-white">USUARIO</label>
			<input id="username" class="col-span-4 p-4" placeholder="usuario.apellido" type="text" name="username"/>
			<label for="password" class="text-white">CONTRASEÑA</label>
			<input id="password" class="col-span-4 p-4" placeholder="******" type="password" name="password"/>
			<p class="text-red-500 text-center col-span-4 uppercase font-bold ">
			<% if( request.getAttribute("errorMessage") != null) out.println(request.getAttribute("errorMessage")); %>
			</p>
			<button type="submit" class="bg-sky-700 col-span-2 text-white p-2">LOGIN</button>
			<button type="submit" class="bg-red-400 col-span-2 text-white p-2">REGISTRARSE</button>
		</form>
	</div>
</body>
</html>