import domain.service.PilotService;
import repository.RaceFileReader;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        RaceFileReader race = new RaceFileReader();
        race.readFile("src/text.txt");

        PilotService podium = new PilotService();
        podium.podium(race.getCorridas()).forEach(System.out::println);
    }
}