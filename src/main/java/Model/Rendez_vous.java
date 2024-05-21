package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Rendez_vous implements Comparable<Rendez_vous>, Serializable {
    private LocalDate date;
    private String heure;
    private Type_rendez_vous type;
    private String Observation;

    public Rendez_vous(LocalDate date, String heure, Type_rendez_vous type) {
        this.date = date;
        this.heure = heure;
        this.type = type;

    }

    public Rendez_vous(LocalDate date) {
        this.date = date;
    }

    protected Rendez_vous() {
    }

    public Rendez_vous(LocalDate date, String heure, Type_rendez_vous type, String observation) {
    }

    public LocalDate getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public Enum<Type_rendez_vous> getType() {
        return type;
    }

    public String getObservation() {
        return Observation;
    }

    public void setDate(LocalDate date) {
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
    @Override
    public int compareTo(Rendez_vous other) {
        return this.date.compareTo(other.getDate());
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rendez_vous that = (Rendez_vous) o;
        return Objects.equals(date, that.date);
    }
    public abstract String getDuree();

    public abstract String getPatientName();


}
