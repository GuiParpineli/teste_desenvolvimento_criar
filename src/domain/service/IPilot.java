package domain.service;

import domain.model.Race;

import java.util.List;

public interface IPilot {
    List<Race> podium(List<Race> input);
}
