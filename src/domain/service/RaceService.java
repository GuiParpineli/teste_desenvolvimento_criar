package domain.service;

import domain.model.Race;

import java.util.*;

public class RaceService implements IRaceLap {

    /*
        Por meio de um  loop simples, percorro o array para achar os codigos
        de pilotos iguais e fazer a soma dos dados necessarios.
    */
    @Override
    public List<Race> podium(final List<Race> input) {

        //em todos metodos criei uma copia para garantir a imutabilidade
        List<Race> inputCopy = new ArrayList<>(input);

        for (int i = 0; i < inputCopy.size(); i++) {
            for (int j = i + 1; j < inputCopy.size(); j++) {
                if (Objects.equals(inputCopy.get(i).getCodPilot(), inputCopy.get(j).getCodPilot())) {
                    //primeiro eu somo o tempo total das voltas, para assim saber qual teve o menor tempo
                    inputCopy.get(i).setTotalTime(inputCopy.get(i).getTimeLap()
                            + inputCopy.get(j).getTimeLap());
                    //depois eu vejo qual o maior numero da volta e setto ele para assim definir o total de voltas,
                    if (inputCopy.get(i).getLapNumber() < inputCopy.get(j).getLapNumber()) {
                        inputCopy.get(i).setLapNumber(inputCopy.get(j).getLapNumber());
                    }
                    inputCopy.remove(j);
                    j--;
                }
            }
        }
        //entao ordeno esse array baseando no tempo total  da corrida
        Collections.sort(inputCopy, Comparator.comparingLong(r -> r.getTotalTime().longValue()));
        //Ele sendo ordenado, so colocar as posiçoes e caso as voltas forem menor que 4,
        // ele não completou a corrida entao jogo para ultimo lugar
        for (int i = 0; i < inputCopy.size(); i++) {
            inputCopy.get(i).setPosition(i + 1);
            if (inputCopy.get(i).getLapNumber() < 4) {
                inputCopy.get(i).setPosition(inputCopy.size());
            }
        }
        return inputCopy;
    }

    @Override
    public HashMap<String, Double> bestRacerLap(final List<Race> input) {
        List<Race> inputCopy = new ArrayList<>(input);
        HashMap<String, Double> bestLap = new HashMap();
        //Aqui uso um bubble sort para conferir o menor tempo e setto
        for (int i = 0; i < inputCopy.size(); i++) {
            for (int j = i + 1; j < inputCopy.size(); j++) {
                if (Objects.equals(inputCopy.get(i).getCodPilot(), inputCopy.get(j).getCodPilot())) {
                    if (inputCopy.get(i).getTimeLap() > inputCopy.get(j).getTimeLap()) {
                        inputCopy.get(i).setTimeLap(inputCopy.get(j).getTimeLap());
                    }
                    inputCopy.remove(j);
                    j--;
                }
            }
        }

        //obtendo o melhor tempo, so fazer um loop para exbir os dados de melhor forma em um hashmap
        for (Race race : inputCopy) {
            String racerName = race.getPilotName();
            Double lapTime = race.getTimeLap();
            if (!bestLap.containsKey(racerName)) {
                bestLap.put(racerName, lapTime);
            }
        }

        return bestLap;
    }


    @Override
    public HashMap<String, Double> bestLap(final List<Race> input) {

        List<Race> inputCopy = new ArrayList<>(input);
        HashMap<String, Double> bestLap = new HashMap();

        //a logica e a mesma do anterior, mas aqui eu uso o Math.min pra achar o menor
        for (int i = 0; i < inputCopy.size(); i++) {
            for (int j = i + 1; j < inputCopy.size(); j++) {
                if (Objects.equals(inputCopy.get(i).getCodPilot(), inputCopy.get(j).getCodPilot())) {
                    bestLap.put(inputCopy.get(i).getPilotName(), Math.min(inputCopy.get(i).getTimeLap(), inputCopy.get(j).getTimeLap()));
                }
                inputCopy.remove(j);
                j--;
            }
        }

        for (Race race : inputCopy) {
            String racerName = race.getPilotName();
            Double lapTime = race.getTimeLap();

            if (!bestLap.containsKey(racerName)) {
                bestLap.put(racerName, lapTime);
            }
        }

        return bestLap;
    }

    @Override
    public List<String> averageSpeedRacerLap(final List<Race> input) {
        return null;
    }

    @Override
    public List<String> timeAfterWinner(final List<Race> input) {
        return null;
    }
}
