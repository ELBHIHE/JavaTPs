package tps.tp2.bankati.modele;

import java.time.LocalDate;
import java.time.LocalTime;

public class Log {
    private LocalDate date;
    private LocalTime temps;
    private TypeLog type;
    private String message;

    public Log(LocalDate date, LocalTime temps, TypeLog type, String message) {
       setDate(date);
       setTemps(temps);
       setType(type);
       setMessage(message);
    }

    public Log(LocalDate date, String message) {
        setDate(date);
        setMessage(message);
     }

    // Getters et Setters
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getTemps() { return temps; }
    public void setTemps(LocalTime temps) { this.temps = temps; }

    public TypeLog getType() { return type; }
    public void setType(TypeLog type) { this.type = type; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @Override
    public String toString() {
        return "Log: " + message + " Date: " + date + " Heure: " + temps;
    }
}
