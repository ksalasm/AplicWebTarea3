<%@ page import="java.util.Map" %>
<%@ page import="display.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema Universitario</title>
  </head>
  <h1>Sistema Universitario</h1>
  <h2>Eliminar Profesor</h2>
  <% ProfesorDTO prof = (ProfesorDTO)request.getAttribute("profesor"); %>
  <form name="BorrarProfesor" action="/universidad/borrarProfesor" method="get">
  <input type="hidden" name="id" value="<%= prof.id %>"/>
  <table>
    <tr><td>Nombre:</td><td><input type="text" name="nombre" value="<%= prof.nombre %>"/></td></tr>
    <tr><td>C&eacute;dula:</td><td><input type="text" name="cedula" value="<%= prof.cedula %>"/></td></tr>
    <tr><td>T&iacute;tulo:</td><td><input type="text" name="titulo" value="<%= prof.titulo %>"/></td></tr>
    <tr><td>Area:</td><td><input type="text" name="area" value="<%= prof.area %>"/></td></tr>
    <tr><td>Tel&eacute;fono:</td><td><input type="text" name="telefono" value="<%= prof.telefono %>"/></td></tr>
    <tr><td></td><td><input type="submit" value="Eliminar" /></td></tr>
  </table>
  </form>
</html>