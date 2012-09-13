package domain;

import java.util.*;

public class Profesor {
  private int id;
  private String cedula;
  private String nombre;
  private String titulo;
  private String area;
  private String telefono;

  public Profesor () {  
    Random generator = new Random();
    int newId = generator.nextInt();
	if (newId < 0) newId = newId * -1;
	this.id = newId;	
  };
  //SET's
  public void setId(int id) {this.id=id;}
  public void setCedula(String cedula) {this.cedula=cedula;}
  public void setNombre(String nombre) {this.nombre=nombre;}
  public void setTitulo(String titulo) throws Exception {
    if (titulo.toLowerCase().equals("bachiller") ||
        titulo.toLowerCase().equals("licenciado") ||
        titulo.toLowerCase().equals("master") ||
        titulo.toLowerCase().equals("doctor"))
      this.titulo=titulo;
    else
      throw new Exception("Error en título de profesor");
  }
  public void setArea(String area) {this.area=area;}
  public void setTelefono(String telefono) {this.telefono=telefono;}
  //GET's
  public int getId() {return id;}
  public String getCedula() {return cedula;}
  public String getNombre() {return nombre;}
  public String getTitulo() {return titulo;}
  public String getArea() {return area;}
  public String getTelefono() {return telefono;}
}