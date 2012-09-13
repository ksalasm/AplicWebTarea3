package domain;

public class ProfesorFactory {

  public Profesor Create(int id,String cedula,String nombre,String titulo,String area,String telefono) {
    try {
      Profesor prof = new Profesor();
      prof.setId(id);
      prof.setCedula(cedula);
      prof.setNombre(nombre);
      prof.setTitulo(titulo);
      prof.setArea(area);
      prof.setTelefono(telefono);
      return prof;
    } catch (Exception e) {
      return null;
    }
  }
}