package pruebas;
import factory.PartidoInput;
import modelo.Partido;


public class PruebaDataInput {
    public static void main(String[] args) {
        PartidoInput dataInput = new PartidoInput();
        dataInput.readData();

        for (Partido partido : dataInput.partidos) {
            System.out.println(partido.getEquipoA() + " vs " + partido.getEquipoB());
        }
    }
}