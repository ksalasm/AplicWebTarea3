package display;

import domain.Group;

public class GroupAssembler {
  public static GroupDTO Create(Group grupo) {
    GroupDTO dto = new GroupDTO();
    dto.id = grupo.getId();
    dto.numero = grupo.getNumero();
    dto.sigla = grupo.getSigla();
    dto.nombre = grupo.getNombre();
    dto.horario = grupo.getHorario();
    dto.aula = grupo.getAula();
	dto.cedulaProfesor = grupo.getCedulaProfesor();
    return dto;
  }
}