package domain.service;

import domain.model.Race;

import java.util.*;

public class RaceService implements IRaceLap {

    /*
        Por meio de um  loop simples, percorro o array para achar os codigos
        de pilotos iguais e fazer a soma dos dados necessarios.
    */
    @Override
    public List<Race> podium(List<Race> input) {

        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                if (Objects.equals(input.get(i).getCodPilot(), input.get(j).getCodPilot())) {
                    //primeiro eu somo o tempo total das voltas, para assim saber qual teve o menor tempo
                    input.get(i).setTotalTime(input.get(i).getTimeLap()
                            + input.get(j).getTimeLap());
                    //depois eu vejo qual o maior numero da volta e setto ele para assim definir o total de voltas,
                    if (input.get(i).getLapNumber() < input.get(j).getLapNumber()) {
                        input.get(i).setLapNumber(input.get(j).getLapNumber());
                    }
                    input.remove(j);
                    j--;
                }
            }
        }
        //entao ordeno esse array baseando no tempo total  da corrida
        Collections.sort(input, Comparator.comparingLong(r -> r.getTotalTime().longValue()));
        //Ele sendo ordenado, so colocar as posiçoes e caso as voltas forem menor que 4,
        // ele não completou a corrida entao jogo para ultimo lugar
        for (int i = 0; i < input.size(); i++) {
            input.get(i).setPosition(i + 1);
            if (input.get(i).getLapNumber() < 4) {
                input.get(i).setPosition(input.size());
            }
        }
        return input;
    }

    @Override
    public HashMap<String, Double> bestRacerLap(List<Race> input) {
        HashMap<String, Double> bestLap = new HashMap();

        //Aqui uso um bubble sort para conferir o menor tempo e setto
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                if (Objects.equals(input.get(i).getCodPilot(), input.get(j).getCodPilot())) {
                    if (input.get(i).getTimeLap() < input.get(j).getTimeLap()) {
                        input.get(i).setTimeLap(input.get(j).getTimeLap());
                    }
                    input.remove(j);
                    j--;
                }
            }
        }

        //obtendo o melhor tempo, so fazer um loop para exbir os dados de melhor forma em um hashmap
        for (Race race : input) {
            String racerName = race.getPilotName();
            Double lapTime = race.getTimeLap();

            if (!bestLap.containsKey(racerName)) {
                bestLap.put(racerName, lapTime);
            }
        }

        return bestLap;
    }


    @Override
    public String bestLap(List<Race> input) {
        return null;
    }

    @Override
    public List<String> averageSpeedRacerLap(List<Race> input) {
        return null;
    }

    @Override
    public List<String> timeAfterWinner(List<Race> input) {
        return null;
    }
}
