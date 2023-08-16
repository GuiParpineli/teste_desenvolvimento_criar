package repository;

import domain.model.Race;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RaceFileReader implements IReader {
    List<Race> races = new ArrayList<>();

    @Override
    public void readFile(String patch) {
        try {
            final File obj = new File(patch);
            final Scanner scanner = new Scanner(obj);
/*
             depois de scannear vai ler linha a linha e separar em um vetor cada parte assim que
            um espaço for encontrado, assim da para salvar na variavel cada dado encontrado
*/
            while (scanner.hasNextLine()) {
                final String data = scanner.nextLine();
                final String[] split = data.split(" ");
                final String time = split[0];
                final int codPilot = Integer.parseInt(split[1].substring(0, 3));
                final String pilotName = split[3];
                final int lapNumber = Integer.parseInt(split[4]);
                final String timeLap = split[5];
                final double averageSpeed = Double.parseDouble(split[6]
                        .replace(",", "."));
                races.add(new Race(time, codPilot, pilotName, lapNumber, timeLap, averageSpeed));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Race> getCorridas() {
        return races;
    }
}
