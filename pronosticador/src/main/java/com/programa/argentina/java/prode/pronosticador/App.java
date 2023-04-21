package com.programa.argentina.java.prode.pronosticador;

import modelo.Partido;
import modelo.Pronostico;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("INGRESE SU NOMBRE DE USUARIO: ");
		String nombreUsuario = scanner.nextLine();
		System.out.println(nombreUsuario);
		System.out.println(nombreUsuario + ", por favor, ingresa la ruta hacia el archivo"
				+ "del tipo 'csv' con la información de los resultados de los partidos: ");
		
		String rutaArchivoPronostico = scanner.nextLine();
		
		

		System.out.println(nombreUsuario + ", por favor, ingresa la ruta hacia el archivo"
				+ "del tipo 'csv' con la información de tu pronóstico: ");
		
		String rutaArchivoPartidos = scanner.nextLine();
		
		Partidos partido = new Partidos("../partidos.csv");//REEMPLAZAR POR LA RUTA DEL ARCHIVO
		List<Partido> partidos = partido.cargarPartidos();
		Pronosticos pronostico = new Pronosticos("../pronostico1.csv");
		List<Pronostico> pronosticos = pronostico.cargarPronosticos();

		Puntaje puntaje = new Puntaje(0);
		int puntajeTotal = puntaje.puntajeRonda(partidos, pronosticos);
		System.out.println("Puntaje total de la ronda, obtenidos por " + nombreUsuario +": "+puntajeTotal );
	}

}
