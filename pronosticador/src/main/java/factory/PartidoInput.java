package factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Partido;

public class PartidoInput {
    String csvFile = "../partidos.csv";
    String line = "";
    String cvsSplitBy = ";";
    public List<Partido> partidos = new ArrayList<>();

    public List<Partido> readData() {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(cvsSplitBy);
                partidos.add(new Partido(Integer.parseInt(row[0]), row[1], row[2], Integer.parseInt(row[3]), Integer.parseInt(row[4]), Integer.parseInt(row[5])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return partidos;
    }
}