<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<%!
	int visitante = 0;
	public void addNumber() {
		visitante++;
	}
%>
<body class="bg-sky-400">
	<div>
		<div class="bg-sky-400 container mx-auto w-full h-full relative p-40 flex justify-center">
			<div class="anim1 absolute border-8 border-white w-72 h-96  z-10 animate-pulse"></div>
        	<div class="anim2 absolute border-8 border-white w-72 h-96  z-10 animate-pulse"></div>
        	<div class="anim3 flex flex-col text-white justify-center items-center z-50">
        		<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-32 h-48 transition hover:-translate-y-1 hover:scale-110  ">
            		<path stroke-linecap="round" stroke-linejoin="round" d="M4.26 10.147a60.436 60.436 0 00-.491 6.347A48.627 48.627 0 0112 20.904a48.627 48.627 0 018.232-4.41 60.46 60.46 0 00-.491-6.347m-15.482 0a50.57 50.57 0 00-2.658-.813A59.905 59.905 0 0112 3.493a59.902 59.902 0 0110.399 5.84c-.896.248-1.783.52-2.658.814m-15.482 0A50.697 50.697 0 0112 13.489a50.702 50.702 0 017.74-3.342M6.75 15a.75.75 0 100-1.5.75.75 0 000 1.5zm0 0v-3.675A55.378 55.378 0 0112 8.443m-7.007 11.55A5.981 5.981 0 006.75 15.75v-1.5" />
				</svg>
            	<h1 class="text-7xl">SI.G.A</h1>
            	<span class="text-1xl">Sistema de Gestion Academica</span>
			</div>
		</div>
		<div class="container mx-auto text-white flex flex-col sm:flex-col md:flex-row justify-center p-5 gap-0">
            <a href="" class="flex justify-center bg-sky-800 p-4 md:w-64 transition hover:-translate-y-1 hover:scale-110 ">REGISTRO</a>
            <a href="login" class="flex justify-center bg-sky-800 p-4 md:w-64 transition hover:-translate-y-1 hover:scale-110 ">LOGIN</a>
            <a href="usuarios" class="flex justify-center bg-sky-800 p-4 md:w-64 transition hover:-translate-y-1 hover:scale-110 ">Usuarios</a>
            <a href="itr" class="flex justify-center bg-sky-800 p-4 md:w-64 transition hover:-translate-y-1 hover:scale-110 ">IRT's</a>
        </div>
	</div>
	
</body>
<style>
    @keyframes anim1 {
        0% {
            transform: translateY(-3000px);
        } 
        50% {
            transform: translateY(0px);
            transform: rotate(0deg);
        }
        100% {
            transform: rotate(340deg);
            }
    }
    @keyframes anim2 {
        0% {
            transform: translateY(3000px);
            transform: rotate(30deg);
        }
        50% {
            transform: translateY(0px);
            transform: rotate(30deg);
        }
        100% {
            transform: rotate(-10deg);
        }
    }
    
    .anim1 {
        animation: anim1 1000ms forwards;
    }
    .anim2 {
        animation: anim2 1000ms forwards;
    }
</style>
</html>