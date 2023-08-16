import domain.service.PilotService;
import repository.RaceFileReader;

public class Main {
    public static void main(String[] args) {
        RaceFileReader race = new RaceFileReader();
        race.readFile("src/text.txt");
        PilotService runLaps = new PilotService();
        runLaps.podium(race.getCorridas()).forEach(System.out::println);
    }
}