import domain.service.RaceService;
import repository.RaceFileReader;

public class Main {
    public static void main(String[] args) {

        RaceFileReader race = new RaceFileReader();
        race.readFile("src/text.txt");
        RaceService runLaps = new RaceService();

        System.out.println("Lista de pilotos com posições: ");
        runLaps.podium(race.getRacerLaps()).forEach(System.out::println);

        System.out.println("Lista com a melhor volta de cada piloto: ");
        System.out.println(runLaps.bestRacerLap(race.getRacerLaps()));
    }
}