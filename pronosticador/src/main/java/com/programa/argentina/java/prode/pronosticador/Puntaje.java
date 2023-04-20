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
			System.out.println("ganoA");
		} else if (partido.getGolesA() < partido.getGolesB()) {
			ganador = partido.getEquipoB();
			System.out.println("ganoB");
		} else {
			ganador = "E";
			System.out.println("empate");
		}
		System.out.println("este es el pronostico: " + pronostico.getEquipo() + " : " + pronostico.getResultado());
		System.out.println("este es el resultado: " + ganador);
		if (pronostico.getResultado().equals("G")) {

			if (pronostico.getEquipo().equals(ganador)) {
				puntaje = this.puntajePorGanar;
			}
		} else if (pronostico.getResultado().equals("P")) {
			if (pronostico.getEquipo() != ganador) {
				puntaje = this.puntajePorGanar;
			}
		} else if (pronostico.getResultado().equals("E")) {
			System.out.println("ENTRO POR EL EMPATEEEEEE");
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
					System.out.println("obtener puntaje=" + obtenerPuntaje(partido, pronostico));
					System.out.println("puntaje total:" + puntajeTotal);
				}
			}
		}
		return puntajeTotal;
	}
}
