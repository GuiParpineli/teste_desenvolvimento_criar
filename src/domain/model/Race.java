package domain.model;


import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalTime;

public class Race implements Serializable {
    private String time;
    private double codPilot;
    private String pilotName;
    private int lapNumber;
    private LocalTime timeLap;
    private double averageSpeed;
    private LocalTime totalTime = LocalTime.of(00,00,00,0000);
    private int position;

    public Race(String time, double codPilot, String pilotName, int lapNumber, LocalTime timeLap, double averageSpeed)  {
        this.time = time;
        this.codPilot = codPilot;
        this.pilotName = pilotName;
        this.lapNumber = lapNumber;
        this.timeLap = timeLap;
        this.averageSpeed = averageSpeed;
    }

    @Override
    public String toString() {
        return " {" + '\n' +
                " Posição Chegada = '" + position + "'" + '\n' +
                " Código Piloto = '" + codPilot + "'" + '\n' +
                " Nome Piloto = '" + pilotName + "'" + '\n' +
                " Qtde Voltas Completadas = '" + lapNumber + "'" + '\n' +
                " Tempo Total de Prova = '" + totalTime + "'" + '\n' +
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

    public LocalTime getTimeLap() {
        return timeLap;
    }

    public void setTimeLap(LocalTime timeLap) {
        this.timeLap = timeLap;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }


    public LocalTime getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(LocalTime totalTime) {
        this.totalTime = totalTime;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
