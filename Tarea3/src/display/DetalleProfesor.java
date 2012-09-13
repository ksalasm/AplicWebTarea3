package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.ProfesorRepository;
import domain.Profesor;

import domain.GroupRepository;
import domain.Group;

public class DetalleProfesor extends PageController {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    ProfesorRepository profesores = (ProfesorRepository) context.getBean("profesorRepository");
	  
    try {
			String tipoVista = request.getParameter("vista");
			if(tipoVista.equals("1")){//Agregar
				forward("/agregarProfesor.jsp",request,response);
			}
			else if(tipoVista.equals("2")){//Modificar
				String id = request.getParameter("id");
				int idProf = Integer.parseInt(id);
				Profesor prof = profesores.findProfesor(idProf+"");
				ProfesorDTO dto = ProfesorAssembler.Create(prof);
				request.setAttribute("profesor",dto);				
				GroupRepository groups = (GroupRepository) context.getBean("groupRepository");
				Collection groupColl = groups.findByProfesorID(prof.getCedula());
				List groupList = new ArrayList();
				Iterator itr = groupColl.iterator();
				while (itr.hasNext()) {
					Group g = (Group)itr.next();
					GrupoDTO dg = GrupoAssembler.Create(g);
					groupList.add(dg);
				}
				request.setAttribute("groups",groupList);
				forward("/detalleProfesor.jsp",request,response);
			}
			else if(tipoVista.equals("3")){//Eliminar
				String id = request.getParameter("id");
				int idProf = Integer.parseInt(id);
				Profesor prof = profesores.findProfesor(idProf+"");
				ProfesorDTO dto = ProfesorAssembler.Create(prof);
				request.setAttribute("profesor",dto);
				forward("/eliminarProfesor.jsp",request,response);
			}		
			
        } catch (Exception e) {
            request.setAttribute("mensaje",e.getMessage());
            forward("/paginaError.jsp",request,response);
        }
  }
}