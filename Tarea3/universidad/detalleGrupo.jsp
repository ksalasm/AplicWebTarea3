<%@ page import="java.util.*" %>
<%@ page import="display.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema Universitario</title>
  </head>
  <h1>Sistema Universitario</h1>
  <h2>Detalle de Grupo</h2>
  <% GrupoDTO grupo = (GrupoDTO)request.getAttribute("grupo"); %>
  <% List profs = (List)request.getAttribute("profesores"); %>
  <% String edicion = (String)request.getAttribute("edicion"); %>
  <form name="ActualizarGrupo" action="/universidad/actualizarGrupo" method="get">
  <input type="hidden" name="id" value="<%= grupo.id %>"/>
  <table>
    <tr><td>Numero:</td><td><input type="text" name="numero" value="<%= grupo.numero %>"/></td></tr>
	<tr><td>Sigla:</td><td><input type="text" name="sigla" value="<%= grupo.sigla %>"} %>/></td></tr>
	<tr><td>Nombre:</td><td><input type="text" name="nombre" value="<%= grupo.nombre %>"/></td></tr>
	<tr><td>Horario:</td><td><input type="text" name="horario" value="<%= grupo.horario %>"/></td></tr>
    <tr><td>Aula:</td><td><input type="text" name="aula" value="<%= grupo.aula %>"/></td></tr>
    <tr><td>Profesor:</td>
		<td>
			<select name="idProf">
				<% for(int i = 0, n = profs.size(); i < n; i++) {
					 ProfesorDTO profe = (ProfesorDTO) profs.get(i); %>
					 <option <% if(profe.cedula.equals(grupo.idProf)){%> selected <% }%> value="<%= profe.cedula %>"><%= profe.nombre %></option>
				<% } %>				
			</select>
		</td>
	</tr>
 </table>
  </form>
</html>