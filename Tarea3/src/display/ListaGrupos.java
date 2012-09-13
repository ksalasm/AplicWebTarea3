package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.GroupRepository;
import domain.Group;

public class ListaGrupos extends PageController {

  public void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
    
	GroupRepository groups = (GroupRepository) context.getBean("groupRepository");
    try {
            Collection lista = groups.findAllGroup();
            List data = new ArrayList();
            Iterator itr = lista.iterator();
            while (itr.hasNext()) {
                Group group = (Group)itr.next();
                GroupDTO dto = GroupAssembler.Create(group);
                data.add(dto);
            }
			request.setAttribute("groups",data);
			forward("/listaGrupos.jsp",request,response);
        } catch (Exception e) {
            request.setAttribute("mensaje",e.getMessage());
            forward("/paginaError.jsp",request,response);
        }
  }
}