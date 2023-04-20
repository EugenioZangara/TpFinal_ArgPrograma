package com.programa.argentina.java.prode.pronosticador;

import java.util.List;

import dao.PronosticoDao;
import factory.ConnectionFactory;
import factory.PronosticoInput;
import modelo.Pronostico;

public class Pronosticos {
	List<Pronostico> cargarPronosticos() {
		ConnectionFactory factory = new ConnectionFactory();
		PronosticoDao pronosticoDao = new PronosticoDao(factory.recuperaConexion());
		PronosticoInput pronosticoInput = new PronosticoInput();
		List<Pronostico> pronosticos = pronosticoInput.readData();
		for (Pronostico pronostico : pronosticos) {
			pronosticoDao.actualizarPronostico(pronostico);
		}
		return pronosticos;
	}
}
