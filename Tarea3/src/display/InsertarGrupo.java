package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.GroupRepository;
import domain.Group;

public class InsertarGrupo extends PageController {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    GroupRepository groups = (GroupRepository) context.getBean("groupRepository");
    try {
            String numero = request.getParameter("numero");
			String sigla = request.getParameter("sigla");
            String nombre = request.getParameter("nombre");
            String horario = request.getParameter("horario");
            String aula = request.getParameter("aula");
			String cedulaProfesor = request.getParameter("cedulaProfesor");
            
			Group group = new Group();
			
			if (numero!=null) group.setNumero(numero);
			if (sigla!=null) group.setSigla(sigla);
			if (nombre!=null) group.setNombre(nombre);
			if (horario!=null) group.setHorario(horario);
			if (aula!=null) group.setAula(aula);
			if (cedulaProfesor!=null) group.setCedulaProfesor(cedulaProfesor);

			if(groups.insertGroup(group) == true){
				response.sendRedirect("listaGrupos");
			}
			else
				throw new Exception();
        } catch (Exception e) {
            request.setAttribute("mensaje",e.getMessage());
            forward("/paginaError.jsp",request,response);
        }
  }
}