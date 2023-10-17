<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Usuarios</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<div class="container mx-auto p-4">
        <div class="flex justify-around ">
            <div>
                <label for="type">Tipo de usuario</label>
                <select name="type" id="type">
                    <option value="none" selected>SIN FILTRO</option>
                    <option value="ANALISTA" >ANALISTA</option>
                    <option value="TUTOR" >TUTOR</option>
                    <option value="ESTUDIANTE" >ESTUDIANTE</option>
                </select>
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
                <label for="itr">ITR</label>
                <select name="itr" id="itr">
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
            <table class="" id="table" >
                <tr>
                    <th>USUARIO</th>
                    <th>DOCUMENTO</th>
                    <th>NOMBRE</th>
                    <th>TIPO</th>
                    <th>ITR</th>
                    <th>ESTADO</th>
                    <th>GENERACIÓN</th>
                </tr>
                <c:forEach items="${estList}" var="usu">
            		<tr>
            			<td>${usu.getUsuario().getMailInstitucional()}</td> 
            			<td>${usu.getUsuario().getDocumento()}</td>
            			<td>${usu.getUsuario().getNombre()} ${usu.getUsuario().getApellido()}</td>
            			<td>ESTUDIANTE</td>
            			<td>${usu.getUsuario().getItr()}</td>
            			<td>
            				<select name="" id="">
            					<option value="HABILITADO" ${est.getUsuario().getEstado() == 1 ? "selected" : ""}>HABILITADO</option>
            					<option value="DESHABILITADO" ${usu.getUsuario().getEstado() != 1 ? "selected" : ""}>DESHABILITADO</option>
            				</select>
            			</td>
            			<td>${usu.getGeneracion()}</td>
				</c:forEach>
				<c:forEach items="${tutList}" var="usu">
            		<tr>
            			<td>${usu.getUsuario().getMailInstitucional()}</td> 
            			<td>${usu.getUsuario().getDocumento()}</td>
            			<td>${usu.getUsuario().getNombre()} ${usu.getUsuario().getApellido()}</td>
            			<td>TUTOR</td>
            			<td>${usu.getUsuario().getItr()}</td>
            			<td>
            				<select name="" id="">
            					<option value="HABILITADO" ${usu.getUsuario().getEstado() == 1 ? "selected" : ""}>HABILITADO</option>
            					<option value="DESHABILITADO" ${usu.getUsuario().getEstado() != 1 ? "selected" : ""}>DESHABILITADO</option>
            				</select>
            			</td>
            			<td>TBD</td>
				</c:forEach>
				<c:forEach items="${anaList}" var="usu">
            		<tr>
            			<td>${usu.getUsuario().getMailInstitucional()}</td> 
            			<td>${usu.getUsuario().getDocumento()}</td>
            			<td>${usu.getUsuario().getNombre()} ${usu.getUsuario().getApellido()}</td>
            			<td>ANALISTA</td>
            			<td>${usu.getUsuario().getItr()}</td>
            			<td>
            				<select name="" id="">
            					<option value="HABILITADO" ${usu.getUsuario().getEstado() == 1 ? "selected" : ""}>HABILITADO</option>
            					<option value="DESHABILITADO" ${usu.getUsuario().getEstado() != 1 ? "selected" : ""}>DESHABILITADO</option>
            				</select>
            			</td>
            			<td>TBD</td>
				</c:forEach>
            </table>
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
                    if (document.getElementById('type').value != 'none') {
                        typeText = td[3].innerText == document.getElementById('type').value;
                    }
                    if (document.getElementById('itr').value != 'none') {
                        typeText = td[4].innerText == document.getElementById('itr').value;
                    }
                    if (document.getElementById('estado').value != 'none') {
                        statusText = td[5].getElementsByTagName("select")[0].value == document.getElementById('estado').value;
                    }
                    if (typeText && statusText && itrText) {
                        tr[i].style.display = '';
                    } else {
                        tr[i].style.display = 'none';
                    }
            }
        }
    }
        

    function createRandomUsers() {
        for (i = 0; i < 10 ; i++) {
            let firstName = faker.name.firstName();
            let lastName = faker.name.lastName();
            let document = 2023 - (Math.floor(Math.random()*62) +18) ;
            let type;
            switch (Math.floor(Math.random()*3)) {
                case 0:
                    type = 'ANALISTA';
                    break;
                case 1:
                    type = 'TUTOR';
                    break;
                case 2:
                    type = 'ESTUDIANTE';
                    break;
            }
            let state;
            switch (Math.floor(Math.random()*19)) {
                case 0:
                    state = 'ARTIGAS';
                    break;
                case 1:
                    state = 'CANELONES';
                    break;
                case 2:
                    state = 'CERRO LARGO';
                    break;
                case 3:
                    state = 'COLONIA';
                    break;
                case 4:
                    state = 'DURAZNO';
                    break;
                case 5:
                    state = 'FLORES';
                    break;
                case 6:
                    state = 'FLORIDA';
                    break;
                case 7:
                    state = 'LAVALLEJA';
                    break;
                case 8:
                    state = 'MALDONADO';
                    break;
                case 9:
                    state = 'MONTEVIDEO';
                    break;
                case 10:
                    state = 'PAYASANDÚ';
                    break;
                case 11:
                    state = 'RÍO NEGRO';
                    break;
                case 12:
                    state = 'RIVERA';
                    break;
                case 13:
                    state = 'ROCHA';
                    break;
                case 14:
                    state = 'SALTO';
                    break;
                case 15:
                    state = 'SAN JOSÉ';
                    break;
                case 16:
                    state = 'SORIANO';
                    break;
                case 17:
                    state = 'TACUAREMBÓ';
                    break;
                case 18:
                    state = 'TREINTA Y TRES';
                    break;                
            }   
            let status;
            if (Math.floor(Math.random()*2) > 0) {
                status= '<option value="HABILITADO" selected>HABILITADO</option><option value="DESHABILITADO" >DESHABILITADO</option>'
            } else {
                status= '<option value="HABILITADO">HABILITADO</option><option value="DESHABILITADO" selected>DESHABILITADO</option>'
            }
            
            var row = table.insertRow(i+1);
            row.insertCell(0).innerHTML = `${firstName}.${lastName}@${type == 'ESTUDIANTE' ? 'estudiantes.' : ''}utec.edu.uy`;
            row.insertCell(1).innerHTML = `${document}`;
            row.insertCell(2).innerHTML = `${firstName} ${lastName}`;
            row.insertCell(3).innerHTML = `${type}`;
            row.insertCell(4).innerHTML = `${state}`;
            row.insertCell(5).innerHTML = `<select name="" id="">${status}</select>`;
            row.insertCell(6).innerHTML = Math.floor(Math.random()*11) + 2012;
            row.insertCell(7).innerHTML = `<button class="p-4 bg-sky-800 text-white" >MODIFICAR</button>`;
        }
    }
    createRandomUsers();
</script>    
</html>