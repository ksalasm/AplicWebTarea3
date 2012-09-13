package domain;

public class GroupFactory {
  public Group Create(int id,String numero,String sigla,String nombre,String horario,String aula, String cedulaProfesor) {
    try {
      Group group = new Group();
      group.setId(id);
      group.setNumero(numero);
      group.setSigla(sigla);
      group.setNombre(nombre);
      group.setHorario(horario);
      group.setAula(aula);
	  group.setCedulaProfesor(cedulaProfesor);
      return group;
    } catch (Exception e) {
      return null;
    }
  }
}