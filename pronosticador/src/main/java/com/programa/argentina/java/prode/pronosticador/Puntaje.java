package com.programa.argentina.java.prode.pronosticador;

import java.util.List;

import modelo.Partido;
import modelo.Pronostico;

public class Puntaje {
	int puntajeObtenido;
	int puntajePorGanar = 3;
	int puntajePorEmpate = 1;

	public Puntaje(int puntajeObtenido) {
		this.puntajeObtenido = puntajeObtenido;
	}

	public int getPuntajeObtenido() {
		return puntajeObtenido;
	}

	public void setPuntajeObtenido(int puntajeObtenido) {
		this.puntajeObtenido = puntajeObtenido;
	}

	public int obtenerPuntaje(Partido partido, Pronostico pronostico) {

		String ganador;
		int puntaje = 0;
		

		if (partido.getGolesA() > partido.getGolesB()) {
			ganador = partido.getEquipoA();
		} else if (partido.getGolesA() < partido.getGolesB()) {
			ganador = partido.getEquipoB();
		} else {
			ganador = "E";
		}
		if (pronostico.getResultado().equals("G")) {

			if (pronostico.getEquipo().equals(ganador)) {
				puntaje = this.puntajePorGanar;
			}
		} else if (pronostico.getResultado().equals("P")) {
			if (pronostico.getEquipo() != ganador) {
				puntaje = this.puntajePorGanar;
			}
		} else if (pronostico.getResultado().equals("E")) {
			if (ganador.equals("E")) {
				puntaje = this.puntajePorEmpate;
			}
		}

		return puntaje;
	}

	public int puntajeRonda(List<Partido> partidos, List<Pronostico> pronosticos) {
		int puntajeTotal = 0;
		for (Partido partido : partidos) {
			for (Pronostico pronostico : pronosticos) {
				if (partido.getId_partido() == pronostico.getIdPartido()) {
					puntajeTotal += obtenerPuntaje(partido, pronostico);
					
				}
			}
		}
		return puntajeTotal;
	}
}
