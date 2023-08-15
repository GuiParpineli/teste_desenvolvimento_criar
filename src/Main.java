import repository.RaceFileReader;

import java.io.File;

public class Main {

    File myObj = new File("src/text.txt");

    public static void main(String[] args) {
        RaceFileReader race = new RaceFileReader();
        race.readFile("src/text.txt");
        System.out.println(race.getCorridas());
    }
}