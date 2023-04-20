package factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Pronostico;

public class PronosticoInput {
    String csvFile = "C:\\Users\\Zangara\\Documents\\JAVA\\ESPACIO_DE_TRABAJO\\pronostico1.csv";
    String line = "";
    String cvsSplitBy = ";";
    public List<Pronostico> pronosticos = new ArrayList<>();

    public void readData() {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(cvsSplitBy);
                pronosticos.add(new Pronostico(Integer.parseInt(row[0]), Integer.parseInt(row[1]), row[2], row[3], row[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}