package domain.model;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Race implements Serializable {
    private String time;
    private double codPilot;
    private String pilotName;
    private int lapNumber;
    private Date timeLap;
    private double averageSpeed;
    private long totalTime;
    private int position;

    public Race(String time, double codPilot, String pilotName, int lapNumber, String timeLap, double averageSpeed) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("mm:ss.SSS");
        Date date = inputFormat.parse(timeLap);
        this.time = time;
        this.codPilot = codPilot;
        this.pilotName = pilotName;
        this.lapNumber = lapNumber;
        this.timeLap = date;
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

    public Date getTimeLap() {
        return timeLap;
    }

    public void setTimeLap(Date timeLap) {
        this.timeLap = timeLap;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
