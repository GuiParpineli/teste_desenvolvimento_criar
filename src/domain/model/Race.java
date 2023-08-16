package domain.model;


import java.io.Serializable;
import java.text.ParseException;

public class Race implements Serializable {
    private String time;
    private double codPilot;
    private String pilotName;
    private int lapNumber;
    private Double timeLap;
    private double averageSpeed;
    private Double totalTime;
    private int position;

    public Race(String time, double codPilot, String pilotName, int lapNumber, String timeLap, double averageSpeed) throws ParseException {
        String formattedTime = timeLap.replace(":", "");
        this.time = time;
        this.codPilot = codPilot;
        this.pilotName = pilotName;
        this.lapNumber = lapNumber;
        this.timeLap = Double.parseDouble(formattedTime);
        this.averageSpeed = averageSpeed;
    }

    @Override
    public String toString() {
        return " {" + '\n' +
                " Posição Chegada = '" + position + "'" + '\n' +
                " Código Piloto = '" + codPilot + "'" + '\n' +
                " Nome Piloto = '" + pilotName + "'" + '\n' +
                " Qtde Voltas Completadas = '" + lapNumber + "'" + '\n' +
                " Tempo Total de Prova = '" + timeLap + "'" + '\n' +
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

    public Double getTimeLap() {
        return timeLap;
    }

    public void setTimeLap(Double timeLap) {
        this.timeLap = timeLap;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public Double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Double totalTime) {
        this.totalTime = totalTime;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
