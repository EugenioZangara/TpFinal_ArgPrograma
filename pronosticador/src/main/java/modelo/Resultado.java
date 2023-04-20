package modelo;

public class Resultado {
String resultado;
String descripcion;
int puntaje;
public Resultado(String resultado, String descripcion, int puntaje) {
	super();
	this.resultado = resultado;
	this.descripcion = descripcion;
	this.puntaje = puntaje;
}
public String getResultado() {
	return resultado;
}
public void setResultado(String resultado) {
	this.resultado = resultado;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public int getPuntaje() {
	return puntaje;
}
public void setPuntaje(int puntaje) {
	this.puntaje = puntaje;
}

}
