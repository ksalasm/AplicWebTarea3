package domain;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class ProfesorRepository {

  private Map<String,Profesor> profesores;

  ProfesorRepository() {
    profesores = new HashMap<String,Profesor>();
  }
  public boolean insertProfesor(Profesor prof) {
    if (profesores.containsKey(prof.getId()))
      return false;
    else
      profesores.put(prof.getId()+"",prof);
    return true;
  }
  public boolean deleteProfesor(Profesor prof) {
    if (!profesores.containsKey(prof.getId()+""))
      return false;
    else
      profesores.remove(prof.getId()+"");
    return true;
  }
  public Profesor findProfesor(String id) {
    if (!profesores.containsKey(id))
      return null;
    else
      return profesores.get(id);
  }
  public boolean updateProfesor(Profesor prof) {
    if (!profesores.containsKey(prof.getId()+""))
      return false;
    else
      profesores.put(prof.getId()+"",prof);
    return true;
  }
  public Collection findAllProfesor() {
    return profesores.values();
  }
  public void setProfesores(Map profesores) {
    this.profesores = profesores;
  }
}