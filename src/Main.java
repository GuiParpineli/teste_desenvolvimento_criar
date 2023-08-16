import domain.service.RaceService;
import repository.RaceFileReader;

public class Main {
    public static void main(String[] args) {
        RaceFileReader race = new RaceFileReader();
        race.readFile("src/text.txt");
        RaceService runLaps = new RaceService();
        runLaps.podium(race.getRacerLaps()).forEach(System.out::println);
    }
}