package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.GroupRepository;
import domain.Group;

public class BorrarGrupo extends PageController {

  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    
	GroupRepository grupos = (GroupRepository) context.getBean("groupRepository");
    try {
            String id = request.getParameter("id");
            int idGrupo = Integer.parseInt(id);
            String numero = request.getParameter("numero");
            String sigla = request.getParameter("sigla");
            String nombre = request.getParameter("nombre");
            String horario = request.getParameter("horario");
            String aula = request.getParameter("aula");
			String cedulaProfesor = request.getParameter("cedulaProfesor");
			
			Group grupo = new Group();
			
			grupo.setId(idGrupo);			
			if (numero!=null) grupo.setNumero(numero);
			if (sigla!=null) grupo.setSigla(sigla);
			if (horario!=null) grupo.setHorario(horario);
			if (aula!=null) grupo.setAula(aula);
			if (cedulaProfesor!=null) grupo.setCedulaProfesor(cedulaProfesor);
			
			if(grupos.deleteGroup(grupo) == true){
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