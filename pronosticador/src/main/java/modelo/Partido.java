package modelo;

public class Partido {
 int id_partido;
 String equipoA;
 String equipoB;
 int golesA;
 int golesB;
 int id_ronda;
public Partido(int id_partido, String equipoA, String equipoB, int golesA, int golesB, int id_ronda) {
	super();
	this.id_partido = id_partido;
	this.equipoA = equipoA;
	this.equipoB = equipoB;
	this.golesA = golesA;
	this.golesB = golesB;
	this.id_ronda = id_ronda;
}
public int getId_partido() {
	return id_partido;
}
public void setId_partido(int id_partido) {
	this.id_partido = id_partido;
}
public String getEquipoA() {
	return equipoA;
}
public void setEquipoA(String equipoA) {
	this.equipoA = equipoA;
}
public String getEquipoB() {
	return equipoB;
}
public void setEquipoB(String equipoB) {
	this.equipoB = equipoB;
}
public int getGolesA() {
	return golesA;
}
public void setGolesA(int golesA) {
	this.golesA = golesA;
}
public int getGolesB() {
	return golesB;
}
public void setGolesB(int golesB) {
	this.golesB = golesB;
}
public int getId_ronda() {
	return id_ronda;
}
public void setId_ronda(int id_ronda) {
	this.id_ronda = id_ronda;
}
}
