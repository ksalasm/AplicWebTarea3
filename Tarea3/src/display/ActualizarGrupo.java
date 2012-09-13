package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.GroupRepository;
import domain.Group;

public class ActualizarGrupo extends PageController {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    GroupRepository groups = (GroupRepository) context.getBean("groupRepository");
    try {
            String id = request.getParameter("id");
            int idGroup = Integer.parseInt(id);
            String numero = request.getParameter("numero");
            String sigla = request.getParameter("sigla");
            String nombre = request.getParameter("nombre");
            String horario = request.getParameter("horario");
            String aula = request.getParameter("aula");
			String cedulaProfesor = request.getParameter("cedulaProfesor");
            Group group = groups.findGroup(idGroup+"");
            try {
                if (numero!=null) groups.setNumero(numero);
                if (sigla!=null) groups.setSigla(sigla);
                if (nombre!=null) groups.setNombre(nombre);
                if (horario!=null) groups.setHorario(horario);
                if (aula!=null) groups.setAula(aula);
				if (cedulaProfesor!=null) groups.setCedulaProfesor(cedulaProfesor);
            } catch (Exception e) {}
            response.sendRedirect("listaGroups");
        } catch (Exception e) {
            request.setAttribute("mensaje",e.getMessage());
            forward("/paginaError.jsp",request,response);
        }
  }
}