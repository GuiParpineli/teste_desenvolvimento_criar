package domain.service;

import domain.model.Race;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IRaceLap {
    List<Race> podium(List<Race> input);

    HashMap<String, Double> bestRacerLap(List<Race> input);

    String bestLap(List<Race> input);

    List<String> averageSpeedRacerLap(List<Race> input);

    List<String> timeAfterWinner(List<Race> input);
}
