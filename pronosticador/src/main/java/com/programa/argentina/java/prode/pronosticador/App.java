package com.programa.argentina.java.prode.pronosticador;

import modelo.Partido;
import modelo.Pronostico;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class App {
	public static void main(String[] args) throws IOException {
		
		
		
		Scanner scanner = new Scanner(System.in);
		boolean ejecutar=true;
		
				
		do {
		System.out.println("INGRESE SU NOMBRE DE USUARIO: ");
		String nombreUsuario = scanner.nextLine();
		nombreUsuario=nombreUsuario.toUpperCase();
		
		System.out.println(nombreUsuario + ", por favor, ingresa el nombre (solo nombre, sin extensión) del archivo"
				+ "del tipo 'csv' \n con la información de los RESULTADOS de los partidos \ncon el siguiente formato: ");
		System.out.println("* El archivo debe encontrarse en la misma carpeta que el ejecutable");
		
		    System.out.println("+----+----------------+----------------+----------------+--------------+------------+");
		    System.out.println("| id |       Equipo A |    Equipo    B | Goles Equipo A | Goles Equipo B |  Ronda   |");
		    System.out.println("+----+----------------+----------------+----------------+----------------+----------+");
		    System.out.println("|  1 |      ARG       |      USA       |       2        |       1        |  1       |");
		    System.out.println("|  2 |      QAT       |      FRA       |       3        |       2        |  1       |");
		    System.out.println("|  3 |      ING       |      ALE       |       1        |       1        |  2       |");
		    System.out.println("+----+----------------+----------------+----------------+----------------+----------+");

		String rutaArchivoPartidos = scanner.nextLine();
		
		
		

		System.out.println(nombreUsuario + ", por favor, ingresa la ruta hacia el archivo"
				+ "\n del tipo 'csv' con la información de tu PRONÓSTICO: ");
		System.out.println("* El archivo debe encontrarse en la misma carpeta que el ejecutable \ncon el siguiente formato: ");
		
		
		    System.out.println("+----+----------------+----------------+----------------+----------------+");
		    System.out.println("| id |   IdPartido    |    Equipo      | RESULTADO      | USUARIO        |");
		    System.out.println("+----+----------------+----------------+----------------+----------------+");
		    System.out.println("|  1 |      1         |      USA       |       G        |       JUAN     |");
		    System.out.println("|  2 |      2         |      FRA       |       E        |       JUAN     |");
		    System.out.println("|  3 |      3         |      ALE       |       P        |       JUAN     |");
		    System.out.println("+----+----------------+----------------+----------------+----------------+");
		
		String rutaArchivoPronostico = scanner.nextLine();
		
		Partidos partido = new Partidos(rutaArchivoPartidos);//REEMPLAZAR POR LA RUTA DEL ARCHIVO
		List<Partido> partidos = partido.cargarPartidos();
		Pronosticos pronostico = new Pronosticos(rutaArchivoPronostico);
		List<Pronostico> pronosticos = pronostico.cargarPronosticos();

		Puntaje puntaje = new Puntaje(0);
		int puntajeTotal = puntaje.puntajeRonda(partidos, pronosticos);
		Runtime.getRuntime().exec("cmd /c cls");
		System.out.println("+========================================================================+");
		System.out.println("+------------------------------------------------------------------------+");
		System.out.println("PUNTAJE TOTAL obtenidos por " + nombreUsuario +": "+puntajeTotal );
		System.out.println("+------------------------------------------------------------------------+");
		System.out.println("+========================================================================+");
		
		System.out.println("¿Deseas volver a ejecutar el programa? (S/N)");
         String respuesta = scanner.nextLine();
         ejecutar = respuesta.equalsIgnoreCase("S");
         
     } while (ejecutar);
		System.out.println("GRACIAS POR PARTICIPAR!!");
     scanner.close();
 }
}