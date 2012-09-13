package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.GroupRepository;
import domain.Group;

import domain.ProfesorRepository;
import domain.Profesor;

public class DetalleGrupo extends PageController {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
	GroupRepository grupos = (GroupRepository) context.getBean("groupRepository");
    try {
			String tipoVista = request.getParameter("vista");
			
			ProfesorRepository profesores = (ProfesorRepository) context.getBean("profesorRepository");
			Collection lista = profesores.findAllProfesor();
			List data = new ArrayList();
			Iterator itr = lista.iterator();
			while (itr.hasNext()) {
				Profesor prof = (Profesor)itr.next();
				ProfesorDTO dto = ProfesorAssembler.Create(prof);
				data.add(dto);
			}
			request.setAttribute("profesores",data);
			
			if(tipoVista.equals("1")){//Agregar				
				forward("/agregarGrupo.jsp",request,response);
			}
			else if(tipoVista.equals("2")){//Modificar
				String id = request.getParameter("id");
				int idGrupo = Integer.parseInt(id);
				Group grupo = grupos.findGroup(idGrupo+"");
				GroupDTO dto = GroupAssembler.Create(grupo);
				request.setAttribute("edicion",request.getParameter("edicion"));
				request.setAttribute("grupo",dto);
				forward("/detalleGrupo.jsp",request,response);
			}
			else if(tipoVista.equals("3")){//Eliminar
				String id = request.getParameter("id");
				int idGrupo = Integer.parseInt(id);
				Group grupo = grupos.findGroup(idGrupo+"");
				GroupDTO dto = GroupAssembler.Create(grupo);
				request.setAttribute("grupo",dto);
				forward("/eliminarGrupo.jsp",request,response);
			}		
			
        } catch (Exception e) {
            request.setAttribute("mensaje",e.getMessage());
            forward("/paginaError.jsp",request,response);
        }
  }
}