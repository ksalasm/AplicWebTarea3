<%@ page import="java.util.*" %>
<%@ page import="display.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema Universitario</title>
  </head>
  <h1>Sistema Universitario</h1>
  <h2>Detalle de Profesor</h2>
  <% ProfesorDTO prof = (ProfesorDTO)request.getAttribute("profesor"); %>
  <% List grupos = (List)request.getAttribute("grupos"); %>
  <form name="ActualizarProfesor" action="/universidad/actualizarProfesor" method="get">
  <input type="hidden" name="id" value="<%= prof.id %>"/>
  <table>
    <tr><td>Nombre:</td><td><input type="text" name="nombre" value="<%= prof.nombre %>"/></td></tr>
    <tr><td>C&eacute;dula:</td><td><input type="text" name="cedula" value="<%= prof.cedula %>"/></td></tr>
    <tr><td>T&iacute;tulo:</td><td><input type="text" name="titulo" value="<%= prof.titulo %>"/></td></tr>
    <tr><td>Area:</td><td><input type="text" name="area" value="<%= prof.area %>"/></td></tr>
    <tr><td>Tel&eacute;fono:</td><td><input type="text" name="telefono" value="<%= prof.telefono %>"/></td></tr>
    <tr><td></td><td><input type="submit" value="Actualizar" /></td></tr>
  </table>   
  </form>
  <br/><br/>
  <h2>Grupos</h2>  
  <table>
    <tr><th>Numero</th><th>Sigla</th><th>Nombre</th><th>Horario</th><th>Aula</th></tr>
    <% for(int i = 0, n = grupos.size(); i < n; i++) {
         GrupoDTO group = (GrupoDTO) grupos.get(i); %>
        <tr><td><%= group.numero %></td>
        <td><%= group.sigla %></td>
        <td><%= group.nombre %></td>
		<td><%= group.horario %></td>
		<td><%= group.aula %></td>
        <td><a href='/universidad/detalleGrupo?edicion=0&vista=2&id=<%= group.id %>'><input type="submit" value="Detalle"/></a></td></tr>
    <% } %>
  </table> 
</html>