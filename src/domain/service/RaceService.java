package domain.service;

import domain.model.Race;

import java.time.Duration;
import java.time.LocalTime;
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
            inputCopy.get(i).setTotalTime(inputCopy.get(i).getTimeLap());
            for (int j = i + 1; j < inputCopy.size(); j++) {
                if (inputCopy.get(i).getCodPilot() == inputCopy.get(j).getCodPilot()) {
                    //primeiro eu somo o tempo total das voltas, para assim saber qual teve o menor tempo

                    inputCopy.get(i).setTotalTime(
                            inputCopy.get(i).getTotalTime()
                                    .plusHours(inputCopy.get(j).getTimeLap().getHour())
                                    .plusMinutes(inputCopy.get(j).getTimeLap().getMinute())
                                    .plusSeconds(inputCopy.get(j).getTimeLap().getSecond())
                                    .plusNanos(inputCopy.get(j).getTimeLap().getNano())
                    );

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
        inputCopy.sort(Comparator.comparing(Race::getTotalTime));
        //Ele sendo ordenado, so colocar as posiçoes e caso as voltas forem menor que 4,
        // ele não completou a corrida entao jogo para ultimo lugar
        for (int i = 0; i < inputCopy.size(); i++) {
            inputCopy.get(i).setPosition(String.valueOf(i +1));
            if (inputCopy.get(i).getLapNumber() < 4) {
                inputCopy.get(i).setPosition("Não Completou");
            }
        }
        return inputCopy;
    }

    @Override
    public HashMap<String, LocalTime> bestRacerLap(final List<Race> input) {
        List<Race> inputCopy = new ArrayList<>(input);
        HashMap<String, LocalTime> bestLap = new HashMap<>();

        //Aqui uso um bubble sort para conferir o menor tempo e seta-lo no hashmap
        for (int i = 0; i < inputCopy.size(); i++) {
            for (int j = i + 1; j < inputCopy.size(); j++) {
                if (inputCopy.get(i).getCodPilot() == inputCopy.get(j).getCodPilot()) {
                    if (inputCopy.get(i).getTimeLap().isBefore(inputCopy.get(j).getTimeLap())) {
                        bestLap.put(inputCopy.get(i).getPilotName(), inputCopy.get(i).getTimeLap());
                    } else {
                        bestLap.put(inputCopy.get(i).getPilotName(), inputCopy.get(j).getTimeLap());
                    }
                    inputCopy.remove(j);
                    j--;
                }
            }
        }

        return bestLap;
    }


    @Override
    public HashMap<String, LocalTime> bestLap(final List<Race> input) {

/*
        neste caso, apenas preciso ver o menor tempo do array, entao posso instaciar o MAX so para conseguir
         ir comparando os valores que vao sendo colocados no atributo
*/
        List<Race> inputCopy = new ArrayList<>(input);
        LocalTime smallest = LocalTime.MAX;
        HashMap<String, LocalTime> bestLap = new HashMap<>();

        for (Race lap : inputCopy) {
            if (lap.getTimeLap().isBefore(smallest)) {
                smallest = lap.getTimeLap();
                bestLap.put(lap.getPilotName(), smallest);
            }
        }

        return bestLap;
    }

    @Override
    public HashMap<String, Double> averageSpeedRacerLap(final List<Race> input) {

        List<Race> inputCopy = new ArrayList<>(input);
        HashMap<String, Double> avgSpeed = new HashMap<>();
        //praticamente mesmo algoritimo usado em casos acima, somente adaptando ao contexto
        for (int i = 0; i < inputCopy.size(); i++) {
            inputCopy.get(i).setRaceAverageSpeed(inputCopy.get(i).getAverageSpeed());
            for (int j = i + 1; j < inputCopy.size(); j++) {
                if (inputCopy.get(i).getCodPilot() == inputCopy.get(j).getCodPilot()) {
                    inputCopy.get(i).setRaceAverageSpeed(
                            (inputCopy.get(i).getRaceAverageSpeed() + inputCopy.get(j).getAverageSpeed())
                    );
                    inputCopy.remove(j);
                    j--;
                    if (inputCopy.get(i).getLapNumber() > inputCopy.get(j).getLapNumber()) {
                        avgSpeed.put(inputCopy.get(i).getPilotName(), inputCopy.get(i).getRaceAverageSpeed() / inputCopy.get(i).getLapNumber());
                    } else {
                        avgSpeed.put(inputCopy.get(i).getPilotName(), inputCopy.get(i).getRaceAverageSpeed() / inputCopy.get(j).getLapNumber());
                    }
                }
            }
        }
        return avgSpeed;
    }

    @Override
    public HashMap<String, Long> timeAfterWinner(final List<Race> input) {
/*
        Aqui é mais simples, apenas um loop no array checando a duração
         entre o primeiro colocado(winnerTime) e o atual do array
*/
        List<Race> raceList = podium(input);
        LocalTime winnerTime = raceList.get(0).getTotalTime();
        HashMap<String, Long> timeAfterWinList = new HashMap<>();
        for (Race x : raceList) {
            timeAfterWinList.put(x.getPilotName(), Duration.between(winnerTime, x.getTotalTime()).toMillis());
        }
        return timeAfterWinList;
    }
}
