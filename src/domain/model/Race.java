package domain.model;


import java.io.Serializable;

public class Race implements Serializable {
    private String time;
    private double codPilot;
    private String pilotName;
    private int lapNumber;
    private String timeLap;
    private double averageSpeed;

    public Race(String time, double codPilot, String pilotName, int lapNumber, String timeLap, double averageSpeed) {
        this.time = time;
        this.codPilot = codPilot;
        this.pilotName = pilotName;
        this.lapNumber = lapNumber;
        this.timeLap = timeLap;
        this.averageSpeed = averageSpeed;
    }

    @Override
    public String toString() {
        return "Race{" +
                "tempo='" + time + '\'' +
                ", codPiloto=" + codPilot +
                ", nomePiloto='" + pilotName + '\'' +
                ", numVolta=" + lapNumber +
                ", TempoVolta='" + timeLap + '\'' +
                ", velocidadeMedia=" + averageSpeed +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getCodPilot() {
        return codPilot;
    }

    public void setCodPilot(double codPilot) {
        this.codPilot = codPilot;
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public int getLapNumber() {
        return lapNumber;
    }

    public void setLapNumber(int lapNumber) {
        this.lapNumber = lapNumber;
    }

    public String getTimeLap() {
        return timeLap;
    }

    public void setTimeLap(String timeLap) {
        this.timeLap = timeLap;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }
}
