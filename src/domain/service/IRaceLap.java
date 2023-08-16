package domain.service;

import domain.model.Race;

import java.util.List;

public interface IRaceLap {
    List<Race> podium(List<Race> input);
}
