import domain.service.RaceService;
import repository.RaceFileReader;

public class Main {
    public static void main(String[] args) {

        RaceFileReader race = new RaceFileReader();
        race.readFile("src/text.txt");
        RaceService runLaps = new RaceService();

        System.out.println("--------------------------");
        System.out.println("Lista de pilotos com posições: ");
        runLaps.podium(race.getRacerLaps()).forEach(System.out::println);

        System.out.println("--------------------------");
        System.out.println("Lista com a melhor volta de cada piloto: ");
        System.out.println(runLaps.bestRacerLap(race.getRacerLaps()));

        System.out.println("--------------------------");
        System.out.println("A  melhor volta da corrida foi: ");
        System.out.println(runLaps.bestLap(race.getRacerLaps()));

        System.out.println("--------------------------");
        System.out.println("A velocidade media de cada corredor foi: ");
        System.out.println(runLaps.averageSpeedRacerLap(race.getRacerLaps()));

        System.out.println("--------------------------");
        System.out.println("O tempo que cada piloto levou após o vencedor foi: ");
        System.out.println(runLaps.timeAfterWinner(race.getRacerLaps()));
    }
}