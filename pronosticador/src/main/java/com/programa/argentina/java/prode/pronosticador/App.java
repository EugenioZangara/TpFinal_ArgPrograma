package com.programa.argentina.java.prode.pronosticador;

import factory.ConnectionFactory;
import factory.PartidoInput;
import factory.PronosticoInput;
import modelo.Partido;
import modelo.Pronostico;

import java.util.List;

import dao.PartidoDao;
import dao.PronosticoDao;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ConnectionFactory factory = new ConnectionFactory();
		PartidoDao partidoDao = new PartidoDao(factory.recuperaConexion());
		PronosticoDao pronosticoDao = new PronosticoDao(factory.recuperaConexion());
		PartidoInput partidoInput = new PartidoInput();
		List<Partido> partidos = partidoInput.readData();

		for (Partido partido : partidos) {
			System.out.println("actualizando");
			System.out.println(partido);
			partidoDao.actualizarPartido(partido);
		}

		PronosticoInput pronosticoInput = new PronosticoInput();
		List<Pronostico> pronosticos = pronosticoInput.readData();
		// PronosticoDao pronosticoDao = new PronosticoDao();
		for (Pronostico pronostico : pronosticos) {
			pronosticoDao.actualizarPronostico(pronostico);
		}

		
	Puntaje puntaje = new Puntaje(0);
	int puntajeTotal = puntaje.puntajeRonda(partidos, pronosticos);	
	System.out.println(puntajeTotal + "este es el puntaje total de la ronda");
	}

	
}
