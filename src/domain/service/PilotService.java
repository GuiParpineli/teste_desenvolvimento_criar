package domain.service;

import domain.model.Race;

import java.util.*;

public class PilotService implements IPilot {

    @Override
    public List<Race> podium(List<Race> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                if (Objects.equals(input.get(i).getCodPilot(), input.get(j).getCodPilot())) {
                    input.get(i).setTotalTime(input.get(i).getTimeLap().getTime()
                            + input.get(j).getTimeLap().getTime());
                    input.remove(j);
                    j--;
                }
            }
        }
        Collections.sort(input, Comparator.comparingLong(r -> r.getTimeLap().getTime()));
        return input;
    }
}
