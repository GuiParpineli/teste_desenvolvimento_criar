package domain.service;

import domain.model.Race;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class PilotService implements IPilot {
    @Override
    public List<Race> podium(List<Race> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                if (Objects.equals(input.get(i).getCodPilot(), input.get(j).getCodPilot())) {
                    input.get(i).setTotalTime(input.get(i).getTimeLap().getTime()
                            + input.get(j).getTimeLap().getTime());
                    if (input.get(i).getLapNumber() < input.get(j).getLapNumber()) {
                        input.get(i).setLapNumber(input.get(j).getLapNumber());
                    }
                    input.remove(j);
                    j--;
                }
            }
        }
        Collections.sort(input, Comparator.comparingLong(r -> r.getTimeLap().getTime()));
        for (int i = 0; i < input.size(); i++) {
            input.get(i).setPosition(i + 1);
            if (input.get(i).getLapNumber() < 4) {
                input.get(i).setPosition(input.size());
            }
        }
        return input;
    }
}
