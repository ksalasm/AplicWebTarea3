package display;

import domain.Profesor;

public class ProfesorAssembler {
  public static ProfesorDTO Create(Profesor prof) {
    ProfesorDTO dto = new ProfesorDTO();
    dto.id = prof.getId();
    dto.cedula = prof.getCedula();
    dto.nombre = prof.getNombre();
    dto.titulo = prof.getTitulo();
    dto.area = prof.getArea();
    dto.telefono = prof.getTelefono();
    return dto;
  }
}