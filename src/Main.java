import domain.service.PilotService;
import repository.RaceFileReader;

import java.io.File;

public class Main {

    File myObj = new File("src/text.txt");

    public static void main(String[] args) {
        RaceFileReader race = new RaceFileReader();
        race.readFile("src/text.txt");

        PilotService podium = new PilotService();
        System.out.println(podium.podium(race.getCorridas()));
    }
}