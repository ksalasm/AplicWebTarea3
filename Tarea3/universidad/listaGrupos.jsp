<%@ page import="java.util.*" %>
<%@ page import="display.*" %>
<html>
  <head>
    <title>Sistema Universitario</title>
  </head>
  <h1>Sistema Universitario</h1>
  <h2>Grupos</h2>
  <% List groups = (List)request.getAttribute("grupos"); %>
  <table>
    <tr><th>N&uacute;mero</th><th>Sigla</th><th>Nombre</th><th>Horario</th><th>Aula</th><th>CedulaProfesor</th></tr>
    <% for(int i = 0, n = groups.size(); i < n; i++) {
         GrupoDTO group = (GrupoDTO) groups.get(i); %>
        <tr><td><%= group.numero %></td>
        <td><%= group.sigla %></td>
        <td><%= group.nombre %></td>
		<td><%= group.horario %></td>
		<td><%= group.aula %></td>
		<td><%= group.cedulaProfesor %></td>
        <td><a href='/universidad/detalleGrupo?edicion=1&vista=2&id=<%= group.id %>'>
              <input type="submit" value="Detalle"/></a>
            <a href='/universidad/eliminarGrupo?vista=3&id=<%= group.id %>'>
              <input type="submit" value="Eliminar"/></a></td></tr>
    <% } %>
  </table>
    <table>
      <tr><td><a href='/universidad/agregarGrupo?vista=1'>
        <input type="submit" name="action" value="Agregar"/></a>
      </td></tr>
    </table>
</html>