package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.ProfesorRepository;
import domain.Profesor;

public class ListaProfesores extends PageController {

  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    
	ProfesorRepository profesores = (ProfesorRepository) context.getBean("profesorRepository");
    try {
            Collection lista = profesores.findAllProfesor();
            List data = new ArrayList();
            Iterator itr = lista.iterator();
            while (itr.hasNext()) {
                Profesor prof = (Profesor)itr.next();
                ProfesorDTO dto = ProfesorAssembler.Create(prof);
                data.add(dto);
            }
            request.setAttribute("profesores",data);
			forward("/listaProfesores.jsp",request,response);
    } catch (Exception e) {
            request.setAttribute("mensaje",e.getMessage());
            forward("/paginaError.jsp",request,response);
    }
  }
}