package modelo;

public class Ronda {
int id_ronda;
String descripcion;
public Ronda(int id_ronda, String descripcion) {
	super();
	this.id_ronda = id_ronda;
	this.descripcion = descripcion;
}
public int getId_ronda() {
	return id_ronda;
}
public void setId_ronda(int id_ronda) {
	this.id_ronda = id_ronda;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

}
