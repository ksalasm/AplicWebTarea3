<%@ page import="java.util.*" %>
<%@ page import="display.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema Universitario</title>
  </head>
  <h1>Sistema Universitario</h1>
  <h2>Eliminar Grupo</h2>
  <% GrupoDTO group = (GrupoDTO)request.getAttribute("grupo"); %>
  <% List profs = (List)request.getAttribute("profesores"); %>
  <form name="BorrarGrupo" action="/universidad/borrarGrupo" method="get">
  <input type="hidden" name="id" value="<%= group.id %>"/>
  <table>
    <tr><td>N&uacute;mero:</td><td><input type="text" name="numero" value="<%= group.numero %>"/></td></tr>
	<tr><td>Sigla:</td><td><input type="text" name="sigla" value="<%= group.sigla %>"/></td></tr>
	<tr><td>Nombre:</td><td><input type="text" name="nombre" value="<%= group.nombre %>"/></td></tr>
	<tr><td>Horario:</td><td><input type="text" name="horario" value="<%= group.horario %>"/></td></tr>
    <tr><td>Aula:</td><td><input type="text" name="aula" value="<%= group.aula %>"/></td></tr>
    <tr><td>Profesor:</td><td><select name="idProf" disabled="true">
		<% for(int i = 0, n = profs.size(); i < n; i++) {
			 ProfesorDTO profe = (ProfesorDTO) profs.get(i); %>
			 <option <% if(profe.cedula.equals(group.idProf)){%> selected <% }%> value="<%= profe.cedula %>"><%= profe.nombre %></option>
		<% } %>				
	</select></td></tr>
    <tr><td></td><td><input type="submit" value="Eliminar" /></td></tr>
  </table>
  </form>
</html>