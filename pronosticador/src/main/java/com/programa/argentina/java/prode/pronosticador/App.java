package com.programa.argentina.java.prode.pronosticador;

import modelo.Partido;
import modelo.Pronostico;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Scanner;


public class App {
	public static void main(String[] args) {
		
		
		
		Scanner scanner = new Scanner(System.in);
		boolean ejecutar=true;
		
				
		do {
		System.out.println("INGRESE SU NOMBRE DE USUARIO: ");
		String nombreUsuario = scanner.nextLine();
		nombreUsuario=nombreUsuario.toUpperCase();
		System.out.println(nombreUsuario + ", por favor, ingresa el nombre (solo nombre, sin extensión) del archivo"
				+ "del tipo 'csv' \n con la información de los resultados de los partidos: ");
		System.out.println("* El archivo debe encontrarse en la misma carpeta que el ejecutable");
		String rutaArchivoPartidos = scanner.nextLine();
		
		
		

		System.out.println(nombreUsuario + ", por favor, ingresa la ruta hacia el archivo"
				+ "\n del tipo 'csv' con la información de tu pronóstico: ");
		System.out.println("* El archivo debe encontrarse en la misma carpeta que el ejecutable");
		String rutaArchivoPronostico = scanner.nextLine();
		
		Partidos partido = new Partidos("../"+rutaArchivoPartidos+".csv");//REEMPLAZAR POR LA RUTA DEL ARCHIVO
		List<Partido> partidos = partido.cargarPartidos();
		Pronosticos pronostico = new Pronosticos("../"+rutaArchivoPronostico+".csv");
		List<Pronostico> pronosticos = pronostico.cargarPronosticos();

		Puntaje puntaje = new Puntaje(0);
		int puntajeTotal = puntaje.puntajeRonda(partidos, pronosticos);
		System.out.println("Puntaje total de la ronda, obtenidos por " + nombreUsuario +": "+puntajeTotal );
		 System.out.println("¿Deseas volver a ejecutar el programa? (S/N)");
         String respuesta = scanner.nextLine();
         ejecutar = respuesta.equalsIgnoreCase("S");
         
     } while (ejecutar);
		System.out.println("GRACIAS POR PARTICIPAR!!");
     scanner.close();
 }
}