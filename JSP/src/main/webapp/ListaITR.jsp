<%@page import="funcionalidades.DAOITR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.bigfive.beans.ITRBean"%>
<%@page import="com.bigfive.entities.Itr"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body>
    <div>
        <div class="flex align-bottom h-16 items-center gap-4">
            <img src="https://red.utec.edu.uy/wp-content/uploads/2018/11/09-Isotipo-1.png" alt="" class="w-8 md:w-16 h-8 md:h-16">
            <h2 class="text-3xl text-sky-500">LISTA ITR'S</h2>
        </div>
    </div>
    <div class="flex justify-around  items-center">
        <div class="">
            <label for="nombre">Nombre ITR: </label>
            <input type="text" name="nombre" id="nombre" placeholder="Ingresar nombre del itr" class="p-4 bg-slate-100 w-72">
        </div>
        <div>
            <label for="status">Estado</label>
            <select name="status" id="estado">
                <option value="none" selected>SIN FILTRO</option>
                <option value="HABILITADO">HABILITADO</option>
                <option value="DESHABILITADO">DESHABILITADO</option>
            </select>
        </div>
        <div>
            <label for="localidad">LOCALIDAD</label>
            <select name="localidad" id="localidad">
                <option value="none" selected>SIN FILTRO</option>
                <option value="ARTIGAS">ARTIGAS</option>
                <option value="CANELONES">CANELONES</option>
                <option value="CERRO LARGO">CERRO LARGO</option>
                <option value="COLONIA">COLONIA</option>
                <option value="DURAZNO">DURAZNO</option>
                <option value="FLORES">FLORES</option>
                <option value="FLORIDA">FLORIDA</option>
                <option value="LAVALLEJA">LAVALLEJA</option>
                <option value="MALDONADO">MALDONADO</option>
                <option value="MONTEVIDEO">MONTEVIDEO</option>
                <option value="PAYSANDÚ">PAYSANDÚ</option>
                <option value="RÍO NEGRO">RÍO NEGRO</option>
                <option value="RIVERA">RIVERA</option>
                <option value="ROCHA">ROCHA</option>
                <option value="SALTO">SALTO</option>
                <option value="SAN JOSÉ">SAN JOSÉ</option>
                <option value="SORIANO">SORIANO</option>
                <option value="TACUAREMBÓ">TACUAREMBÓ</option>
                <option value="TREINTA Y TRES">TREINTA Y TRES</option>
            </select>
        </div>
    </div>
    <div class="grid sm:grid-cols-1 md:grid-cols-2 gap-4 p-4">
        <button class="p-4 bg-sky-800 text-white" onclick="filter()">FILTRAR</button>
        <button class="p-4 bg-sky-800 text-white" onclick="limpiarFiltro()">LIMPIAR FILTRO</button>
    </div>
    <div class="grid">
        <table class="text-center" id="table" >
            <tr>
                <th>ITR</th>
                <th>LOCALIDAD</th>
                <th>ESTADO</th>
            </tr>
            </tr>
            <c:forEach items="${itrList}" var="itr">
            	<tr>
            		<td>${itr.getNombre()}</td>
            		<td>${itr.getDepartamento()}</td>
            		<td>
            		<select name="" id="">
            			<option value="HABILITADO" ${itr.getEstado() == 1 ? "selected" : ""}>HABILITADO</option>
            			<option value="DESHABILITADO" ${itr.getEstado() != 1 ? "selected" : ""}>DESHABILITADO</option>
            		</select>
            	</td>
				<p>
					
				</p>
			</c:forEach>
        </table>
        <div class="text-center flex justify-center">
            <svg class="animate-spin w-6 h-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" d="M16.023 9.348h4.992v-.001M2.985 19.644v-4.992m0 0h4.992m-4.993 0l3.181 3.183a8.25 8.25 0 0013.803-3.7M4.031 9.865a8.25 8.25 0 0113.803-3.7l3.181 3.182m0-4.991v4.99" />
            </svg>
            CARGANDO ITR'S
        </div>
    </div>
</body>
<script>

    table = document.getElementById('table');
    function limpiarFiltro() {
        tr = table.getElementsByTagName("tr");
        for (i = 1; i < tr.length; i++) {
            tr[i].style.display = '';
        }
    }


    function filter() {
        tr = table.getElementsByTagName("tr");
        for (i = 1; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td");
                if (td) {
                    typeText = true;
                    statusText = true;
                    itrText = true;
                    if (document.getElementById('nombre').value != 'none') {
                        if (document.getElementById('nombre').value != '') {
                            typeText = td[0].innerText == document.getElementById('nombre').value;
                        }
                    }
                    if (document.getElementById('localidad').value != 'none') {
                        typeText = td[1].innerText == document.getElementById('localidad').value;
                    }
                    if (document.getElementById('estado').value != 'none') {
                        statusText = td[2].getElementsByTagName("select")[0].value ==  document.getElementById('estado').value;
                    }
                    if (typeText && statusText && itrText) {
                        tr[i].style.display = '';
                    } else {
                        tr[i].style.display = 'none';
                    }
            }
        }
    }
  </script>
</html>