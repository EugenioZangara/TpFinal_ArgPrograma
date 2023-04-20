package com.programa.argentina.java.prode.pronosticador;

import java.util.List;

import dao.PartidoDao;
import factory.ConnectionFactory;
import factory.PartidoInput;
import modelo.Partido;

public class Partidos {
	String ruta;

	public Partidos(String ruta) {
		this.ruta = ruta;
	}

	List<Partido> cargarPartidos() {
		ConnectionFactory factory = new ConnectionFactory();
		PartidoDao partidoDao = new PartidoDao(factory.recuperaConexion());
		PartidoInput partidoInput = new PartidoInput(this.ruta);
		List<Partido> partidos = partidoInput.readData();
		for (Partido partido : partidos) {
			partidoDao.actualizarPartido(partido);
		}
		return partidos;
	}

}
