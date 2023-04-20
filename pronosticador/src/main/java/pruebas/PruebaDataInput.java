package pruebas;
import factory.PartidoInput;
import factory.PronosticoInput;
import modelo.Partido;
import modelo.Pronostico;


public class PruebaDataInput {
    public static void main(String[] args) {
        PartidoInput dataInput = new PartidoInput();
        PronosticoInput pronosticos= new PronosticoInput();
        
        dataInput.readData();
        pronosticos.readData();

        for (Partido partido : dataInput.partidos) {
            System.out.println(partido.getEquipoA() + " vs " + partido.getEquipoB());
            
        }
        for (Pronostico pronostico : pronosticos.pronosticos) {
            System.out.println(pronostico.getEquipo() + " resultado: " + pronostico.getResultado());
    }
}
    }