package domain.service;

import domain.model.Race;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

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
                    input.get(i).setTotalTime(input.get(i).getTimeLap().getTime()
                            + input.get(j).getTimeLap().getTime());
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
        Collections.sort(input, Comparator.comparingLong(r -> r.getTotalTime()));
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
}
