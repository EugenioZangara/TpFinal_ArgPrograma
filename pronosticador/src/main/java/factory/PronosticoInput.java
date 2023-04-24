package factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Pronostico;

public class PronosticoInput {
    String csvFile ;
    String line = "";
    String cvsSplitBy = ";";
    public List<Pronostico> pronosticos = new ArrayList<>();

    public PronosticoInput(String csvFile) {
        this.csvFile = csvFile+".csv";
    }
    
    
    public List<Pronostico> readData() {
    	try (BufferedReader br = new BufferedReader(new FileReader(new File(csvFile)))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(cvsSplitBy);
                pronosticos.add(new Pronostico(Integer.parseInt(row[0]), row[2], row[3], row[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pronosticos;
    }
}