package domain;

import java.util.*;

public class Group {
  private int id;
  private String numero;
  private String sigla;
  private String nombre;
  private String horario;
  private String aula;
  private String cedulaProfesor;

  public Group () {  
  Random generator = new Random();
    int idN = generator.nextInt();
	if (idN < 0) idN = idN * -1;
	this.id=idN;	
  };
  public void setId(int id) {this.id=id;}
  public void setNumero(String numero) {this.numero=numero;}
  public void setSigla(String sigla) {this.sigla=sigla;}
  public void setNombre(String nombre) {this.nombre=nombre;}
  public void setHorario(String horario) {this.horario=horario;}
  public void setAula(String aula) {this.aula=aula;}
  public void setCedulaProfesor(String cedulaProfesor) {this.cedulaProfesor=cedulaProfesor;}

  public int getId() {return this.id;}
  public String getNumero() {return this.numero;}
  public String getSigla() {return this.sigla;}
  public String getNombre() {return this.nombre;}
  public String getHorario() {return this.horario;}
  public String getAula() {return this.aula;}
  public String getCedulaProfesor() {return this.cedulaProfesor;}
}