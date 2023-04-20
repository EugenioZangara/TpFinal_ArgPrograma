package modelo;

public class Equipo {
String codigo_iso;
String nombre;

public Equipo(String codigo_iso, String nombre) {
	this.codigo_iso = codigo_iso;
	this.nombre = nombre;
}

public String getCodigo_iso() {
	return codigo_iso;
}
public void setCodigo_iso(String codigo_iso) {
	this.codigo_iso = codigo_iso;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}

}
