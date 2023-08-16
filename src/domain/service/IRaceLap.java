package domain.service;

import domain.model.Race;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IRaceLap {
    List<Race> podium(final List<Race> input);

    HashMap<String, LocalTime> bestRacerLap(final List<Race> input);

    HashMap<String, LocalTime> bestLap(final List<Race> input);

    HashMap<String, Double> averageSpeedRacerLap(final List<Race> input);

    List<String> timeAfterWinner(final List<Race> input);
}
