package domain.service;

import domain.model.Race;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IRaceLap {
    List<Race> podium(final List<Race> input);

    HashMap<String, Double> bestRacerLap(final List<Race> input);

    HashMap<String, Double> bestLap(final List<Race> input);

    List<String> averageSpeedRacerLap(final List<Race> input);

    List<String> timeAfterWinner(final List<Race> input);
}
