package Model;

import java.time.LocalDateTime;

public abstract class Rendez_vous implements Comparable<Rendez_vous> {
    private LocalDateTime date;
    private String heure;
    private Type_rendez_vous type;
    private String Observation;

    public Rendez_vous(LocalDateTime date, String heure, Type_rendez_vous type, String observation) {
        this.date = date;
        this.heure = heure;
        this.type = type;
        Observation = observation;
    }

    public Rendez_vous(LocalDateTime date) {
        this.date = date;
    }


    public LocalDateTime getDate() {
        return date;
    }
    public int compareTo(Rendez_vous other) {
        return this.date.compareTo(other.date);
    }

    public String getHeure() {
        return heure;
    }

    public String getType() {
        return String.valueOf(this.type);
    }

    public String getObservation() {
        return Observation;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setType(Type_rendez_vous type) {
        this.type = type;
    }

    public void setObservation(String observation) {
        Observation = observation;
    }
}
