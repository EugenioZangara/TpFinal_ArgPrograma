package modelo;

public class Pronostico {
int idPronostico;
int idPartido;
String equipo;
String resultado;
String usuario;
public Pronostico(int idPronostico, int idPartido, String equipo, String resultado, String usuario) {
	super();
	this.idPronostico = idPronostico;
	this.idPartido = idPartido;
	this.equipo = equipo;
	this.resultado = resultado;
	this.usuario = usuario;
}
public int getIdPronostico() {
	return idPronostico;
}
public void setIdPronostico(int idPronostico) {
	this.idPronostico = idPronostico;
}
public int getIdPartido() {
	return idPartido;
}
public void setIdPartido(int idPartido) {
	this.idPartido = idPartido;
}
public String getEquipo() {
	return equipo;
}
public void setEquipo(String equipo) {
	this.equipo = equipo;
}
public String getResultado() {
	return resultado;
}
public void setResultado(String resultado) {
	this.resultado = resultado;
}
public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}

}
